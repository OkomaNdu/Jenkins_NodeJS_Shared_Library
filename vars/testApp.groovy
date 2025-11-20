#!/usr/bin/env groovy

def call() {
    dir('app') {
        echo 'testing the application...'
        sh 'npm install'
        sh 'npm test'
    }
}