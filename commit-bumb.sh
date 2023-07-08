export version=$1
echo "I'm here"
echo "${version}"
git commit -m "Feat : version bumb : ${version}"
git push origin HEAD:Feature
echo "Success"