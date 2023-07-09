export version=$1
echo "${version}"
sudo docker-compose -f docker-compose.yml up --detach
echo "Success"