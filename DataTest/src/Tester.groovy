pipeline {
    agent none

    stages {
        stage('Run Tests') {
            agent { label 'VINUAGENT' }
            steps {
                script {
                    // Add your Groovy logic here, or run Maven directly with bat:
                    bat 'mvn clean test'
                }
            }
        }
    }
}