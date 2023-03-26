pipeline {
  agent any

  stages {
    stage('Git Pull') {
      steps {
        git 'https://github.com/Dionysus099/SPE-MiniProject.git'
      }
    }

    stage('Maven build') {
      steps {
        sh 'mvn clean package'
      }
    }

    stage('Docker Image creation') {
      steps {
        sh 'docker build -t dionysus099/speminiproject /home/sahil/IdeaProjects/Sci-Calculator .'
      }
    }

    stage('Pushing Image to Docker Hub') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'f9ded957-e2ec-4364-b529-38cb06f5456b', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
          sh 'docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD'
          sh 'docker push dionysus099/speminiproject'
        }
      }
    }

    stage('Ansible Deploy') {
      steps {
        withCredentials([sshUserPrivateKey(credentialsId: '4b4f0fef-f7f6-4cf9-a818-7026d2100806', keyFileVariable: 'SSH_KEY', passphraseVariable: '', usernameVariable: 'SSH_USER')]) {
          sshagent(['4b4f0fef-f7f6-4cf9-a818-7026d2100806']) {
            sh 'ansible-playbook -i inventory playbook.yml'
          }
        }
      }
    }
  }
}
