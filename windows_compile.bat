@echo off

set SOURCE_DIR=src
set BUILD_DIR=build

cd %SOURCE_DIR%
javac -d ../%BUILD_DIR% ./bintreevisual/*.java

cd ../%BUILD_DIR%
jar cfm BinTreeVisual.jar ./MANIFEST.MF -C bintreevisual/ .

echo Build completed successfully.