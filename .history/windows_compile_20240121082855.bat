cd src
javac -d ../build *.java
cd ../build
jar cfm BinTreeVisual.jar MANIFEST.MF *.class