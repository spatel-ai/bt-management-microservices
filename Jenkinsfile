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
        stage('COMPILE') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'cd naming-server &&/usr/share/maven/bin/mvn sonar:sonar && cd ..'
                }
            }
        }
        // stage('BUILD') {
        //     steps {
        //         sh 'cd naming-server && mvn clean verify sonar:sonar && cd ..'
        //     }
        // }
        stage('BUILD IMAGE') {
            steps {
                sh 'ls -a '
            }
        }
        stage('DEPLOY') {
            steps {
                echo 'deploying the application'
            }
        }
    }
}
