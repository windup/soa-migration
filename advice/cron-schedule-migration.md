
#### Overview
The cron-schedule element in jboss-esb.xml provides configuration for the Scheduling gateway.  The configuration found in a cron-schedule definition can be converted into a Camel binding in SwitchYard:

#### SOA 5 Configuration

```xml
<schedule-provider name="cronExample">
    <cron-schedule scheduleid="cron-schedule" cronExpression="0/5 * * * * ?"/>
</schedule-provider>
```

#### SOA 6 

###### Converting to Scheduling binding 
You will need the following pieces of information to migrate a camel-bus definition to a Camel binding:
* cron expression
* start time
* end time 

Though the migrated SwitchYard application doesn' make use of a Quartz binding, here is a sample XML definition for reference:
```xml
<quartz:binding.quartz xmlns:quartz="urn:switchyard-component-camel-quartz:config:1.0">
    <quartz:name>EverySecondJob</quartz:name>
    <quartz:cron>* * * * * ?</quartz:cron>
</quartz:binding.quartz>
```

<img src="https://raw.github.com/windup/soa-migration/master/advice/scheduling-wizard.jpg" width="50%" height="50%"/>





