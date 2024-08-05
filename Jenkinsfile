pipeline {
   agent any

stages {
 
    stage("Git Clone"){
     steps {

        git credentialsId: 'GIT_HUB_CREDENTIALS', url: 'https://github.com/hazelsoft-in/student-enroll.git'
     }
    }
    
    stage('Gradle Build') {
   steps {

       sh './gradlew clean build'
     }
    }
    
    stage("Docker build"){
    steps {
        sh 'docker version'
        sh 'docker build -t student-enroll .'
        sh 'docker image list'
        sh 'docker tag student-app sandeeplv/student-enroll:$BUILD_NUMBER'
     }
    }
    
    stage("Docker Login"){
     steps {
        withCredentials([string(credentialsId: 'DOCKER_HUB_PASSWORD', variable: 'PASSWORD')]) {
            sh 'docker login -u sandeeplv -p $PASSWORD'
        }
     }
    }
    
    stage("Push Image to Docker Hub"){
     steps {
        sh 'docker push sandeeplv/student-enroll:$BUILD_NUMBER'
    }
    }
    
    stage("K8 Deploy") {
    steps {
        
       sh 'kubectl apply -f deploy.yaml'
      }
    }
 }
    
    
}