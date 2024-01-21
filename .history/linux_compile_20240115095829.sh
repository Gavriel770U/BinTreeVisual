cd src
javac -d ../build *.java
cd ../build
jar cfm Pascal.jar MANIFEST.MF *.class