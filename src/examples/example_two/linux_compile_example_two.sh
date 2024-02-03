#!/bin/bash

SOURCE_DIR=../../../src
BUILD_DIR=examples_build

cd "$SOURCE_DIR"
javac -d ../"$BUILD_DIR" ./bintreevisual/*.java
javac -d ../"$BUILD_DIR" ./examples/example_two/*.java

cd ../"$BUILD_DIR"
jar cfm ExampleTwo.jar ./EXAMPLE_TWO_MANIFEST.MF -C bintreevisual/ .
jar uf ExampleTwo.jar -C examples/example_two/ .

echo "Build completed successfully."