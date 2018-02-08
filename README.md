# spring-boot-docker

This is a small demo project. The project has the following features.
1. Exposes a REST endpoint: http://localhost:8080/resources/hello
2. The REST endpoint is hosted in a Spring Boot application
3. The Spring Boot application is launched in a docker container
4. The development environment is created using Vagrant

## The Tools
1. Eclipse IDE
2. Vagrant
3. VirtualBox
4. Git

## The Steps to Launch the Development Environment
1. Set an environment variable - MYENV=DEV
2. Clone the Git repository: https://github.com/saptarshibasu/spring-boot-docker.git
3. Got to the directory: spring-boot-docker
4. Run `vagrant up`
Any change in the source code in the host machine will now be detected automatically by Spring DevTools and the Sprin Boot Embedded Tomcat will be automatically restarted in the virtual machine to reflect the changes at the endpoint http://localhost:8080/resources/hello

## The Steps to Build and Launch the Docker Image:
1. Remove the environment variable MYENV
2. Run vagrant up --provision (The --provision option will fetch the source code from the GitHub, build it and create the docker image. If the --provision is not given, the docker image created last time will be used)

## Shutdown
1. `vagrant halt` will shutdown the virtual machine
2. `vagrant destroy` will destroy the virtual machine
