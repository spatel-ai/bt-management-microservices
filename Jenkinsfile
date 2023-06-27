pipeline {
    agent any

    tools {
        jdk 'Java17'
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
                sh 'chmod +x build-images.sh && ./build-images.sh'
                sh 'chmod +x rename-images.sh && ./rename-images.sh'
            }
        }
        stage('DEPLOY') {
            steps {
                echo 'deploying the application'
            }
        }
    }
}
