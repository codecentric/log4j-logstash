
Oracle/Open JDK role for Ubuntu Saucy (13.10)
------------

This role installs Oracle JDK or OpenJDK on Ubuntu Saucy Salamander (13.10).

Role Variables
--------------

The role has three variables:
  - `java_ubuntu_saucy_jdk`: specifies whether to install the Oracle JDK or the OpenJDK, values are: `openjdk` or `oracle`.
  - `java_ubuntu_saucy_jdk_version`: specifies the version you wish to install, can be either one of these: 6, 7, 8.
  - `java_ununtu_saucy_jdk_version_default`: specifies the version to set as default java version, only works with Oracle JDK.

By default, the variables refers to openjdk 7 (so there's no need to explicitly set them if you wish to install that version).

Example Playbook
-------------------------

An example playbook might look like:

    - hosts: servers
      roles:
         - role: ahazem.java_ubuntu_saucy
           java_ubuntu_saucy_jdk: oracle
           java_ubuntu_saucy_jdk_version: 7
           java_ubuntu_saucy_jdk_version_default: 7
           
