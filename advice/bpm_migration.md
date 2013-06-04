
#### Overview
The BpmProcessor action makes calls to jBPM 3 through the jBPM command API.    jBPM 3 support is not supported within SwitchYard, but jBPM 5 is and you can migrate existing projects from jBPM3 to jBPM5.     Resources to help you migrate are provided below.

The Bpm5Processor action, which was added in SOA-P 5.3.0, provides jBPM 5 support within JBoss ESB.     Converting your Bpm5Processor action to SwitchYard should be straightforward.

SwitchYard allows you to expose a jBPM 5 business process as a service.     

#### SOA-P 5 Configuration

```xml
<action name="create_new_process_instance"
    class="org.jboss.soa.esb.services.jbpm.actions.BpmProcessor">
    <property name="command" value="StartProcessInstanceCommand" />
    <property name="process-definition-name" value="processDefinition2"/>
    <property name="actor" value="FrankSinatra"/>
    <property name="esbToBpmVars">
        <!-- esb-name maps to getBody().get("eVar1") -->
        <mapping esb="eVar1" bpm="counter" value="45" />
        <mapping esb="BODY_CONTENT" bpm="theBody" />
    </property>
</action>
```

#### SOA-P 6 

###### Converting BpmProcessor to a BPM Service
You will need the following pieces of information to migrate a BpmProcessor to a BPM service in SwitchYard:

* BPMN resource name
* action (ex: START_PROCESS)

The relevant bits of the application descriptor are included for reference:
```xml
<bpm:implementation.bpm persistent="false" processId="OrchestrationService">
    <bpm:actions>
        <bpm:action type="START_PROCESS">
            <bpm:inputs>
                <bpm:mapping expression="message.content" expressionType="MVEL" variable="contentInput"/>
            </bpm:inputs>
            <bpm:outputs>
                <bpm:mapping expression="contentOutput" expressionType="MVEL" variable="contentOutput"/>
            </bpm:outputs>
        </bpm:action>
    </bpm:actions>
    <bpm:manifest>
        <bpm:resources>
            <bpm:resource location="ProcessDefinition.bpmn" type="BPMN2"/>
        </bpm:resources>
    </bpm:manifest>
</bpm:implementation.bpm>
```

#### jBPM3 to jBPM5 Migration

The jBPM team offers a jPDL to BPMN2 migration tool that assists users in moving their jBPM3 projects to jBPM5.    The tool is a command line Java program that 

[jBPM 5 Migration Wiki](https://docs.jboss.org/author/display/SWITCHYARD/Transformation jBPM 5 Migration Wiki)

[jBPM 5 Migration Project](https://docs.jboss.org/author/display/SWITCHYARD/Transformation jBPM 5 Migration Project)

[Article on jBPM3 to jBPM5 migration, Part 1](http://www.schabell.org/2011/06/jbpm-migrations-hints-and-tips-part-1.html Article on jBPM3 to jBPM5 migration, Part 1)

[Article on jBPM3 to jBPM5 migration, Part 2](http://www.schabell.org/2011/06/jbpm-migrations-hints-and-tips-for.html Article on jBPM3 to jBPM5 migration, Part 2)

###### Callbacks
SOA-P 5 uses a built-in callback service which allows ESB to safely signal jBPM processes - ESB can check the state of the process, and then signal the process.     

This functionality is planned for SwitchYard (see link below) but you would have to administer the check with your own custom service with checked the process state.

[Need a jbpm5 callback mechanism for safe event signaling](https://issues.jboss.org/browse/SWITCHYARD-959 Need a jbpm5 callback mechanism for safe event signaling)



