pipeline {
    agent any

    stages {
        stage('pull') {
            steps {
                git 'https://github.com/sharadrathod/studentapp-ui.git'
            }
        }

        stage('build') {
            steps {
                sh 'mvn  clean  package -Dmaven.test.skip=true '
            }
        }
        
        stage('test') {
            steps {
                sh '''mvn sonar:sonar \\
                      -Dsonar.projectKey=myproject \\
                      -Dsonar.host.url=http://54.253.243.247:9000 \\
                      -Dsonar.login=fbec1e03e1a309a151cccfa5205ba448aeda39e1'''
            }
        }
    }
}
