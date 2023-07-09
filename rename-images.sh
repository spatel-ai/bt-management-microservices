echo "------------------------------------------------------------------------------------------------"
echo "Started Image Tagging Procedure"
echo "------------------------------------------------------------------------------------------------"
docker tag support-service:$1 imshubhampatel/support-service:$1
docker tag config-server:$1 imshubhampatel/config-server:$1
docker tag naming-server:$1 imshubhampatel/naming-server:$1
docker tag horizons-service:$1 imshubhampatel/horizons-service:$1
docker tag authentication-service:$1 imshubhampatel/authentication-service:$1
docker tag spring-cloud-gateway:$1 imshubhampatel/spring-cloud-gateway:$1
docker tag students-connect-service:$1 imshubhampatel/students-connect-service:$1

echo "------------------------------------------------------------------------------------------------"
echo "Started Image pushing Procedure"
echo "------------------------------------------------------------------------------------------------"

docker push imshubhampatel/naming-server:$1
docker push imshubhampatel/horizons-service:$1
docker push imshubhampatel/config-server:$1
docker push imshubhampatel/support-service:$1
docker push imshubhampatel/authentication-service:$1
docker push imshubhampatel/spring-cloud-gateway:$1
docker push imshubhampatel/students-connect-service:$1