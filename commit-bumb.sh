
echo "I'm here"
echo "I'm here $1"
echo "Version $1"
git commit -m "Feat : version bumb : $1"
git log
git push origin HEAD:Feature
echo "Success"