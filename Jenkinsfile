pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-token',  // ← 자격 증명 ID
                    url: 'https://github.com/DongUk-Shin/jenkins.git',
                    branch: 'main'
            }
        }

        stage('Build') {
            steps {
                dir('jenkins') {  // ← gradlew와 build.gradle이 위치한 폴더
                    sh '''
                        chmod +x ./gradlew
                        ./gradlew clean build
                    '''
                }
            }
        }

        stage('Test') {
            steps {
                dir('jenkins') {
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
