$install=<<SCRIPT
if [ -f "/ var/ vagrant_provision" ]; then
    exit 0
fi
echo "Updating package lists..."
sudo apt-get update
sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add 
sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"
sudo apt-get update
echo "Installing Docker..."
sudo apt-get install docker-ce
sudo service docker start
sudo systemctl enable docker
echo "Installing Git..."
sudo apt-get install git
echo "Installing OpenJDK 8..."
sudo apt-get install openjdk-8-jdk
echo "Installing Maven..."
sudo apt-get install maven
touch /var/ vagrant_provision
SCRIPT

$build=<<SCRIPT
echo "Clone project from Git"
git clone "https://github.com/saptarshibasu/spring-boot-docker.git"
cd spring-boot-docker
echo "Building source code"
sudo mvn clean install dockerfile:build
sudo docker run -d -p 8080:8080 docker/spd
SCRIPT
   

Vagrant.configure("2") do |config|
    config.vm.box = "ubuntu/trusty64"
    config.vm.network "forwarded_port", guest: 8080, host: 8080
    config.vm.provider "virtualbox" do |v|
        v.name = "spring-boot-docker"
        v.memory = 2048
        v.cpus = 2
    end
    
    
    config.vm.provision "shell", inline: $install
    config.vm.provision "shell", inline: $build
end
