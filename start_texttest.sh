#!/bin/sh

if [ ! -d "texttests/venv" ]; then
    python3 -m venv ./texttests/venv
fi
texttests/venv/bin/pip install texttest
texttests/venv/bin/texttest -d . -con "$@"