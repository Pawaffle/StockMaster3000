pipeline {
    agent any

    tools {
        maven 'Maven'  // This is the name you gave your Maven installation in Jenkins
    }

    environment {
        DOCKER_IMAGE = "saedabukar/stockmaster3000"  // Replace with your Docker Hub repository name
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
                        sh 'docker build -t "$DOCKER_IMAGE" .'
                    } else {
                        bat 'docker build -t "%DOCKER_IMAGE%" .'
                    }
                }
            }
        }

        stage('Test Docker Image') {  // New stage to test the Docker image
            steps {
                script {
                    echo "Testing Docker image..."
                    if (isUnix()) {
                        // Run the Docker image and check if it's working
                        sh 'docker run -d --name test-container "$DOCKER_IMAGE"'
                        sh 'docker ps -a'  // To verify the container is running
                        sh 'docker logs test-container'  // Check logs for any errors
                        sh 'docker stop test-container'  // Stop the container after test
                        sh 'docker rm test-container'    // Remove the container
                    } else {
                        bat 'docker run -d --name test-container "%DOCKER_IMAGE%"'
                        bat 'docker ps -a'  // Verify the container is running
                        bat 'docker logs test-container'  // Check logs
                        bat 'docker stop test-container'
                        bat 'docker rm test-container'
                    }
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    // Use docker.withRegistry() to push image to Docker Hub
                    docker.withRegistry('', 'dockerhub-credentials') {
                        if (isUnix()) {
                            // Tag and push the Docker image
                            sh 'docker tag "$DOCKER_IMAGE" "$DOCKER_IMAGE:latest"'
                            sh 'docker push "$DOCKER_IMAGE:latest"'
                        } else {
                            bat 'docker tag "%DOCKER_IMAGE%" "%DOCKER_IMAGE%:latest"'
                            bat 'docker push "%DOCKER_IMAGE%:latest"'
                        }
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo "Deployment to Docker Hub complete. No deployment to a server configured for this pipeline."
                }
            }
        }
    }
}
