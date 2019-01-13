pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'gradle build'
        bat 'gradle myJavaDocs'
        archiveArtifacts(artifacts: 'build/libs/*.jar , build/docs/javadoc/*', onlyIfSuccessful: true)
      }
      post {
      failure {
        mail(subject: 'build finished', body: 'build failed', to: 'fa_djellal@esi.dz')
      }
      success {
        mail(subject: 'build finished', body: 'build success', to: 'fa_djellal@esi.dz')
      }
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
    stage('Deployment') {
      when {
        branch 'master'
      }
      steps {
        bat 'gradle uploadArchives'
      }
    }
    stage('Slack Notification') {
      when {
        branch 'master'
      }
      steps {
        slackSend(channel: 'buildsjenkins', color: '#ffffff', message: 'tree reached slack notification')
      }
    }
  }
}
