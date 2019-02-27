#!/usr/bin/env bash
while true; do curl http://localhost:9001; sleep $(($RANDOM%2)); curl http://localhost:9002; sleep $(($RANDOM%2)); done
