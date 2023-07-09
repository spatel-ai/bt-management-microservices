export VERSION=$1
pwd
echo "${VERSION}"
echo "VERSION=$VERSION" >> mytext.txt
cat mytext.txt
ls -a
