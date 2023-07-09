export VERSION=$1
echo "${VERSION}"
sudo docker-compose -f docker-compose.yml up --detach
echo "Success"