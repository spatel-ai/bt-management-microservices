export VERSION=$1
echo "${VERSION}"
echo "VERSION=$VERSION" >> .env
cat .env
ls -a
