
#### Overview
The http-gateway element in jboss-esb.xml provides configuration for the HTTP gateway.  In JBoss ESB, the http-gateway is used in many places to expose a SOAPProxy over HTTP.  In SwitchYard, the HTTP gateway can be either converted into a HTTP binding in SwitchYard, or a SOAP binding may suffice if the http-gateway's function was to expose a web service over HTTP.

#### SOA 5 Configuration

```xml
<listeners>
    <http-gateway name="Proxy_Basic-GwListener" />
</listeners>
```

#### SOA 6 

###### Converting to HTTP binding 
In order to convert a HTTP gateway to a SwitchYard HTTP binding, you'll need to configure the following : 

* the operation 
* context path 

The relevant bits of the application descriptor are included for reference:
```xml
<http:binding.http>
   <selector:operationSelector operationName="getPrice"/>
   <http:contextPath>http-binding/quote</http:contextPath>
</http:binding.http>
```

#### Converting to SOAP binding
This configuration could also be converted to a SOAP binding using the SwitchYard tools, if the purpose of the http-gateway was to expose  a web service or web service proxy: 

The information required to convert this camel-bus definition to a File Binding:
* wsdl
* port number 

<img src="https://raw.github.com/windup/soa-migration/master/advice/soap-wizard.jpg" width="50%" height="50%"/>




