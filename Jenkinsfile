pipeline {
    agent any

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
                        error "This pipeline is designed to run on a Unix-based system."
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
                        error "This pipeline is designed to run on a Unix-based system."
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
                        error "This pipeline is designed to run on a Unix-based system."
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
                        error "This pipeline is designed to run on a Unix-based system."
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
                        error "This pipeline is designed to run on a Unix-based system."
                    }
                }
            }
        }
    }
}
