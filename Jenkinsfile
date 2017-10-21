pipeline {
    agent {
        label 'maven'
    }
    stages {
        stage('checkout - git') {
            steps {
                git url:'git@github.com:huit2017/spring-mybatis.git', credentialsId: '8505e445-6221-4656-82f6-da163131340a'
            }
        }
        stage('build - maven') {
            steps {
                sh 'mvn clean package'
                sh 'mvn package'
            }
        }
        stage('deploy - tomcat') {
            steps {
                sh 'curl --upload-file /home/jenkins/workspace/spring-mybatis/web/target/web-0.0.1-SNAPSHOT.war "http://deploy:s3cret@192.168.33.12:8080/manager/text/deploy?path=/spring-mybatis&update=true"'
            }
        }
    }
    post {
        success {
            slackSend channel: "#renshu", message: "Build success: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
        }
        failure {
            slackSend channel: "#renshu", message: "Build failure: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
        }
    }
}

