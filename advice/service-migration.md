
#### Overview
The equivalent of a SOA 5 service definition in SOA 6 is a called a composite service.  Each composite service definition in SOA 6 requires a service interface which defines the contract service consumers will use to invoke the service.

#### SOA 5 Configuration

```xml
<services>
   <service 
        category="Purchasing" 
        name="OrderService" 
        description="An Order Service">
   </service>
</services>
```

#### SOA 6 Configuration
A service definition in SOA 5 is comprised of a component service and a composite service in SOA 6.  The component service contains the implementation of the service and the composite service indicates that the service is accessible outside the application.  This relationship is depicted in the visual editor like this:

<img src="https://raw.github.com/windup/soa-migration/master/advice/composite-service.jpg" width="50%" height="50%"/>

The application configuration corresponding to the above model looks like this:
```xml
<composite name="hello_world-6" targetNamespace="urn:org.switchyard.migration:hello_world_6:1.0">
    <component name="OrderComponent">
        <service name="OrderService">
        </service>
    </component>
    <service name="OrderService" promote="OrderComponent/OrderService">
    </service>
</composite>
```

