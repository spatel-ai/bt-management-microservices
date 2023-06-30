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
        stage('BUILD') {
            steps {
                // bat 'echo %SERVER_DOCKER_CREDS%'

                echo 'Hellow world'
                sh 'mvn --version'
                sh 'cd naming-server'
                sh 'ls -a'
                sh 'mvn clean verify sonar:sonar'
                sh 'cd ..'
                sh 'ls -a 
            }
        }
        stage('BUILD IMAGE') {
            steps {
                sh 'ls -a'
            // sh 'docker images'
            // sh "docker ps -a"
            // sh 'chmod +x build-images.sh && ./build-images.sh'
            }
        }
        stage('DEPLOY') {
            steps {
                echo 'deploying the application'
            // echo "docker data ${SERVER_DOCKER_CREDS}"
            // sh 'chmod +x rename-images.sh && ./rename-images.sh'
            }
        }
    }
}
