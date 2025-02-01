pipeline {
    agent any

    tools {
        maven 'Maven' // Ensure that 'Maven' matches the name configured in the Jenkins global tool configuration
    }

    environment {
        DOCKER_IMAGE = "myrepo/my-vaadin-app"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Pawaffle/StockMaster3000.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn clean package -DskipTests'
                    } else {
                        bat 'mvn clean package -DskipTests'
                    }
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn test'
                    } else {
                        bat 'mvn test'
                    }
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'docker build -t $DOCKER_IMAGE .'
                    } else {
                        bat 'docker build -t %DOCKER_IMAGE% .'
                    }
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    if (isUnix()) {
                        withDockerRegistry([credentialsId: 'docker-hub', url: 'https://index.docker.io/v1/']) {
                            sh 'docker tag $DOCKER_IMAGE $DOCKER_IMAGE:latest'
                            sh 'docker push $DOCKER_IMAGE:latest'
                        }
                    } else {
                        withDockerRegistry([credentialsId: 'docker-hub', url: 'https://index.docker.io/v1/']) {
                            bat 'docker tag %DOCKER_IMAGE% %DOCKER_IMAGE%:latest'
                            bat 'docker push %DOCKER_IMAGE%:latest'
                        }
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    if (isUnix()) {
                        sshagent(['server-ssh-key']) {
                            sh """
                            ssh user@your-server 'docker pull $DOCKER_IMAGE:latest'
                            ssh user@your-server 'docker stop vaadin-app || true'
                            ssh user@your-server 'docker run -d --rm -p 8080:8080 --name vaadin-app $DOCKER_IMAGE:latest'
                            """
                        }
                    } else {
                        echo "Skipping deployment. SSH-based deployment is not configured for Windows."
                    }
                }
            }
        }
    }
}
