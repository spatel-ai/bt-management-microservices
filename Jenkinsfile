
pipeline {
    agent any

    stages {
        stage('BUILD') {
            steps {
                echo 'cd naming-server && mvn package cd ..'
            }
        }
        stage('BUILD IMAGE') {
            steps {
                sh "ls -a"
                sh "docker images"
                sh 'cd naming-server && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. '
            }
        }
        stage('DEPLOY') {
            steps {
                echo 'deploying the application'
            }
        }
    }
}
