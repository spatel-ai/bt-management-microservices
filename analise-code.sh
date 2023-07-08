cd naming-server &&  mvn clean install &&/usr/share/maven/bin/mvn sonar:sonar && cd ..
cd spring-cloud-gateway && mvn clean install &&/usr/share/maven/bin/mvn sonar:sonar && cd ..
cd config-server && mvn clean install &&/usr/share/maven/bin/mvn sonar:sonar && cd ..
cd support-service && mvn clean install &&/usr/share/maven/bin/mvn sonar:sonar && cd ..
cd students-connect-service && mvn clean install &&/usr/share/maven/bin/mvn sonar:sonar && cd ..
cd authentication-service &&  mvn clean install &&/usr/share/maven/bin/mvn sonar:sonar && cd ..
cd horizons-service &&  mvn clean install &&/usr/share/maven/bin/mvn sonar:sonar && cd ..