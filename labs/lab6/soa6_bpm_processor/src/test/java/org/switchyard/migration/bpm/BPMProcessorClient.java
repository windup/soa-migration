package org.switchyard.migration.bpm;

import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.switchyard.component.test.mixins.hornetq.HornetQMixIn;

public class BPMProcessorClient {


    private static final String REQUEST_QUEUE = "quickstart_bpm_orchestration2_start_Request_gw";
    private static final String REPLY_QUEUE = "quickstart_bpm_orchestration2_start_Reply_gw";
    private static final String USER = "guest";
    private static final String PASSWD = "guest12.";
    
    public static void main(final String[] args) throws Exception {
        HornetQMixIn hqMixIn = new HornetQMixIn(false).setUser(USER).setPassword(PASSWD);
        
        hqMixIn.initialize();

        try {
        	Session session = hqMixIn.createJMSSession();
            MessageProducer producer = session.createProducer(HornetQMixIn.getJMSQueue(REQUEST_QUEUE));
            MessageConsumer consumer = session.createConsumer(HornetQMixIn.getJMSQueue(REPLY_QUEUE));
            TextMessage requestMsg = session.createTextMessage();
            
            // Send request message
            String requestTxt = "Start It Up";
            requestMsg.setText(requestTxt);
            producer.send(requestMsg);
            System.out.println(
            		"************************ Request Message ****************************"
            		+ "\n" + requestTxt
            		+ "\n" +
            		"********************************************************************");
            
            // Wait for reply
            System.out.println("\n[... waiting for reply ....]\n");
            TextMessage replyMsg = (TextMessage)consumer.receive(3000);
            if (replyMsg == null) {
            	System.out.println("No reply received!");
            } else {
            	System.out.println(
            			"************************ Response Message ****************************"
                		+ "\n" + replyMsg.getText()
                		+ "\n********************************************************************");
            }
        } finally {
            hqMixIn.uninitialize();
        }
    }

}
