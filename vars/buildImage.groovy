#!/usr/bin/env groovy

def call (String imageName) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t ndubuisip/demo-app:${imageName} ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push ndubuisip/demo-app:${imageName}"
    }
}