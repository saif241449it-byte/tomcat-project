pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the Maven web application...'
                bat 'mvn clean package'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                echo 'Deploying WAR file to Tomcat...'

                withCredentials([
                    usernamePassword(
                        credentialsId: 'tomcat-credentials',
                        usernameVariable: 'TOMCAT_USER',
                        passwordVariable: 'TOMCAT_PASSWORD'
                    )
                ]) {
                    bat '''
                        curl.exe --fail --show-error --silent ^
                        --user "%TOMCAT_USER%:%TOMCAT_PASSWORD%" ^
                        --upload-file "target\\tomcat-demo-1.0.war" ^
                        "http://localhost:7080/manager/text/deploy?path=/tomcat-demo-1.0&update=true"
                    '''
                }
            }
        }
    }

    post {
        success {
            echo 'Build and deployment completed successfully.'
        }

        failure {
            echo 'Build or deployment failed. Check the Console Output.'
        }
    }
}
