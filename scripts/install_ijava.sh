#!/bin/sh

# Get IJava kernel
wget -P /tmp https://github.com/SpencerPark/IJava/releases/download/v1.3.0/ijava-1.3.0.zip

# Unpack
unzip -d /tmp/ijava /tmp/ijava-1.3.0.zip

# Install
sudo jupyter kernelspec install /tmp/ijava/java/

# Copy hardcoded path spec
sudo cp scripts/kernel.json /usr/local/share/jupyter/kernels/java/
