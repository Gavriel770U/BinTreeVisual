@echo off

set SOURCE_DIR=../../src
set BUILD_DIR=examples_build

cd %SOURCE_DIR%
javac -d ../%BUILD_DIR% ./bintreevisual/*.java
javac -d ../%BUILD_DIR% ./examples/*.java

cd ../%BUILD_DIR%
jar cfm ExampleOne.jar ./EXAMPLE_ONE_MANIFEST.MF -C bintreevisual/ .
jar uf ExampleOne.jar -C examples/ .

echo Build completed successfully.