# Getting Started


## What is this project about
This is an microservice which take weight and value array as an request along with allowed weight and return the array of optimum weights, total weight and max value.

## Assumptions
Used http Post method since it was not sure that how many characters user will enter as query param. Http Get method have limitation of 2048 character only.

## How to start the service locally
1. Open the command prompt
2. Go to root level of project
3. Execute maven command to download dependancies and build the project

```bash
mvn clean install
```
   
4. Go to service folder by executing below command in command prompt

```bash
cd service
```

5. Execute below maven command to start the service

```bash
mvn spring-boot:run
```
6. Once service is up hit the [url](http://localhost:8080/swagger-ui.html#/) http://localhost:8080/swagger-ui.html#/
to get the detials of the request and response body. You can test it out by providing inputs.


## How to start service with docker container

1. Open the command prompt
2. Go to root level of project
3. Go to service folder by executing below command in command prompt

```bash
cd service
```

4. Execute below command to build the docker image

```bash
docker build -f DockerFile -t optimize-weight-value-services-service .
```

5. Execute below command to run the image on a container

```bash
docker run -p 8080:8080 optimize-weight-value-services-service
```

6. Service is up and running in docker container.

#Deoployment

## Overview
- As soon as some commit will happen in repo, the pipe line will get triggered
- There is three stages in the pipeline i.e initialisation, build and deploy
- Initialisation stage will initialize the build environment
- Build stage will install the required dependencies and build the service
	-This stage will execute the unit test cases too
	-Once the build is successful it will create the docker image
	-It will push the docker image to docker hub
- Deploy stage will execute the ssh command in linux vm
	-First command will stop the container and remove the image
	-Second command will take the pull for new image from docker hub
	-Third command will run the docker container with newly pulled image
	
	```bash
	 docker stop owvs
    docker rm owvs
    docker pull naveen164/optimize-weight-value-services-service:latest
    docker run --publish=80:8080 -d --name owvs naveen164/optimize-weight-value-services-service:latest
	```
## Linux VM creation to deploy the service

1. Login to azure cli

```bash
az login --service-principal --username fab0bdde-e356-45d5-8b29-900f94229e41 --password qL?dP2=qT9qbP[-PULmykcNX6ZjTQqg4 --tenant 7634b95b-1c8a-4180-b7e9-c103ee2e082e
```

2. Create linux virtual machine

```bash
az vm create \
  --resource-group naveen_deployment_rg \
  --name VM-1 \
  --image UbuntuLTS \
  --admin-username azureuser \
  --generate-ssh-keys
```

3. Public IP address of VM is 40.127.181.34, open port 80 of VM

```bash
az vm open-port --port 80 --resource-group naveen_deployment_rg --name VM-1
```

4. Login to virtual machine

```bash
ssh azureuser@40.127.181.34
```

-- To hit the service in vm from your system please use ip 40.127.181.34
http://40.127.181.34:80/solve

--Note: Upload the ssh key files to create service connection in azure pipeline
### Reference Documentation
* [Official Azure Microsoft Docs To Create VM](https://docs.microsoft.com/en-us/azure-stack/user/azure-stack-quick-create-vm-linux-cli?view=azs-1910)
* [Official Azure DevOps Docs](https://docs.microsoft.com/en-us/azure/devops/?view=azure-devops)