package org.switchyard.migration.xml2pojo;

import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.switchyard.component.test.mixins.hornetq.HornetQMixIn;
import org.switchyard.test.SwitchYardTestKit;

public class TransformClient {
	
    private static final String REQUEST_QUEUE = "quickstart_transform_pojo_gw";
    private static final String REPLY_QUEUE = "quickstart_simple_transformation_Response";
    private static final String USER = "guest";
    private static final String PASSWD = "guest12.";
    
    public static void main(final String[] args) throws Exception {
    	SwitchYardTestKit testKit = new SwitchYardTestKit(new Object());
        HornetQMixIn hqMixIn = new HornetQMixIn(false)
                                    .setUser(USER)
                                    .setPassword(PASSWD);
        
        hqMixIn.initialize();

        try {
            Session session = hqMixIn.createJMSSession();
            MessageProducer producer = session.createProducer(HornetQMixIn.getJMSQueue(REQUEST_QUEUE));
            MessageConsumer consumer = session.createConsumer(HornetQMixIn.getJMSQueue(REPLY_QUEUE));
            TextMessage requestMsg = session.createTextMessage();
            
            // Send request message
            String requestTxt = testKit.readResourceString("SampleOrder.xml");
            requestMsg.setText(requestTxt);
            producer.send(requestMsg);
            System.out.println("************************ Request Message ****************************"
            		+ "\n" + requestTxt
            		+ "********************************************************************");
            
            // Wait for reply
            System.out.println("\n[... waiting for reply ....]\n");
            TextMessage replyMsg = (TextMessage)consumer.receive(3000);
            if (replyMsg == null) {
            	System.out.println("No reply received!");
            } else {
            	System.out.println("************************ Response Message ****************************"
                		+ "\n" + replyMsg.getText()
                		+ "\n********************************************************************");
            }
            
        
        } finally {
            hqMixIn.uninitialize();
        }
    }

}
