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
            TO= readMavenPom().getProperties().getProperty('TO')
            CC= readMavenPom().getProperties().getProperty('CC')
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
        
        post {
        
            always {
                mail bcc:"${TO}" , body: "<br>Build tag : ${env.BUILD_TAG}<br>Build Status: ${currentBuild.result}<br>Build Url: ${env.BUILD_URL}<br>triggered by: ${readFile('commit-author.txt').trim()}<br><br>Cucumber Report : https://jenkins.advyteam.com/view/QA/job/Functional_Test_Automation_Nightly/${env.BUILD_NUMBER}/cucumber-html-reports/overview-features.html  ",
                cc: "${CC}",
                charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "Jenkins Build Number ${env.BUILD_NUMBER} for: ${env.JOB_NAME}", to: readFile('commit-author.txt').trim()
            }
        }


    }
