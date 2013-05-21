package org.switchyard.migration.bpm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class, config = SwitchYardTestCaseConfig.SWITCHYARD_XML, exclude = "jms")
public class Service2Test {

	@ServiceOperation("Service2")
	private Invoker service;

	@Test
	public void testDisplay() throws Exception {
		String message = "Hello SwitchYard!";
		service.sendInOnly(message);
	}

}
