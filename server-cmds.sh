#!/bin/bash 
ls -a
cat .env
sudo docker-compose -f docker-compose.yml up --detach
sudo docker ps -a
sudo docker system df
echo "Success"