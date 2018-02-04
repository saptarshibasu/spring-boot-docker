$install=<<SCRIPT
if [ -f "/var/vagrant_provision" ]; then
    exit 0
fi
echo "Updating package lists..."
sudo apk update
echo "Installing Docker..."
sudo apk add docker
sudo service docker start
echo "Installing Git..."
sudo apk add git
echo "Installing OpenJDK 8..."
sudo apk add openjdk8
echo "Installing Maven..."
sudo apk add maven
sudo touch /var/vagrant_provision
SCRIPT

$build=<<SCRIPT
echo "Clone project from Git"
git clone "https://github.com/saptarshibasu/spring-boot-docker.git"
cd spring-boot-docker
echo "Building source code"
sudo mvn clean install dockerfile:build
cd target/docker
sudo docker run -d sbd
SCRIPT
   

Vagrant.configure("2") do |config|
    config.vm.box = "maier/alpine-3.6-x86_64"
    config.vm.network "forwarded_port", guest: 8080, host: 8080
    config.vm.provider "virtualbox" do |v|
        v.name = "spring-boot-docker"
        v.memory = 1024
        v.cpus = 2
    end
    
    
    config.vm.provision "shell", inline: $install
    config.vm.provision "shell", inline: $build
end
