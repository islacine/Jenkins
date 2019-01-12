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
    stage('Deployment') {
      steps {
        bat 'gradle uploadArchives'
      }
    }
    stage('Slack Notification') {
      steps {
        slackSend(channel: 'buildsjenkins', color: '#ffffff', message: 'jenkins reached slack build ')
      }
    }
  }
}
