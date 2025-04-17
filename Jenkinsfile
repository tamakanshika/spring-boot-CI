pipeline {
    agent any

    tools {
        jdk 'jdk-17'
        maven 'maven'
    }

    environment {
        IMAGE_NAME = 'springcicd-app'
        CONTAINER_NAME = 'springcicd-container'
        HOST_PORT = '8090'
        CONTAINER_PORT = '8090'
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-creds', url: 'https://github.com/tamakanshika/spring-boot-CI', branch: 'master'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

//         stage('Initialize'){
//                 def dockerHome = tool 'myDocker'
//                 env.PATH = "${dockerHome}/bin:${env.PATH}"
//             }


        stage('Docker Build & Deploy') {
            steps {
                script {
                    sh """
                    docker stop \$CONTAINER_NAME || true
                    docker rm \$CONTAINER_NAME || true
                    docker rmi \$IMAGE_NAME || true

                    docker build -t \$IMAGE_NAME .
                    docker run -d --name \$CONTAINER_NAME -p \$HOST_PORT:\$CONTAINER_PORT \$IMAGE_NAME
                    """
                }
            }
        }
    }

    post {
        success {
            echo 'Deployed successfully at http://localhost:8090'
        }
        failure {
            echo ' Deployment failed.'
        }
    }
}
