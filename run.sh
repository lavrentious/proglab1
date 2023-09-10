#!/usr/bin/env bash
java -jar build/Lab1.jar || (./build.sh && java -jar build/Lab1.jar)