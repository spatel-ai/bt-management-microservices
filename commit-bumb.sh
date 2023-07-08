#!/bin/bash
commit_message = "Feat : version bumb $1"
echo "${commit_message}"
echo "I'm here"
echo 'I'm here $1'
echo 'version $1'
git commit -m "$commit_message"
git log
git push origin HEAD:Feature
echo "Success"