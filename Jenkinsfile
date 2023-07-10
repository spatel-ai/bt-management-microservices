// def res = 1
// def VERSION = null
// def OLD_VERSION = null

pipeline {
    agent any
    tools {
        jdk 'Java17'
        maven 'Maven-3'
    }
    environment {
        NEW_VERSION = '1.0.0'
    }

    stages {
        stage('checkout') {
            steps {
                // stage 1 doing checkout and storing old version
                script {
                    res = sh(script: 'git log -1 --pretty=%B', returnStdout: true)
                    echo "response ${res}"
                    if (res.contains('[versioning skip]')) {
                        error 'Jenkins CICD Module Detected to build...'
                    }
                    echo 'checkout was successfull'
                    def match = readFile('naming-server/pom.xml') =~ '<version>(.+)</version>'
                    OLD_VERSION =  match[0][1]
                }
            }
        }
        stage('INCREMENT VERSIONS') {
            steps {
                // stage 2 doing Increment of version and storing old version
                script {
                    sh 'chmod 777 ./version-increment.sh'
                    res = sh(script:'./version-increment.sh', returnStatus:true)
                    if (res != 0) {
                        error 'Error in versoning images and files ..........................................'
                    }
                    def matcher = readFile('naming-server/pom.xml') =~ '<version>(.+)</version>'
                    VERSION =  matcher[0][1]
                    echo "${VERSION}"
                }
            }
        }

        stage('WORKSPACE CLEANING') {
            steps {
                // stage 3 clearing workspace
                script {
                    echo 'Cleaning Workspace...'
                    sh 'chmod 777 ./discard-images.sh'
                    res = sh(script:"./discard-images.sh ${OLD_VERSION}", returnStatus:true)
                    echo "${res}"
                    if (res != 0) {
                        error 'Error in clearing images and files ..........................................'
                    }
                    echo 'Docker images scan deleted successfully'
                }
            }
        }

        stage('CODEBASE ANALYSIS') {
            steps {
                // Stage 4 sonarqube analysis is doing
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

        stage('BUILD IMAGES PUSHING') {
            steps {
                // Stage 5 Building docker images and pushing it to docker
                script {
                    echo 'Build Image Step Started '
                    sh 'chmod 777 ./build-images.sh'
                    res = sh(script:'./build-images.sh', returnStatus:true)
                    echo "${res}"
                    if (res != 0) {
                        error 'Error in building image docker file...................................................'
                    }
                }
            }
        }
        stage('IMAGE PUSHING') {
            steps {
                // Stage 5 Building docker images and pushing it to docker
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker-server-token', passwordVariable: 'PASS', usernameVariable:'USER')]) {
                        echo 'Build Image Step Started '
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'chmod 777 ./rename-images.sh'
                        res = sh(script:"./rename-images.sh ${VERSION}", returnStatus:true)
                        echo "${res}"
                        if (res != 0) {
                            error 'Error in pushing image docker file..................................................'
                        }
                        echo 'Pushing Images Step  is Completed... '
                    }
                }
            }
        }

        stage('DEPLOY IMAGES') {
            steps {
                script {
                    def serverCmd = 'bash ./server-cmds.sh'
                    sshagent(['ec2-user']) {
                        sh 'chmod 777 ./helpCmd.sh'
                        sh 'docker images'
                        sh 'docker ps -a'
                        echo "verson ${OLD_VERSION} =>>> ${VERSION}"
                        sh 'bash ./helpCmd.sh 0.0.1'
                        sh 'scp .env ubuntu@3.108.28.110:/home/ubuntu'
                        sh 'scp server-cmds.sh ubuntu@3.108.28.110:/home/ubuntu'
                        sh 'scp docker-compose.yml ubuntu@3.108.28.110:/home/ubuntu'
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@3.108.28.110 ${serverCmd}"
                    }
                }
            }
        }
        stage('VERSION UPDATE') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'github-server-token', passwordVariable: 'PASS', usernameVariable:'USER')]) {
                        sh 'git config --global user.email jenkins@btirt.com'
                        sh 'git config --global user.name jenkins'
                        sh 'git config --list'
                        sh 'ls -a'
                        sh 'git branch '
                        sh 'git status'
                        sh "git remote set-url origin https://imshubhampatel:${PASS}@github.com/imshubhampatel/bt-management-microservices.git"
                        sh 'git add naming-server/pom.xml'
                        sh 'git add config-server/pom.xml'
                        sh 'git add support-service/pom.xml'
                        sh 'git add spring-cloud-gateway/pom.xml'
                        sh 'git add authentication-service/pom.xml'
                        sh 'git add students-connect-service/pom.xml'
                        sh 'chmod 777 ./commit-bumb.sh'
                        echo "${VERSION}"
                        sh "./commit-bumb.sh ${VERSION}"
                        res = sh(script:"./commit-bumb.sh ${VERSION}", returnStatus:true)
                        if (res != 0) {
                            error 'Error in making commits of images and files ..........................................'
                        }
                    }
                }
            }
        }
    }
}
