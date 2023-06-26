#!/bin/bash 
 
cd spring-cloud-gateway && mvn clean install  && cd .. 
cd authentication-service && mvn clean install  && cd .. 
cd horizons-service && mvn clean install  && cd .. 
cd naming-server && mvn clean install  && cd .. 
cd config-server && mvn clean install  && cd .. 
cd support-service && mvn clean install  && cd .. 
cd students-connect-service && mvn clean install  && cd .. 
 
cd spring-cloud-gateway && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd authentication-service && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd horizons-service && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd naming-server && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd config-server && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd support-service && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 
cd students-connect-service && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. 