#!/bin/bash
export commit_message="[versioning skip] : version bumb@$1"
echo "${commit_message}"
git commit -m "$commit_message"
git push origin HEAD:Feature
