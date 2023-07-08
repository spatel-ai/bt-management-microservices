#!/bin/bash
export commit_message="cicd : version bumb@$1"
echo "${commit_message}"
git commit -m "$commit_message"
git push origin HEAD:Feature
