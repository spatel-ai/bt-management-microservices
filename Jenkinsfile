def AGENT_LABEL = null

node('master') {
    stage('Configure Agent')
     {
        if (scm.branches[0].name.matches('Development')) {
            AGENT_LABEL = 'SECURE-API-DEV'
            env = 'DEV'
        }
     else if (scm.branches[0].name.matches('Pre-Release')) {
            AGENT_LABEL = 'SECURE-API-UAT'
            env = 'UAT'
     }
     else if (scm.branches[0].name.matches('Feature')) {
            AGENT_LABEL = 'SECURE-API-DEV'
            env = 'UAT'
     }
     else if (scm.branches[0].name.matches('Release')) {
            AGENT_LABEL = 'SECURE-API-RELEASE'
            env = 'PROD'
     }
     }
    stage('Validate Agent')
    {
        echo "${AGENT_LABEL}"
        echo "${env}"
    }
}

pipeline {
    agent {
        label "${AGENT_LABEL}"
    }

    tools {
        jdk 'Java17'
    }
    environment {
        NEW_VERSION = '1.3.0'
    }

    stages {
        stage('Clean Workspace')
        {
            steps {
                echo 'Cleaning Workspace...'
                echo"${AGENT_LABEL}"
                echo "${env}"
            }
        }

        stage('CODE ANALYSIS') {
            steps {
                withSonarQubeEnv('sonarqube-setup') {
                    echo 'cd naming-server &&/usr/share/maven/bin/mvn sonar:sonar && cd ..'
                }
            }
        }

        stage('BUILD IMAGE') {
            steps {
                echo 'Build Image Step Started '
                echo 'Build Image Step Completed '
            }
        }
        stage('DEPLOY') {
            steps {
                script {
                    def dockerCmd = 'docker run -p 8761:8761 imshubhampatel/naming-server:0.0.1-SNAPSHOT'
                    sshagent(['ec2-ubuntu-user']) {
                        echo 'Started Deploying Code to server'
                        echo"${AGENT_LABEL}"
                        echo "${env}"
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@3.109.126.86 ${dockerCmd}"
                    }
                }
            }
        }
    }
}
