
docker images
docker rmi naming-server:$1
docker rmi spring-cloud-gateway:$1
docker rmi horizons-service:$1
docker rmi support-service:$1
docker rmi authentication-service:$1
docker rmi config-server:$1
docker rmi students-connect-service:$1

docker rmi imshubhampatel/naming-server:$1
docker rmi imshubhampatel/spring-cloud-gateway:$1
docker rmi imshubhampatel/horizons-service:$1
docker rmi imshubhampatel/support-service:$1
docker rmi imshubhampatel/authentication-service:$1
docker rmi imshubhampatel/config-server:$1
docker rmi imshubhampatel/students-connect-service:$1
docker images