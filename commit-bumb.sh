#!/bin/bash
commit_message = " Feat : version bumb $1"
echo "I'm here"
echo 'I'm here $1'
echo "Version $1"
'git commit -m "$commit_message"
git log
git push origin HEAD:Feature
echo "Success"