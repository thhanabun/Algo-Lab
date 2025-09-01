@echo off
REM Move to project root
echo Compiling...
javac -d bin -sourcepath src .\src\th\ac\kmutt\cpe\algorithm\thanaboon\*.java

java -cp bin th.ac.kmutt.cpe.algorithm.thanaboon.Main