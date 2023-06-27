pipeline {
    agent any

    tools {
        jdk 'Java17'
    }
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_DOCKER_CREDS = credientials('server-docker-creds')
    }

    stages {
        stage('BUILD') {
            steps {
                sh 'chmod +x discard-images.sh && ./discard-images.sh'
            }
        }
        stage('BUILD IMAGE') {
            steps {
                sh 'ls -a'
                sh 'docker images'
                // sh 'chmod +x build-images.sh && ./build-images.sh'
            }
        }
        stage('DEPLOY') {
            steps {
                echo 'deploying the application'
                echo "docker data ${SERVER_DOCKER_CREDS}"
                // sh 'chmod +x rename-images.sh && ./rename-images.sh'
            }
        }
    }
}
