#!/bin/bash 
 
cd api-gateway && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd authentication-service && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd masters-service && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd naming-server && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd pool-upload && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd portfolio-service && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd utility-service && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd accounting-service && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd ..