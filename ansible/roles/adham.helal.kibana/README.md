kibana ansible role
===================
[![Build Status](https://travis-ci.org/ahelal/ansible-kibana.svg?branch=master)](https://travis-ci.org/ahelal/ansible-kibana)

[Kibana](http://www.elasticsearch.org/overview/kibana/) is a static frontend to
elasticsearch which allows you to monitor your data in realtime.

Requirements
------------

 - tested on Ubuntu 12.04 but should work with whatever :) 


Philosophy
---------

The role is designed to work without setting any variables. For flexibility nginx and elastic search are not installed and not set in meta requirements.

Role Variables
--------------

### Defaults

The role has default value that should work without modification unless you want to

kibana version to install

	kibana_version          : "3.1.0" 

Where to install kibabana

	kibana_base_dir         : "/opt/kibana"

Elastic search server to use (by default the deployed server)

	es_host                 : http://{{ansible_hostname}}

nginx fqdn if your using my nginx role this will be used (by default the deployed server)

	kibana_fqdn             : "{{ansible_hostname}}"


#### Dashboards

To maintain my dashboards I choose to deploy them and save them in git to keep track of them

To deploy dashboards 

	kibana_dashboard_inst   : true

Setup names and files of an array of dashboards

	kibana_dashboards :
                         - name: nginx.json
                           src : nginx.json 

                         - name: cool.json
                           src: /mnt/mydash/example.json

### Installing nginx

Two options
-  You can use my nginx role [nginx](https://github.com/ahelal/nginx.git) the settings are already set in vars/main.yml

-  Use your own role or any other role online

### Installing elastic search

You can use any role but I would recommend [ansible-elasticsearch](https://github.com/Traackr/ansible-elasticsearch.git)

Dependencies
------------
Dependecies are not enforced by the role and left for you to manage
 - Nginx 
 - Elasticsearch 

Author
------
 Adham Helal https://github.com/ahelal

