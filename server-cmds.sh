#!/bin/bash 
ls -a
cat .env
echo "env result is above"
sudo docker-compose -f docker-compose.yml up --detach
sudo docker ps -a
sudo docker system df
echo "Success"