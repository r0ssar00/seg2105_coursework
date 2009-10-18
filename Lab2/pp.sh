#!/bin/bash
./process.sh $@
cd client
../process.sh $@
cd ../server
../process.sh $@
cd ..

javac *.java
