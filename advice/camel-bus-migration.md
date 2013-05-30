
#### Overview
The camel-bus element in jboss-esb.xml provides configuration for the Camel gateway.  The configuration found in a camel-bus definition can be converted into a Camel binding in SwitchYard:

#### SOA 5 Configuration

```xml
<camel-bus busid="bus1">
    <from uri="file:///tmp/input?delete=true"/>
</camel-bus>
```

#### SOA 6 

###### Converting to Camel binding 
You will need the following pieces of information to migrate a camel-bus definition to a Camel binding:
* from URI - available in camel-bus

The relevant bits of the application descriptor are included for reference:
```xml
      <camel_1:binding.uri configURI="file:///tmp/input?fileName=filein.dat">
        <camel_1:contextMapper/>
      </camel_1:binding.uri>
```

#### Converting to File binding
This configuration could also be converted to a file binding using the SwitchYard tools : 

The information required to convert this camel-bus definition to a File Binding:
* file/directory name

<img src="https://raw.github.com/windup/soa-migration/master/advice/file-wizard.jpg" width="50%" height="50%"/>




