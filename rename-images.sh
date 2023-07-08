echo "------------------------------------------------------------------------------------------------"
echo "Started Image Tagging Procedure"
echo "------------------------------------------------------------------------------------------------"
docker tag support-service:0.0.1-SNAPSHOT imshubhampatel/support-service:0.0.1-SNAPSHOT
docker tag config-server:0.0.1-SNAPSHOT imshubhampatel/config-server:0.0.1-SNAPSHOT
docker tag naming-server:0.0.1-SNAPSHOT imshubhampatel/naming-server:0.0.1-SNAPSHOT
docker tag horizons-service:0.0.1-SNAPSHOT imshubhampatel/horizons-service:0.0.1-SNAPSHOT
docker tag authentication-service:0.0.1-SNAPSHOT imshubhampatel/authentication-service:0.0.1-SNAPSHOT
docker tag students-connect-service:0.0.1-SNAPSHOT imshubhampatel/students-connect-service:0.0.1-SNAPSHOT
docker tag spring-cloud-gateway:0.0.1-SNAPSHOT imshubhampatel/spring-cloud-gateway:0.0.1-SNAPSHOT

echo "------------------------------------------------------------------------------------------------"
echo "Deleting old image Procedure"
echo "------------------------------------------------------------------------------------------------"

docker images
docker rmi naming-server:0.0.1-SNAPSHOT
docker rmi spring-cloud-gateway:0.0.1-SNAPSHOT
docker rmi horizons-service:0.0.1-SNAPSHOT
docker rmi support-service:0.0.1-SNAPSHOT
docker rmi authentication-service:0.0.1-SNAPSHOT
docker rmi students-connect-service:0.0.1-SNAPSHOT
docker rmi config-server:0.0.1-SNAPSHOT
docker images


echo "------------------------------------------------------------------------------------------------"
echo "Started Image pushing Procedure"
echo "------------------------------------------------------------------------------------------------"

docker push imshubhampatel/naming-server:0.0.1-SNAPSHOT
docker push imshubhampatel/horizons-service:0.0.1-SNAPSHOT
docker push imshubhampatel/config-server:0.0.1-SNAPSHOT
docker push imshubhampatel/support-service:0.0.1-SNAPSHOT
docker push imshubhampatel/students-connect-service:0.0.1-SNAPSHOT
docker push imshubhampatel/authentication-service:0.0.1-SNAPSHOT
docker push imshubhampatel/spring-cloud-gateway:0.0.1-SNAPSHOT