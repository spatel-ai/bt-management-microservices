#!/bin/bash 
 
cd spring-cloud-gateway && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd authentication-service && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd horizons-service && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd naming-server && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd config-server && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd support-service && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd students-connect-service && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 