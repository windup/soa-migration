####Overview
The action processing pipeline was the only container available for defining composition logic for ESB services in SOA 5.  In SOA 6, any implementation type (CDI Bean, BPEL, Camel Route, BPM, Rules, etc.) can be used to define a service.  The choice of which implementation type to use in SOA 6 boils down to the following:
* If your action processing pipeline contained procedural and/or routing logic for composition of services, then a Camel route will provide the most direct equivalent in SOA 6.
* If your action processing pipeline simply "handed off" the processing logic to a specific implementation type, then consider exposing that implementation directly as a service in SOA 6.

For example, if you have a SOA 5 action processing pipeline has a single action class which contains all of the service logic, then that makes a great candidate for migrating the action class to a CDI Bean Service.  On the other hand, if you have a pipeline with complex routing and multiple action classes, then a Camel route will be a better fit.

#### SOA 5 Action Processing Pipeline
An example of a very basic action processing pipeline:
```xml
<actions mep="OneWay">
  <action name="action1" class="org.example.MyAction" process="doSomething"/>
</actions>
```

#### SOA 6 Camel Route
Converting action processing pipelines to Camel routes is a matter of:

1. Establishing a contract for the routing service.
2. Converting custom action classes to CDI Beans and invoking those directly from the Camel route.
3. Migrating built-in action classes (e.g. router/notifier) to equivalent SOA 6 functionality.

```xml
<route xmlns="http://camel.apache.org/schema/spring">
  <from uri="switchyard://MyService"/>
  <bean ref="action1" method="doSomething"/>
</route>
```
The above route definition relies on the presence of a CDI Bean deployed with the application with the following definition:

```java
@Named("action1")
public class MyAction {
   void doSomething(Message message);
}
```

Information on converting action classes in a pipeline to CDI Beans can be found in the [Action Class](https://github.com/windup/soa-migration/blob/master/advice/action-class-migration.md) microsite.

#### SOA 6 Bean Service
Converting an action class to a CDI Bean service is covered in the [Action Class](https://github.com/windup/soa-migration/blob/master/advice/action-class-migration.md) microsite.
