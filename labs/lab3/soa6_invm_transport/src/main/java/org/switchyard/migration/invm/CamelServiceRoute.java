package org.switchyard.migration.invm;

import org.apache.camel.builder.RouteBuilder;

public class CamelServiceRoute extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from:
	 * endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		from("switchyard://Service1")
			.log("Received message for 'Service1' : ${body}")
			.setBody(simple("${body}\nHello from Service 1!"))
			.log("${body}")
			.to("switchyard://Service2")
			.log("${body}");
	}

}
