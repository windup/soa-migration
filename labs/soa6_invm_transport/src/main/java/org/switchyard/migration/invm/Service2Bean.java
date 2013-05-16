package org.switchyard.migration.invm;

import org.switchyard.component.bean.Service;

@Service(value = MyService.class, name = "Service2")
public class Service2Bean implements MyService {

	@Override
	public String process(String message) {
		return message + "\nHello from Service 2!";
	}

}
