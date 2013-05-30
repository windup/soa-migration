
#### Overview
The SOAPProxy action in JBoss ESB provides configuration for the re-publication of a WS endpoint via the ESB.  In JBoss ESB, the SOAPProxy creates a proxied WS endpoint for you under the covers.    In SwitchYard, you must configure a SOAP binding to represent the proxy and also define the routing in Camel between the proxy and the original WS endpoint.

#### SOA 5 Configuration

```xml
<action name="proxy" class="org.jboss.soa.esb.actions.soap.proxy.SOAPProxy"> 
    <property name="wsdl" value="internal://jboss.ws:context=Quickstart_webservice_proxy_basic_ws,endpoint=HelloWorldWS"/>
</action>
```

#### SOA 6 

#### Converting to SOAP binding
This configuration could also be converted to a SOAP binding using the SwitchYard tools, if the purpose of the http-gateway was to expose  a web service or web service proxy: 

The information required to convert this camel-bus definition to a File Binding:
* wsdl
* port number 

<img src="https://raw.github.com/windup/soa-migration/master/advice/soap-wizard.jpg" width="50%" height="50%"/>


#### Define the Camel routing




