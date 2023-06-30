pipeline {
    agent any

    tools {
        jdk 'Java17'
    }
    environment {
        NEW_VERSION = '1.3.0'
    // SERVER_DOCKER_CREDS = credentials('server-docker-creds')
    }

    stages {
        stage('PACKAGE') {
            step {
                sh "/usr/share/maven/bin/mvn package"
            }
        }
        stage('COMPILE') {
                withSonarQubeEnv("sonarqube"){
                    sh "/usr/share/maven/bin/mvn sonar:sonar"
                    sh 'cd naming-server && mvn clean verify sonar:sonar && cd ..'
                }
        }
        stage('BUILD') {
            steps {
                sh 'cd naming-server && mvn clean verify sonar:sonar && cd ..'
            }
        }
        stage('BUILD IMAGE') {
            steps {
                sh 'ls -a'
            }
        }
        stage('DEPLOY') {
            steps {
                echo 'deploying the application'
     =
            }
        }
    }
}
