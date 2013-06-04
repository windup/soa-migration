
#### Overview
The ftp-bus element in jboss-esb.xml provides configuration for FTP listeners.  The configuration found in a ftp-bus definition can be converted into a Camel FTP binding types in SwitchYard:

#### SOA 5 Configuration

```xml
<ftp-bus busid="helloFTPChannel">
    <ftp-message-filter
        username="ftpboy"
        password="camel123."
        passive="false"
        directory="/tmp/ftpinput"
        input-suffix="ftpin.dat"
        work-suffix=".esbWorking"
        post-delete="false"
        post-rename="true"
        post-suffix=".COMPLETE"
        error-delete="false"
        error-suffix=".HAS_ERROR"/>
</ftp-bus>
```

#### SOA 6 Configuration

###### Converting to FTP binding
The information required to convert a ftp-bus definition to a FTP Binding:
* destination name - available in jms-bus/jms-message-filter/@dest-name
* destination type - available in jms-bus/jms-message-filter/@dest-type
* connection factory - the name of the managed connection factory to be used for connecting to the JMS broker (defaults to '#ConnectionFactory')

<img src="https://raw.github.com/windup/soa-migration/master/advice/ftp-wizard.jpg" width="50%" height="50%"/>

The relevant bits of the application descriptor are included for reference:
```xml
<jms:binding.jms>
    <jms:queue>queue/quickstart_helloworld_Request_gw</jms:queue>
    <jms:connectionFactory>#ConnectionFactory</jms:connectionFactory>
</jms:binding.jms>
```
