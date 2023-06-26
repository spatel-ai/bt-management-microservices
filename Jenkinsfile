
pipeline {
    agent any

    tools {
        jdk 'Java17'
    }

    stages {
        stage('Which Java') {
            steps {
                echo 'cd naming-server && mvn package cd ..'
                sh 'java --version'
            }
        }
        stage('BUILD IMAGE') {
            steps {
                sh "ls -a"
                sh "docker images"              
                sh 'cd naming-server && ls -a && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd .. '
            }
        }
        stage('DEPLOY') {
            steps {
                echo 'deploying the application'
            }
        }
    }
}
