pipeline {
    agent any

    tools {
        jdk 'Java17'
    }

    stages {
        stage('Compile') {
            steps {
                sh 'java --version'
            }
        }
        stage('Code Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'cd naming-server &&/usr/share/maven/bin/mvn sonar:sonar && cd ..'
                }
            }
        }
        stage('Build Images') {
            steps {
                sh 'ls -a '
            }
        }
        stage('Deploy Images') {
            steps {
                echo 'deploying the application'
            }
        }
    }
}
