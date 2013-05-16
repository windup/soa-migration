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

	@Test
	public void testProcess() throws Exception {
		// TODO Auto-generated method stub
		// initialize your test message
		String message = "InVM";
		String result = service.operation("process").sendInOut(message)
				.getContent(String.class);
		System.out.println(result);

		// validate the results
		//Assert.assertTrue("Implement me", false);
	}

}
