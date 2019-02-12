# Jenkins master & slave containers in Docker

Task: Deploy Jenkins master and jenkins docker slave and build maven project

## Requirements to make everything works well
 * [Installed Vagrant](https://www.vagrantup.com/downloads.html)
 ```bash
 brew cask install vagrant
 ```
 * [Installed VirtualBox](https://www.virtualbox.org/wiki/Downloads)
 ```
 brew cask install virtualbox
 ```
 * Install Vagrant plugin for VirtualBox 
 ```bash
 vagrant plugin install vagrant-vbguest
 ```
 * Generate SSH key
 if this is the first vagrant installation, you should generate SSH key for access to virtual machines which will provision by Vagrant. If `~/.vagrant.d/insecure_private_key` file doesn't exist, run this command.
 ```
 ssh-keygen -f ~/.vagrant.d/insecure_private_key
 ```

 ### Now we can begin to build the project
 * Clone this project to your machine
 ```bash
 cd /your/prefered/path/to/the/project
 git clone https://github.com/agrogov/Jenkins.Docker.git
 ```
 * Change to vagrant directory in the project
 ```bash
 cd /path/to/the/project/Jenkins.Docker/vagrant
 ```
 * Build & start Vagrant VM.
 ```
 vagrant up
 ```

It may takes up to 5-6 minutes to Jenkins Docker slave up and start to build the test job automatically after VM provisioning finished

![containers](/images/containers.png "Jenkins master & slave containers")

you may navigate your web browser to the test job in [Jenkins WUI](http://localhost:8980/job/maven_test_autodeploy/)
```bash
http://localhost:8980/job/maven_test_autodeploy/
```

To authenticate use following credentials:
```bash
Login: admin
Password: 5691cab0813b49759163b224648fbe70
```

In a few minutes you'll get a builded artifact

![pipeline](/images/pipeline.png "Complete pipeline")

