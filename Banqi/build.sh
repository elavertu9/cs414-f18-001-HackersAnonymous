#!/bin/bash

echo "Building Frontend..."
cd frontend && npm install

echo "Building Backend..."
cd ../
mvn clean install