#!/usr/bin/env groovy

def call () {
    echo "building the docker image..."
   withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
      sh 'docker build -t hokage004/demo-app:2.0 .'
      sh 'docker login -u $USER -p $PASS'
      sh 'docker push hokage004/demo-app:2.0'
    }
}
