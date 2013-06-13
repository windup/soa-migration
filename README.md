##SOA Migration
This project hosts a number of lab examples, rules, and microsites for the 2013 Red Hat Conference "Migrating Applications from Red Hat JBoss SOA Platform 5 to 6" hands on lab.   The contents of this project are designed to be used in conjunction with the windup tool.

####Contents :

**advice**:  A number of microsites which document how to migrate specific jboss-esb.xml configuration elements to SwitchYard.

**labs**: A number of examples which show a SOA 5 project and the corresponding completed SOA 6 migration of that project.

**rules** : Windup rules for SOA Migration.     The soa5.windup.xml contains a number of rules not contained int he default windup rules, it is suggested that once you have built and installed windup, you replace rules/base/windup/xml/xml-jboss-esb-config.windup.xml with the contents of soa5.windup.xml. 

**xsl** : XSL documents designed to produce direct mappings from JBoss ESB configuration (jboss-esb.xml) to SwitchYard (switchyard.xml).   
