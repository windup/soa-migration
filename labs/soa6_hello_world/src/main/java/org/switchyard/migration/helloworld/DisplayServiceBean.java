package org.switchyard.migration.helloworld;

import org.switchyard.component.bean.Service;

@Service(DisplayService.class)
public class DisplayServiceBean implements DisplayService {

	@Override
	public void display(String message) {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");		  		  
		System.out.println("Body: " + message) ;
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	}
	
}
