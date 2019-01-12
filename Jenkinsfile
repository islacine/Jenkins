pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      steps {
        bat 'gradle build'
        bat 'gradle javadoc'
        archiveArtifacts 'target/*.jar,target/*.html,target/*.css'
      }
    }
  }
}