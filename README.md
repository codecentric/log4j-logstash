log4j-logstash
==============

A vagrant Multi Machine Installation to test log4j-logstash integration

Usage
====

There are two vagrant machines available:
* logstash: Contains Elasticsearch as a Docker Container, Logstash via APT, nginx and kibana via ansible
* tomcat: Contains Tomcat, Pet Clinic and Maven

* Tomcat can be accessed via http://localhost:8080
* Elasticsearch can be accessed via http://localhost:9300
* Kibana can be accessed via http://localhost:8000

* The spring-pet-clinic is a git sub repository in the /vagrant folder, so editing in HOST and deployment in GUEST is no problem. 
* The spring-pet-clinic is initially not deployed, this can be done by loggin in via: vagrant ssh tomcat
* Catalina Home will be in /vagrant/local/apache-tomcat-8 to allow modification via the HOST
* Tomcat is installed as a service and can be started / stopped via: sudo service tomcat XXX

 Steps
 =====
 
* git submodule init
* git submodule update
* vagrant up
* vagrant ssh tomcat
	* cd /vagrant/spring-petclinic/
	* mvn clean install
	* cp /vagrant/spring-petclinic/target/petclinic.war /vagrant/local/apache-tomcat-8/webapps
	* sudo service tomcat start
	* exit
* vagrant ssh gatling
	* /vagrant/local/gatling-2/bin/gatling.sh -sf /vagrant/gatling-test/