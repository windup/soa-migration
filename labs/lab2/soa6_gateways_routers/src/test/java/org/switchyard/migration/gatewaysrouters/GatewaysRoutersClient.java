package org.switchyard.migration.gatewaysrouters;

import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.switchyard.component.test.mixins.hornetq.HornetQMixIn;


public class GatewaysRoutersClient {
	private static final String QUEUE = "quickstart_jms_router_Request_gw";
    private static final String USER = "guest";
    private static final String PASSWD = "guest12.";
    
    
    /**
     * Only execution point for this application.
     * @param ignored not used.
     * @throws Exception if something goes wrong.
     */
    public static void main(final String[] args) throws Exception {
        HornetQMixIn hqMixIn = new HornetQMixIn(false)
                                    .setUser(USER)
                                    .setPassword(PASSWD);
        
        hqMixIn.initialize();

        try {
            final Session session = hqMixIn.createJMSSession();
            final MessageConsumer consumer = session.createConsumer(HornetQMixIn.getJMSQueue(QUEUE));
            TextMessage msg = (TextMessage)consumer.receive(3000);
            
            if (msg == null) {
            	System.out.println("\nNo messages found in queue: " + QUEUE + "\n");
            } else {
	            System.out.println("Received message:" 
	            + "\n===========================\n"
	            + msg.getText()
	            + "\n===========================\n");
            }
        } finally {
            hqMixIn.uninitialize();
        }
    }
}
