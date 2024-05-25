pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build Project'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Test Project'
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploy Project'
            }
        }
    }
    
    post {
        always {
            echo "DONE"
        }
        failure {
            echo 'Build failed!'
        }
    }
}
