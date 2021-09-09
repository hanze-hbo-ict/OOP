#!/bin/sh

# Get IJava kernel
cd /tmp
wget https://github.com/SpencerPark/IJava/releases/download/v1.3.0/ijava-1.3.0.zip

# Unpack
unzip -d ijava ijava-1.3.0.zip
cd ijava

# Install
sudo python3 install.py --user
