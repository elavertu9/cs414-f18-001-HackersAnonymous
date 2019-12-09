#!/bin/bash

if [[ $# -ne 1 ]]; then
    echo "Usage: host_backend.sh <Version>"
    echo "Example: host_backend.sh 3.0"
else
    jarFile="backend-"$1".jar"
  output=$(ls backend/target | grep "$jarFile"  | wc -l)
    if [[ $output == 0 ]]; then
        echo "Error: Version number supplied is not the current build version..."
    else
        echo "Hosting Backend on port 8080..."
        cd backend/target
        java -jar $jarFile
    fi
fi
