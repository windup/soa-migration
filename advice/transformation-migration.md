
#### Overview
The SmooksAction action provides a means for invoking a Smooks transformation.  The configuration found in a the SmooksAction definition can be converted into a transformation in SwitchYard:

#### SOA 5 Configuration

```xml
<action name="transform" class="org.jboss.soa.esb.smooks.SmooksAction">
    <property name="smooksConfig" value="/smooks-res.xml" />
    <property name="resultType" value="JAVA" />
</action>
```

#### SOA 6 

###### Converting SOAPACtions to Transforms
You will need the following pieces of information to migrate a SOAPAction to a SwitchYard transform:
* Smooks Configuration
* transformation from/to types 

The relevant bits of the application descriptor are included for reference:
```xml
   <transform.java bean="MyTransformerBean"
                   from="{urn:switchyard-quickstart-demo:orders:1.0}submitOrder"
                   to="java:org.switchyard.quickstarts.demos.orders.Order"/>
```

Transformation Documentation :

[SwitchYard Transformation Documentation](https://docs.jboss.org/author/display/SWITCHYARD/Transformation SwitchYard Transformation Documentation)


