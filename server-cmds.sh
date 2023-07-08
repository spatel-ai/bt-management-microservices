export version=$1
sudo docker-compose -f docker-compose.yml up --detach
echo "Success"