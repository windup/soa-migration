
#### Overview
Routers and Notifiers in JBoss ESB either move messages between services, or provide a way of translating ESB-aware messages to some other format and send them to destinations outside of the bus.   

In JBoss ESB, routers and notifiers are both action-based.    Configuration for routers and notifiers in JBossESB takes place in child properties of the action, and those properties are specific to the specific router or notifier that you are using.   The properties in the router or notifier will In the example below from lab2, we can see a JMSRouter :

#### SOA 5 Configuration

```xml
<action name="routeToReplyQueue" class="org.jboss.soa.esb.actions.routing.JMSRouter">
    <property name="connection-factory" value="ConnectionFactory"/>
    <property name="jndiName" value="queue/quickstart_jms_router_routeTo"/>
    <property name="unwrap" value="true"/>
    <property name="security-principal" value="guest"/>
    <property name="security-credential" value="guest"/>

    <property name="jndi-prefixes" value="org.xyz."/>
    <property name="org.xyz.propertyName" value="propertyValue"/>

    <property name="java.naming.someproperty" value="propertyValue"/>
</action>
```

#### SOA 6 Configuration

###### Converting to a reference binding

In SwitchYard, bindings are used to transfer messages out of the bus to other services.   

The relevant bits of the application descriptor are included for reference:
```xml
    <sca:reference name="PrintService" multiplicity="0..1" promote="Route/PrintService">
      <sca:interface.java interface="org.switchyard.migration.gatewaysrouters.PrintService"/>
      <jms:binding.jms>
        <jms:queue>quickstart_jms_router_Request_gw</jms:queue>
        <jms:connectionFactory>#ConnectionFactory</jms:connectionFactory>
      </jms:binding.jms>
    </sca:reference>
```

