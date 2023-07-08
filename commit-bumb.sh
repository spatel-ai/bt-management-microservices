#!/bin/bash
export commit_message=$1
echo "${commit_message}"
git commit -m $commit_message
git log
git push origin HEAD:Feature
echo "Success"