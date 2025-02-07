pipeline {

    agent any

    tools {

        nodejs 'NodeJS 18'

    }
 
    stages {

        stage('Build') {

            steps {

                echo "Cloning the application from GitHub..."

                git 'https://github.com/eMahtab/node-express-hello-world.git'

                echo "Installing dependencies..."

                sh 'npm install'

            }

        }
 
        stage('Test') {

    steps {

        echo "Starting the application for testing..."

        sh 'nohup npm start & sleep 10' 

        sh 'curl --retry 5 --retry-delay 5 --retry-connrefused http://localhost:3000'
    }

}
 
 
        stage('Deploy') {

            steps {

               echo 'Successfully deployed'

            }

        }

    }

    post {

        always {

            echo 'Cleaning up after the pipeline.'

            sh 'pkill -f "node app.js" || true' 

        }

        success {

            echo 'Pipeline completed successfully!'

        }

        failure {

            echo 'Pipeline failed. Please check the logs for details.'

        }

    }

}

 