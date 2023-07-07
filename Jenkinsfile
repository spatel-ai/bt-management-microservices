def AGENT_LABEL = null

node('master') {
    stage('Set agents') {
        echo"${scm.branches[0].name}"
        echo"${scm.branches[0]}"
        if (scm.branches[0].name.matches('Development')) {
            AGENT_LABEL = 'SECURE-API-DEVs'
     }else if (scm.branches[0].name.matches('Pre-Dev-Phase2')) {
            AGENT_LABEL = 'SECURE-API-DE'
     }else if (scm.branches[0].name.matches('Pre-Release-Phase2')) {
            AGENT_LABEL = 'SECURE-API-UAT'
     }else if (scm.branches[0].name.matches('Release')) {
            AGENT_LABEL = 'SECURE-API-UAT'
        }
    }
    stage('test agent') {
        echo"${AGENT_LABEL}"
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
        stage('COMPILE') {
            steps {
                withSonarQubeEnv('sonarqube-setup') {
                    echo"${AGENT_LABEL}"
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
