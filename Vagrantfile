# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  # All Vagrant configuration is done here. The most common configuration
  # options are documented and commented below. For a complete reference,
  # please see the online documentation at vagrantup.com.

  # Every Vagrant virtual environment requires a box to build off of.
  config.vm.box = "hashicorp/precise64"

  config.vm.define :tomcat do |tomcat|
    tomcat.vm.hostname = "tomcat"
    
    tomcat.vm.network :forwarded_port, guest:8080, host: 8080
    tomcat.vm.network :private_network, ip: "192.168.5.2"
    
    tomcat.vm.provision :ansible do |ansible|
      ansible.playbook = "ansible/common.yml"
    end
  end

  config.vm.define :logstash do |logstash|
    logstash.vm.hostname = "logstash"
    
    logstash.vm.network :forwarded_port, guest:80, host: 8000
    logstash.vm.network :forwarded_port, guest:9200, host: 9200
    logstash.vm.network :forwarded_port, guest:9300, host: 9300
    logstash.vm.network :private_network, ip: "192.168.5.3"
    
    logstash.vm.provision :docker do |d|
        d.run "dockerfile/elasticsearch",
          args: "-p 9200:9200 -p 9300:9300"
      end
    
    logstash.vm.provision :ansible do |ansible|
      ansible.playbook = "ansible/common.yml"
    end
  end

  config.vm.define :gatling do |gatling|
    gatling.vm.hostname = "gatling"
    
    gatling.vm.network :private_network, ip: "192.168.5.4"
    
    gatling.vm.provision :ansible do |ansible|
      ansible.playbook = "ansible/common.yml"
    end
  end
end
