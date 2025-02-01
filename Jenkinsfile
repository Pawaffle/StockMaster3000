pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "myrepo/my-vaadin-app"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Pawaffle/StockMaster3000.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: 'docker-hub', url: 'https://index.docker.io/v1/']) {
                    sh 'docker tag $DOCKER_IMAGE $DOCKER_IMAGE:latest'
                    sh 'docker push $DOCKER_IMAGE:latest'
                }
            }
        }

        stage('Deploy') {
            steps {
                sshagent(['server-ssh-key']) {
                    sh """
                    ssh user@your-server 'docker pull $DOCKER_IMAGE:latest'
                    ssh user@your-server 'docker stop vaadin-app || true'
                    ssh user@your-server 'docker run -d --rm -p 8080:8080 --name vaadin-app $DOCKER_IMAGE:latest'
                    """
                }
            }
        }
    }
}
