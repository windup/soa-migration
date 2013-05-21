package org.switchyard.migration.bpm;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class, config = SwitchYardTestCaseConfig.SWITCHYARD_XML, exclude = "jms")
public class OrchestrationServiceTest {

	@ServiceOperation("OrchestrationService")
	private Invoker service;

	@Test
	public void testProcess() throws Exception {
		String message = "Hello ABC!";
		String result = service.operation("process").sendInOut(message)
				.getContent(String.class);

		// validate the results
		Assert.assertEquals("Service 3 Service 2 Service 1 Hello ABC!", result);
	}

}
