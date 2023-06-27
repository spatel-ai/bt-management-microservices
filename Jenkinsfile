pipeline {
    agent any

    tools {
        jdk 'Java17'
    }
    environment {
        NEW_VERSION = '1.3.0'
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
                sh ''
                // sh 'chmod +x rename-images.sh && ./rename-images.sh'
                withCredentials([
                    usernamePassword(credentials:'server-docker-creds', usernameVariable:USER, passwordVariable:PASSWORD)
                ]) {
                    sh "some script ${USER}"
                    sh "echo ${PASSWORD} | docker login ${USER} --password-stdin"
                }
            }
        }
    }
}
