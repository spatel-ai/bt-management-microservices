def res = 1
def VERSION = null
def OLD_VERSION = null
def FILE_PATH = '/var/jenkins_home/jenkinsfile'

node {
    stage('BRANCH AND VERSION') {
        checkout scm
        echo "${scm.branches} all branches "
        echo "${scm.branches[0].name}"
        env.BRANCH_NAME = scm.branches[0].name
        echo "${BRANCH_NAME}"
    }
}

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
        // stage('WORKSPACE CLEANING') {
        //     steps {
        //         // stage 3 clearing workspace
        //         script {
        //             echo"${env.BRANCH_NAME}"
        //             echo 'Cleaning Workspace...'
        //             sh'ls -a'
        //             sh "cat ${FILE_PATH}/discard-images.sh"
        //             sh "chmod 777 ${FILE_PATH}/discard-images.sh"
        //             def match = readFile('naming-server/pom.xml') =~ '<version>(.+)</version>'
        //             echo"${match[0]}"
        //             OLD_VERSION =  match[0][1]
        //             echo"${OLD_VERSION}"
        //         }
        //     }
        // }
        // stage('IMAGES CLEANING') {
        //     steps {
        //         // stage 3 clearing workspace
        //         script {
        //             res = sh(script:"${FILE_PATH}/discard-images.sh ${OLD_VERSION}", returnStatus:true)
        //             echo "${res}"
        //             if (res != 0) {
        //                 error 'Error in clearing images and files ..........................................'
        //             }
        //             echo 'Docker images scan deleted successfully'
        //         }
        //     }
        // }
        // stage('INCREMENT VERSIONS') {
        //     steps {
        //         // stage 2 doing Increment of version and storing old version
        //         script {
        //             sh "cat ${FILE_PATH}/version-increment.sh "
        //             sh "chmod 777 ${FILE_PATH}/version-increment.sh"
        //             res = sh(script:"${FILE_PATH}/version-increment.sh", returnStatus:true)
        //             if (res != 0) {
        //                 error 'Error in versoning images and files ..........................................'
        //             }
        //             def matcher = readFile('naming-server/pom.xml') =~ '<version>(.+)</version>'
        //             VERSION =  matcher[0][1]
        //             echo "${VERSION}"
        //         }
        //     }
        // }

        // stage('CODEBASE ANALYSIS') {
        //     steps {
        //         // Stage 4 sonarqube analysis is doing
        //         script {
        //             def dockerStatus = 1
        //             withSonarQubeEnv('sonarqube-setup') {
        //                 sh "chmod 777 ${FILE_PATH}/analise-code.sh"
        //                 dockerStatus = sh(script:"${FILE_PATH}/analise-code.sh", returnStatus:true)
        //                 echo "${dockerStatus}"
        //                 if (dockerStatus != 0) {
        //                     error 'Error in sonarqube file ..................................................'
        //                 }
        //                 echo 'Sonarqube scan was successfull'
        //             }
        //         }
        //     }
        // }

        // stage('DOCKER IMAGES BUILDING') {
        //     steps {
        //         // Stage 5 Building docker images and pushing it to docker
        //         script {
        //             echo 'Build Image Step Started '
        //             sh "chmod 777 ${FILE_PATH}/build-images.sh"
        //             res = sh(script:"${FILE_PATH}/build-images.sh", returnStatus:true)
        //             echo "${res}"
        //             if (res != 0) {
        //                 error 'Error in building image docker file...................................................'
        //             }
        //         }
        //     }
        // }
        // stage('DOCKER IMAGES PUSHING') {
        //     steps {
        //         // Stage 5 Building docker images and pushing it to docker
        //         script {
        //             withCredentials([usernamePassword(credentialsId: 'docker-server-token', passwordVariable: 'PASS', usernameVariable:'USER')]) {
        //                 echo 'Build Image Step Started '
        //                 sh "echo $PASS | docker login -u $USER --password-stdin"
        //                 sh "chmod 777 ${FILE_PATH}/rename-images.sh"
        //                 res = sh(script:"${FILE_PATH}/rename-images.sh ${VERSION}", returnStatus:true)
        //                 echo "${res}"
        //                 if (res != 0) {
        //                     error 'Error in pushing image docker file..................................................'
        //                 }
        //                 echo 'Pushing Images Step  is Completed... '
        //             }
        //         }
        //     }
        // }

        stage('IMAGES SERVER DEPLOYING') {
            steps {
                script {
                    // def serverCmd = 'bash ./server-cmds.sh'
                    sshagent(['ec2-user']) {
                        // sh "chmod 777 ${FILE_PATH}/helpCmd.sh"
                        sh 'docker images'
                        sh 'docker ps -a'
                        // echo "verson ${OLD_VERSION} =>>> ${VERSION}"
                        // sh "bash ${FILE_PATH}/helpCmd.sh ${VERSION}"
                        // sh 'scp .env ubuntu@3.108.28.110:/home/ubuntu'
                        // sh 'cat .env'
                        // sh 'rm .env'
                        // sh 'scp server-cmds.sh ubuntu@3.108.28.110:/home/ubuntu'
                        // sh 'scp docker-compose.yml ubuntu@3.108.28.110:/home/ubuntu'
                        sh 'ssh -o StrictHostKeyChecking=no ubuntu@3.108.28.110 whoami'
                    }
                }
            }
        }
        // stage('VERSION UPDATE') {
        //     steps {
        //         script {
        //             withCredentials([usernamePassword(credentialsId: 'github-server-token', passwordVariable: 'PASS', usernameVariable:'USER')]) {
        //                 sh 'git config --global user.email jenkins@btirt.com'
        //                 sh 'git config --global user.name jenkins'
        //                 sh 'git status '
        //                 sh "git remote set-url origin https://imshubhampatel:${PASS}@github.com/imshubhampatel/bt-management-microservices.git"
        //                 sh "chmod 777 ${FILE_PATH}/commit-bumb.sh"
        //                 echo "${VERSION}"
        //                 // sh "./commit-bumb.sh ${VERSION}"
        //                 res = sh(script:"${FILE_PATH}/commit-bumb.sh ${VERSION}", returnStatus:true)
        //                 sh "git push origin HEAD:${BRANCH_NAME}"
        //                 if (res != 0) {
        //                     error 'Error in making commits of images and files.........................................'
        //                 }
        //                 cleanWs()
        //             }
        //         }
        //     }
        // }
        // post {
        //         // Clean after build
        //         always {
        //             cleanWs(cleanWhenNotBuilt: false,
        //             deleteDirs: true,
        //             disableDeferredWipeout: true,
        //             notFailBuild: true,
        //             patterns: [[pattern: '.gitignore', type: 'INCLUDE'],
        //                        [pattern: '.propsfile', type: 'EXCLUDE']])
        //         }
        // }
    }
}
