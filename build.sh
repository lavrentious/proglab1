#!/usr/bin/env bash
rm -f build/*.class
rm -f build/*.jar
javac -d build src/*.java &&jar -cfe build/Lab1.jar Main -C build .