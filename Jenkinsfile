pipeline {
    agent any  // 모든 Jenkins 노드에서 실행

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/DongUk-Shin/jenkins.git'
            }
        }

        stage('Build') {
            steps {
                dir('backend') {
                    sh './gradlew clean build'
                }
            }
        }

        stage('Test') {
            steps {
                dir('backend') {
                    sh './gradlew test'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo '서버에 배포 중...'
                // 예: scp 또는 docker-compose up -d
            }
        }
    }
}
