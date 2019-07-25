#!/bin/bash
set -e
kotlinc *.kt prisoner/*.kt -include-runtime -d dilemma.jar
java -jar dilemma.jar
