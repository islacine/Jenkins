pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'gradle build'
        bat 'gradle myJavaDocs'
        archiveArtifacts(artifacts: 'build/libs/*.jar , build/docs/javadoc/*', onlyIfSuccessful: true)
      }
    }
    stage('Mail Notification') {
      steps {
        mail(subject: 'build finished', body: 'build finished', to: 'fa_djellal@esi.dz')
      }
    }
    stage('Code Analysis') {
      parallel {
        stage('Code Analysis') {
          steps {
            withSonarQubeEnv('sonarqube') {
              bat 'sonar-scanner'
            }

            waitForQualityGate true
          }
        }
        stage('Test Reporting') {
          steps {
            jacoco(buildOverBuild: true)
          }
        }
      }
    }
  }
}