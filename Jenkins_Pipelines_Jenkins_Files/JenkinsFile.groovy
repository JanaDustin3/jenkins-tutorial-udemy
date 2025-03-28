pipeline{
    agent any

    environment {
        // Define environment variables here
        MY_ENV_VAR = 'Custom Value'
    }

    stages{
        stage('build'){
            steps{
                echo "first stage"
            script{
                dir
                bat java --version
                bat cd jenkins-tutorial-udemy\maven-samples\single-module
                bat mvn clean install

            }
            }
           
        }
        stage('test'){
            steps{
                echo "second stage"
            }
        }
        stage('deploy'){
            steps{
                echo "third stage"
                echo "my environmental variable is $MY_ENV_VAR"
            }
        }
        stage('final'){
            steps{
                echo "pipeline succeeded"
            }
        }
    }
}