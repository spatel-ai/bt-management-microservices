export version=$1
echo ${version}
git commit -m "Feat : version bumb : ${version}"
git push origin HEAD:Feature
echo "Success"