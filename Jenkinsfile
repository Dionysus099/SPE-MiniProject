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
        sh 'sudo docker build -t dionysus099/speminiproject /home/sahil/IdeaProjects/Sci-Calculator .'
      }
    }

    stage('Pushing Image to Docker Hub') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'f9ded957-e2ec-4364-b529-38cb06f5456b', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
          sh 'sudo docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD'
          sh 'sudo docker push dionysus099/speminiproject'
        }
      }
    }

    stage('Ansible Deploy') {
      steps {
        withCredentials([sshUserPrivateKey(credentialsId: 'your-ansible-credentials', keyFileVariable: 'SSH_KEY', passphraseVariable: '', usernameVariable: 'SSH_USER')]) {
          sshagent(['your-ansible-credentials']) {
            sh 'ansible-playbook -i inventory playbook.yml'
          }
        }
      }
    }
  }
}
