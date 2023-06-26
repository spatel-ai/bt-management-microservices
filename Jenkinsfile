
pipeline {
    agent any
    tools {
        maven 'Maven'
    }

    stages {
        stage('BUILD') {
            steps {
                sh 'mvn package'
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
