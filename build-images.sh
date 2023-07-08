#!/bin/bash 
 
cd spring-cloud-gateway && mvn clean package && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd authentication-service && mvn clean package && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd horizons-service && mvn clean package && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd naming-server && mvn clean package && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd config-server && mvn clean package && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd support-service && mvn clean package && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd students-connect-service && mvn clean package && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd ..