pipeline {
    agent { label 'buildfarm' }

    stages {
        stage('Set Environment Variables and Build Options') {
            steps {
                script {
					cleanWs()
                	commonutils.setDefaultEnvironmentVariables()
                    commonutils.loadJenkinsEnvCommonsPropertiesFile()
                    commonutils.environmentVariablesFinalSteps()
                    commonutils.setBuildOptions("${env.LOG_ROTATOR_DAYS_TO_KEEP}", "${env.LOG_ROTATOR_NUMBER_TO_KEEP}", "${env.LOG_ROTATOR_ARTIFACT_DAYS_TO_KEEP}", "${env.LOG_ROTATOR_ARTIFACT_NUMBER_TO_KEEP}")
                    commonutils.checkoutScm()
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    mavengoals.build()
                }
            }
        }

        stage('Unit Tests') {
            steps {
                script {
                    mavengoals.unitTests()
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    mavengoals.runSonarScan()
                }
            }
        }

        stage('Build Docker Image') {
            environment {
                TAG = UUID.randomUUID().toString()
            }
            steps {
                script {
                    env.HOLDTAG="${TAG}"
                    dockergoals.buildDockerImage()
                }
            }
        }

        stage('Veracode Scan') {
            when { anyOf { branch "$DEVBRANCH"; branch "$RELEASEBRANCH"; branch "$HOTFIXBRANCH"; branch "$BUGFIXBRANCH" }}
            steps {
                script {
                    securityScan.performScans("${env.VERACODE_FILES_TO_SCAN}")
                }
            }
        }

        stage('Push Docker Image') {
            when { anyOf { branch "$DEVBRANCH"; branch "$RELEASEBRANCH"; branch "$HOTFIXBRANCH"; branch "$BUGFIXBRANCH"; branch "$FEATUREBRANCH" }}
            environment {
                TAG = "${env.HOLDTAG}"
            }
            steps {
                script {
                    dockergoals.pushImageToAws()
                }
            }
        }

        stage('Terraform') {
            steps {
                script {
                    fileutils.replaceTokensInTerraformFiles()
                }
            }
        }

        stage('Update UCD Component') {
            when { anyOf { branch "$DEVBRANCH"; branch "$RELEASEBRANCH"; branch "$HOTFIXBRANCH"; branch "$BUGFIXBRANCH"; branch "$FEATUREBRANCH" }}
            steps {
                script {
                    ucdgoals.createVersionWithArtifact()
                }
            }
        }
        
        stage('Deploy to Development Environment') {
            when { anyOf { branch "$DEVBRANCH"; branch "$RELEASEBRANCH"; branch "$HOTFIXBRANCH"; branch "$BUGFIXBRANCH"; branch "$FEATUREBRANCH" }}
            steps {
                script {
                    ucdgoals.runApplicationProcess()
                }
            }
        }
    }

    post {
        always {
            script {
                commonutils.finalSteps()
            }
        }
        success {
            cleanWs()
        }
    }
}
