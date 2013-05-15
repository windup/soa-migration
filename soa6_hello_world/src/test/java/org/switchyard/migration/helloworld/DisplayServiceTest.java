package org.switchyard.migration.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class, config = SwitchYardTestCaseConfig.SWITCHYARD_XML, exclude = "jca")
public class DisplayServiceTest {

	@ServiceOperation("DisplayService")
	private Invoker service;

	@Test
	public void testDisplay() throws Exception {
		String message = "Hello SwitchYard!";
		service.operation("display").sendInOut(message).getContent(String.class);
	}

}
