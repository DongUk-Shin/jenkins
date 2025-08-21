pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-token',
                    url: 'https://github.com/DongUk-Shin/jenkins.git',
                    branch: 'main'
            }
        }

        stage('Build with Dockerfile') {
            steps {
                dir('jenkins') {
                    sh '''
                        echo "Docker로 빌드 환경 구성 및 빌드 실행"
                        docker build -t myapp:build .
                    '''
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Docker 빌드에서 테스트는 이미 포함되어 있습니다.'
                // 또는 docker run으로 별도 테스트 컨테이너 실행 가능
            }
        }

        stage('Deploy') {
            steps {
                echo '서버에 배포 중...'

                sh '''
                    echo "기존 컨테이너 중지 및 삭제"
                    docker stop myapp-container || true
                    docker rm myapp-container || true

                    echo "컨테이너 실행"
                    docker run -d --name myapp-container -p 9000:8080 myapp:build
                '''
            }
        }
    }
}
