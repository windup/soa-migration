package org.switchyard.migration.gatewaysrouters;
import javax.inject.Named;

import org.apache.camel.Message;

@Named("MyAction")
public class MyAction {
	
	public void displayMessage(Message message) {
		logHeader();
		System.out.println("Body: " + message.getBody(String.class).trim());
		logFooter();
	}
	
	public void playWithMessage(Message message) {
		String content = message.getBody(String.class);
		message.setBody("[CHANGED]" + content.trim());
	}
	
	private void logHeader() {
		System.out.println("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	}
	
	private void logFooter() {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
	}
}
