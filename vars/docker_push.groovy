def call(String Project, String ImageTag, String dockerhubuser){
   withCredentials([usernamePassword(credentialsId: 'DockerHubId', passwordVariable: 'DockerHubPass', usernameVariable: 'DockerHubUsername')]) {
     
            sh "echo ${DockerHubPass} | sudo docker login -u ${DockerHubUsername} --password-stdin"
            sh "sudo docker image tag todoapp:latest ${DockerHubUsername}/todoapp:latest"
            sh "sudo docker push ${DockerHubUsername}/${Project}:${ImageTag}"
            
        }
}
