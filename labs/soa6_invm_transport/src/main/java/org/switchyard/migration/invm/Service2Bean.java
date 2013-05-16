package org.switchyard.migration.invm;

import org.switchyard.component.bean.Service;

@Service(value = MyService.class, name = "Service2")
public class Service2Bean implements MyService {

	@Override
	public String process(String message) {
		// TODO Auto-generated method stub
		return null;
	}

}
