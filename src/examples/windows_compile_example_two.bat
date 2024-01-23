@echo off

set SOURCE_DIR=../../src
set BUILD_DIR=examples_build

cd %SOURCE_DIR%
javac -d ../%BUILD_DIR% ./bintreevisual/*.java
javac -d ../%BUILD_DIR% ./examples/*.java

cd ../%BUILD_DIR%
jar cfm ExampleTwo.jar ./EXAMPLE_TWO_MANIFEST.MF -C bintreevisual/ .
jar uf ExampleTwo.jar -C examples/ .

echo Build completed successfully.