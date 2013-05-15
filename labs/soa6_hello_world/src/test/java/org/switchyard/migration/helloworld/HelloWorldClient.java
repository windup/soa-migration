package org.switchyard.migration.helloworld;

import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.switchyard.component.test.mixins.hornetq.HornetQMixIn;

public class HelloWorldClient {

    
    private static final String QUEUE = "quickstart_helloworld_Request_gw";
    private static final String USER = "guest";
    private static final String PASSWD = "guest12.";
    
    public static void main(final String[] args) throws Exception {
        HornetQMixIn hqMixIn = new HornetQMixIn(false)
                                    .setUser(USER)
                                    .setPassword(PASSWD);
        
        hqMixIn.initialize();

        try {
            final Session session = hqMixIn.createJMSSession();
            final MessageProducer producer = session.createProducer(HornetQMixIn.getJMSQueue(QUEUE));
            final TextMessage message = session.createTextMessage();
            
            if (args.length > 0) {
            	message.setText(args[0]);
            } else {
            	message.setText("Hello SwitchYard!");
            }
            producer.send(message);
        
            System.out.println("Sent message [" + message + "]");
            Thread.sleep(500);
        } finally {
            hqMixIn.uninitialize();
        }
    }

}
