def AGENT_LABEL = null
def res = 1

node('master') {
    stage('CONFIGURE AGENTS')
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
    stage('VALIDATE AGENTS')
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
        stage('WORKSPACE CLEANING')
        {
            steps {
                script {
                    echo"${AGENT_LABEL}"
                    echo "${env}"
                    echo 'Cleaning Workspace...'
                    sh 'chmod 777 ./discard-images.sh'
                    res = sh(script:'./discard-images.sh', returnStatus:true)
                    echo "${res}"
                    if (res != 0) {
                        error 'Error in clearing images and files ..........................................'
                    }
                    echo 'Docker images scan deleted  successfully'
                }
            }
        }

        stage('CODEBASE ANALYSIS') {
            steps {
                script {
                        def dockerStatus = 1
                    withSonarQubeEnv('sonarqube-setup') {
                        sh 'chmod 777 ./analise-code.sh'
                        dockerStatus = sh(script:'./analise-code.sh', returnStatus:true)
                        echo "${dockerStatus}"
                        if (dockerStatus != 0) {
                            error 'Error in sonarqube file ..................................................'
                        }
                        echo 'Sonarqube scan was successfull'
                    }
                }
            }
        }

        stage('BUILD IMAGES') {
            steps {
                script {
                        echo 'Build Image Step Started '
                        sh 'chmod 777 ./build-images.sh'
                        res = sh(script:'./build-images.sh', returnStatus:true)
                        echo "${res}"
                        if (res != 0) {
                        error 'Error in building image docker file...................................................'
                        }
                        echo 'Build Image Step Completed '
                }
            }
        }
        stage('PUSHING IMAGES') {
            steps {
                script {
                        echo 'Build Image Step Started...'
                        sh 'chmod 777 ./rename-images.sh'
                        res = sh(script:'./rename-images.sh', returnStatus:true)
                        echo "${res}"
                        if (res != 0) {
                        error 'Error in pushing image docker file..................................................'
                        }
                        echo 'Pushing Images Step  is Completed... '
                }
            }
        }
        stage('DEPLOY IMAGES') {
            steps {
                script {
                    // def dockerCmd = 'docker run -p 8761:8761 -d imshubhampatel/naming-server:0.0.1-SNAPSHOT'
                    def dockerComposeCmd = 'docker-compose -f docker-compose.yml --detach'
                    sshagent(['ec2-ubuntu-user']) {
                        sh'scp docker-compose.yml ubuntu@3.108.28.110:/home/ubuntu'
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@3.108.28.110 ${dockerComposeCmd}"
                    }
                }
            }
        }
    }
}
