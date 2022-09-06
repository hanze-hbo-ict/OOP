#!/bin/sh

# Usage:
#
# > ./present.sh <notebook.ipynb>
#
# This will export the notebook to a RevealJS slidedeck *and* will open it
# in a browser. Then press s to open a separate presenter mode screen. See
# also https://revealjs.com/ for more details.

jupyter nbconvert $1 --to slides --post serve --ServePostProcessor.port=8080
