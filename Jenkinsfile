

pipeline {

    
    agent any

    stages {
        stage('BUILD') {
            steps {
                echo 'cd naming-server && chmod +x mvnw && ./mvnw spring-boot:build-image -DskipTests -e && cd ..'
            }
        }
        stage('TEST') {
            steps {
                echo 'Testing the application'
            }
        }
        stage('DEPLOY') {
            steps {
                echo 'deploying the application'
            }
        }
    }
}
