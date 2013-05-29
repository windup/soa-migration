
#### Overview
The jms-bus element in jboss-esb.xml provides configuration for JMS listeners.  The configuration found in a jms-bus definition can be converted into one of two binding types in SwitchYard:

1. JCA (binding.jca)
2. JMS (binding.jms)

#### SOA 5 Configuration

```xml
<jms-bus busid="quickstartGwChannel">
    <jms-message-filter
        dest-type="QUEUE"
        dest-name="queue/quickstart_helloworld_Request_gw"/>
</jms-bus>
```

#### SOA 6 Configuration

###### Converting to JCA
You will need the following pieces of information to migrate a jms-bus definition to a JCA binding:
* destination name - available in jms-bus/jms-message-filter/@dest-name
* destination type - available in jms-bus/jms-message-filter/@dest-type
* Resource Adapter name - the name of the .rar used to configure your message broker as a JCA resource adapter.  This is "hornetq-ra.rar" for HornetQ.

The easiest way to configure these values is to use the New JCA Binding Wizard in the SwitchYard visual editor:
<img src="https://raw.github.com/windup/soa-migration/master/advice/jca-wizard.jpg" width="50%" height="50%"/>

The relevant bits of the application descriptor are included for reference:
```xml
<jca:binding.jca>
    <jca:inboundConnection>
        <jca:resourceAdapter name="hornetq-ra.rar" type="javax.resource.spi.ResourceAdapter"/>
        <jca:activationSpec type="javax.resource.spi.ActivationSpec">
            <jca:property name="destinationType" value="javax.jms.Queue"/>
            <jca:property name="destination" value="queue/quickstart_helloworld_Request_gw"/>
        </jca:activationSpec>
    </jca:inboundConnection>
    <jca:inboundInteraction>
        <jca:listener>javax.jms.MessageListener</jca:listener>
        <jca:endpoint type="org.switchyard.component.jca.endpoint.JMSEndpoint"/>
    </jca:inboundInteraction>
</jca:binding.jca>
```

###### Converting to JMS
The information required to convert a jms-bus definition to a JMS Binding:
* destination name - available in jms-bus/jms-message-filter/@dest-name
* destination type - available in jms-bus/jms-message-filter/@dest-type
* connection factory - the name of the managed connection factory to be used for connecting to the JMS broker (defaults to '#ConnectionFactory')

<img src="https://raw.github.com/windup/soa-migration/master/advice/jms-wizard.jpg" width="50%" height="50%"/>

The relevant bits of the application descriptor are included for reference:
```xml
<jms:binding.jms>
    <jms:queue>queue/quickstart_helloworld_Request_gw</jms:queue>
    <jms:connectionFactory>#ConnectionFactory</jms:connectionFactory>
</jms:binding.jms>
```
