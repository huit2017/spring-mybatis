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
        stage('package') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('verify') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                jacoco execPattern: '**/target/jacoco.exec'
                findbugs(pattern:'**/target/findbugsXml.xml')
                checkstyle(pattern:'**/target/checkstyle-result.xml')
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
            slackSend channel: "#renshu", message: "${BUILD_TAG} : success"
            withCredentials([string(credentialsId: 'd2dfe2d2-e33b-4aff-8f23-1b119c64db65', variable: 'ApiKey')]) {
                sh 'curl -X POST -H "X-ChatWorkToken:$ApiKey" -d "body=$(git log -1)" "https://api.chatwork.com/v2/rooms/38341637/messages"'
            }
        }
        failure {
            slackSend channel: "#renshu", message: "${BUILD_TAG} : failure"
            withCredentials([string(credentialsId: 'd2dfe2d2-e33b-4aff-8f23-1b119c64db65', variable: 'ApiKey')]) {
                sh 'curl -X POST -H "X-ChatWorkToken:$ApiKey" -d "body=$(git log -1)" "https://api.chatwork.com/v2/rooms/38341637/messages"'
            }
        }
    }
}

