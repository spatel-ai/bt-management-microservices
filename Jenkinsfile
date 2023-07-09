def AGENT_LABEL = null
def res = 1
def VERSION = null
def OLD_VERSION = null

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
        maven 'Maven-3'
    }
    environment {
        NEW_VERSION = '1.0.0'
    }

    stages {
        //     stage('checkout') {
        //         steps {
        //             script {
        //                 res = sh(script: 'git log -1 --pretty=%B', returnStdout: true)
        //                 echo "response ${res}"
        //                 if (res.contains('[versioning skip]')) {
        //                     error 'Jenkins CICD Module Detected to build...'
        //                 }
        //                 echo 'checkout was successfull'
        //             }
        //         }
        //     }
        stage('INCREMENT VERSIONS') {
            steps {
                script {
                    sh 'ls -a'
                    echo 'Versoning step  Image  Step Started '
                    def match = readFile('naming-server/pom.xml') =~ '<version>(.+)</version>'
                    OLD_VERSION =  match[0][1]
                    echo "OLD is here Version ${OLD_VERSION}"
                    echo 'Versoning step Image Step Completed'
                    sh 'chmod 777 ./version-increment.sh'
                    res = sh(script:'./version-increment.sh', returnStatus:true)
                    if (res != 0) {
                        error 'Error in versoning images and files ..........................................'
                    }
                    echo 'Versoning step Image Step Completed'
                    def matcher = readFile('naming-server/pom.xml') =~ '<version>(.+)</version>'
                    VERSION =  matcher[0][1]
                    echo "Latest version is here ${VERSION}"
                    echo 'Build Image Step Started '
                }
            }
        }

    //     stage('WORKSPACE CLEANING') {
    //         steps {
    //             script {
    //                 echo"${AGENT_LABEL}"
    //                 echo "${env}"
    //                 echo 'Cleaning Workspace...'
    //                 sh 'chmod 777 ./discard-images.sh'
    //                 res = sh(script:'./discard-images.sh', returnStatus:true)
    //                 echo "${res}"
    //                 if (res != 0) {
    //                     error 'Error in clearing images and files ..........................................'
    //                 }
    //                 echo 'Docker images scan deleted successfully'
    //             }
    //         }
    //     }

    //     stage('CODEBASE ANALYSIS') {
    //         steps {
    //             script {
    //                     def dockerStatus = 1
    //                 withSonarQubeEnv('sonarqube-setup') {
    //                     sh 'chmod 777 ./analise-code.sh'
    //                     dockerStatus = sh(script:'./analise-code.sh', returnStatus:true)
    //                     echo "${dockerStatus}"
    //                     if (dockerStatus != 0) {
    //                         error 'Error in sonarqube file ..................................................'
    //                     }
    //                     echo 'Sonarqube scan was successfull'
    //                 }
    //             }
    //         }
    //     }

    //     stage('BUILD IMAGES') {
    //         steps {
    //             script {
    //                 echo 'Build Image Step Started '
    //                 sh 'chmod 777 ./build-images.sh'
    //                 res = sh(script:'./build-images.sh', returnStatus:true)
    //                 echo "${res}"
    //                 if (res != 0) {
    //                     error 'Error in building image docker file...................................................'
    //                 }
    //                 echo 'Build Image Step Completed '
    //             }
    //         }
    //     }
    //     stage('PUSHING IMAGES') {
    //         steps {
    //             script {
    //                 echo 'Build Image Step Started...'
    //                 sh 'chmod 777 ./rename-images.sh'
    //                 res = sh(script:"./rename-images.sh ${version}", returnStatus:true)
    //                 echo "${res}"
    //                 if (res != 0) {
    //                     error 'Error in pushing image docker file..................................................'
    //                 }
    //                 echo 'Pushing Images Step  is Completed... '
    //             }
    //         }
    //     }

    //     stage('VERSION UPDATE') {
    //         steps {
    //             script {
    //                 withCredentials([usernamePassword(credentialsId: 'github-server-token', passwordVariable: 'PASS', usernameVariable:'USER')]) {
    //                     sh 'git config --global user.email jenkins@btirt.com'
    //                     sh 'git config --global user.name jenkins'
    //                     sh 'git config --list'
    //                     sh 'ls -a'
    //                     sh 'git branch '
    //                     sh 'git status'
    //                     sh "git remote set-url origin https://imshubhampatel:${PASS}@github.com/imshubhampatel/bt-management-microservices.git"
    //                     sh 'git add .'
    //                     sh 'chmod 777 ./commit-bumb.sh'
    //                     echo "${version}"
    //                     sh "./commit-bumb.sh ${version}"
    //                     res = sh(script:"./commit-bumb.sh ${version}", returnStatus:true)
    //                     if (res != 0) {
    //                         error 'Error in making commits of images and files ..........................................'
    //                     }
    //                 }
    //             }
    //         }
    //     }

        stage('DEPLOY IMAGES') {
            steps {
                script {
                    def serverCmd = "bash ./server-cmds.sh ${VERSION}"
                    sshagent(['ec2-user']) {
                        sh 'chmod 777 ./helpCmd.sh'
                        sh 'docker images'
                        sh 'docker ps -a'
                        sh "bash ./helpCmd.sh ${VERSION}"
                        sh 'scp .env ubuntu@3.108.28.110:/home/ubuntu'
                        sh 'scp server-cmds.sh ubuntu@3.108.28.110:/home/ubuntu'
                        sh 'scp docker-compose.yml ubuntu@3.108.28.110:/home/ubuntu'
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@3.108.28.110 ${serverCmd}"
                    }
                }
            }
        }
    }
}
