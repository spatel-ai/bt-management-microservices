#!/bin/bash 
ls -a
cat .env
sudo docker-compose -f docker-compose.yml up --detach
echo "Success"