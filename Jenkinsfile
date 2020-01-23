    pipeline {

        agent {
            kubernetes {
                label 'mavenDockerPodTemplate'
                defaultContainer 'maven'

                }
            }

        options {
            buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
            timeout(time: 1, unit: 'HOURS')
            skipStagesAfterUnstable()
            }

        environment {
            USER_CREDENTIALS= credentials('jenkins-user')
        }

        stages {


            stage('Deploy: master') {

                    when { branch 'master' }

                    steps {
                        container('docker'){
                            sh 'chmod +x mvnw'
                            sh './mvnw'
                        }

                    }
            }
                
        }

    }
