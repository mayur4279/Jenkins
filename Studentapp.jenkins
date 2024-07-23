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
                sh '/opt/maven/bin/mvn  clean  package -Dmaven.test.skip=true '
            }
        }
        
        stage('test') {
            steps {
                sh '''/opt/maven/bin/mvn sonar:sonar \\
                      -Dsonar.projectKey=myproject \\
                      -Dsonar.host.url=http://54.253.243.247:9000 \\
                      -Dsonar.login=fbec1e03e1a309a151cccfa5205ba448aeda39e1'''
            }
        }
        
        stage('deploy') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'tomcat', path: '', url: 'http://3.106.231.192:8080')], contextPath: '/', war: '**/*.war'
            }
        }
        
    }
}
