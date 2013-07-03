##SOA Migration
This project hosts a number of lab examples, rules, and microsites for useful in migrating JBoss ESB projects to SwitchYard.   The contents of this project are designed to be used in conjunction with the windup tool.

####Contents :

**advice**:  A number of microsites which document how to migrate specific jboss-esb.xml configuration elements to SwitchYard.

**labs**: A number of examples which show a JBoss ESB project and the corresponding completed SOA 6 migration of that project.

**rules** : Windup rules for SOA Migration.     The soa5.windup.xml contains a number of rules not contained int he default windup rules, it is suggested that once you have built and installed windup, you should copy soa5.windup.xml to the rules/extensions directory in windup. 

**xsl** : XSL documents designed to produce direct mappings from JBoss ESB configuration (jboss-esb.xml) to SwitchYard (switchyard.xml).   

####Instructions on running windup with the soa-migration examples :

Download and build windup.    Then, unpack the windup distribution: 
`sh% cp -r windup/windup-cli/target/windup-cli-0.7.0-bin .`
<br/>
Copy the soa-windup rules into extensions : 
`sh% cp soa-migration/rules/soa5.windup.xml windup-cli-0-7-0.bin/windup-cli-0.7.0/rules/extensions`
<br/>
Run windup on your JBoss ESB project.   Instructions on how to run windup can be found <a href="https://github.com/windup/windup/wiki/3.0-Execute-Windup">here</a>.    If you wish to run windup on the soa-migration labs, there are scripts included.    You only need to set a WINDUP_HOME environment variable to point to your windup distribution. 

`sh% cd soa-migration/labs/lab1`
`sh% ./windup.sh` 

