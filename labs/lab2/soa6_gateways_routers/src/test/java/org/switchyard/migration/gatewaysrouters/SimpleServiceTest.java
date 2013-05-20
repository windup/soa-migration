package org.switchyard.migration.gatewaysrouters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class, config = SwitchYardTestCaseConfig.SWITCHYARD_XML, exclude={"ftp", "uri"})
public class SimpleServiceTest {

	@ServiceOperation("SimpleService")
	private Invoker service;
	
	private SwitchYardTestKit testKit;

	@Test
	public void testProcess() throws Exception {
		
		testKit.replaceService("PrintService");
		
		String message = "testing";
		service.operation("process").sendInOnly(message);
	}

}
