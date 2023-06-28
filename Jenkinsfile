AGENT_LABEL = null

node('master') {
    stage('Set agent') {
        if (scm.branches[0].name.matches('Development')) {
            AGENT_LABEL = 'SECURE-API-DEV'
            env = 'dev'
     //ecr_repo = "securitization-dev"
     }else if (scm.branches[0].name.matches('master')) {
            AGENT_LABEL = 'SECURE-API-DEV'
            env = 'uat'
     //ecr_repo = "securitization-dev"
     }else if (scm.branches[0].name.matches('Pre-Release-Phase2')) {
            AGENT_LABEL = 'SECURE-API-UAT'
            env = 'uat'
     }else if (scm.branches[0].name.matches('Release')) {
            AGENT_LABEL = 'SECURE-API-UAT'
            env = 'uat'
        }
    }
}

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
                echo "$AGENT_LABEL"
                withCredentials([usernamePassword(credentialsId: 'server-docker-creds', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                    echo "Username: $USERNAME"
                    sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                }
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
            // echo "docker data ${SERVER_DOCKER_CREDS}"
            // sh 'chmod +x rename-images.sh && ./rename-images.sh'
            }
        }
    }
}
