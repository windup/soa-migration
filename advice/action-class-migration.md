####Overview
Action classes in SOA 5 should be migrated to CDI Beans in SOA 6.  The CDI bean can be invoked in one of two ways in SOA 6:

1. **Convert the action class to a CDI Bean Service.**  This allows the action class to be exposed directly and/or invoked from other services within the application through references.
2. **Convert the class to a CDI Bean and invoke it directly from a Camel route.**  This closely resembles how action classes were invoked from an action processing pipeline in SOA 5.

Generally speaking, you should use a CDI Bean Service if the logic in an action class will be exposed directly to service consumers.  If multiple action classes are used to provide a service, then consider composing them as CDI beans in a Camel route.  In either case, use of JBossESB APIs in your action class logic will need to be changed.

####SOA 5 Action Class
Here's an example of a SOA 5 Action class:
```java
public class MyAction extends AbstractActionLifecycle
{   
    protected ConfigTree  _config;
    
    public MyJMSListenerAction(ConfigTree config) { _config = config; } 
    
    public Message displayMessage(Message message) {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");		  		  
        System.out.println("Body: " + message.getBody().get()) ;
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        return message;  		
    }
}
```

####Converting to a CDI Bean Service
When converting an action class to a CDI Bean Service there are a couple things to keep in mind:
* Every service requires a contract, so you will need to define a Java interface that represents the contract for your bean service.
* While there are hooks to access the org.switchyard.Message object within your bean service implementation, you should try to avoid binding your application logic to runtime APIs if possible.  This means that bean service logic should attempt to operate on the types declared in the service contract as a best practice.

An example of converting the action class above to a CDI Bean Service:
```java
@Service(MyService.class)
public class MyServiceBean implements MyService
{   
    public MyServiceBean() {  } 
    
    public void displayMessage(String message) {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");  	  		  
        System.out.println("Body: " + message) ;
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }
}
```

####Converting to CDI Bean used in a Camel Route
Converting an action class to a plain CDI Bean can be done by adding an @Named annotation to the class.  This specifies the name you will use in your Camel route to invoke the bean.

An example of converting the action class above to a CDI bean.  Note the Message object used here is an instance of org.apache.camel.Message.
```java
import org.apache.camel.Message;

@Named("MyAction")
public class MyAction {

    public void displayMessage(Message message) {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");        		  
        System.out.println("Body: " + message.getBody(String.class)) ;
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }
}
```
