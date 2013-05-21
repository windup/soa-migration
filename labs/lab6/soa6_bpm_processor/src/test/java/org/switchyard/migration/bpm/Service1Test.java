package org.switchyard.migration.bpm;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class, config = SwitchYardTestCaseConfig.SWITCHYARD_XML, exclude = "jms")
public class Service1Test {

	@ServiceOperation("Service1")
	private Invoker service;

	@Test
	public void testDisplay() throws Exception {
		String message = "Hello SwitchYard!";
		String result = service.sendInOut(message).getContent(String.class);
		
		Assert.assertEquals("Service 1 " + message, result);
	}

}
