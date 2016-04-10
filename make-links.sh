#!/bin/bash

DIRECTORY=$(cd `dirname $0` && pwd)

ln -s "$DIRECTORY/clash" /usr/local/bin/clash
