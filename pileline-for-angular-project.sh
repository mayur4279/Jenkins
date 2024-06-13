pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/mayur4279/Angular-app-Deployment.git'

                // Run Maven on a Unix agent.
                sh '''cd  spring-backend
                      /opt/maven/bin/mvn  clean package  -Dmaven.test.skip=true
                   '''
            }
            
        }
    }
}
