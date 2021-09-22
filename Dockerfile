FROM ubuntu:latest

# Create a user
ENV NB_USER=jovyan
ENV NB_UID=1000
ENV HOME=/home/$NB_USER

RUN adduser --disabled-password \
    --gecos "Default user" \
    --uid $NB_UID \
    $NB_USER

WORKDIR $HOME

# Disable interactive console
ENV DEBIAN_FRONTEND noninteractive

# Install all required packages
RUN apt update && apt install -y python3-pip default-jdk-headless curl unzip

# Add requirements.txt and requirements_binder.txt to the container
COPY requirements.txt .
COPY requirements_binder.txt .

# Install requirements
RUN ([ -f requirements.txt ] \
    && pip3 install --no-cache-dir -r requirements_binder.txt) \
        || pip3 install --no-cache-dir jupyter jupyterlab jupyter-client

# Download the kernel release
RUN curl -L https://github.com/SpencerPark/IJava/releases/download/v1.3.0/ijava-1.3.0.zip > ijava-kernel.zip

# Unpack and install the kernel
RUN unzip ijava-kernel.zip -d ijava-kernel \
  && cd ijava-kernel \
  && python3 install.py --sys-prefix

# Remove kernel zip file
RUN rm -rf ijava-kernel.zip

# Copy all the required file
COPY . .
RUN chown -R $NB_UID $HOME

USER $NB_UID

# Launch the notebook server
EXPOSE 8888
CMD ["jupyter", "lab", "--ip", "0.0.0.0"]
