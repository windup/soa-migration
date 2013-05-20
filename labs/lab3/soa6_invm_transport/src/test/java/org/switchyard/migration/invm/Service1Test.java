package org.switchyard.migration.invm;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class, config = SwitchYardTestCaseConfig.SWITCHYARD_XML)
public class Service1Test {

	@ServiceOperation("Service1")
	private Invoker service;

	private static final String REQUEST = "InVM";
	private static final String EXPECTED = REQUEST 
			+ "\nHello from Service 1!" 
			+ "\nHello from Service 2!";

	@Test
	public void testProcess() throws Exception {
		// TODO Auto-generated method stub
		// initialize your test message
		String result = service.operation("process").sendInOut(REQUEST)
				.getContent(String.class);

		// validate the results
		Assert.assertEquals(EXPECTED, result);
	}

}
