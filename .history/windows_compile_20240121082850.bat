cd src
javac -d ../build *.java
cd ../build
jar cfm.jar MANIFEST.MF *.class