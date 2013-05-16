package org.switchyard.migration.invm;

import javax.xml.namespace.QName;

import org.switchyard.remote.RemoteInvoker;
import org.switchyard.remote.RemoteMessage;
import org.switchyard.remote.http.HttpInvoker;

public class InVMClient {
	
	private static final QName SERVICE = new QName(
            "urn:org.switchyard.migration:soa6_invm_transport:1.0",
            "Service1");
    private static final String URL = "http://localhost:8080/switchyard-remote";

    /**
     * Only execution point for this application.
     * @param ignored not used.
     * @throws Exception if something goes wrong.
     */
    public static void main(final String[] ignored) throws Exception {
        // Create a new remote client invoker
        RemoteInvoker invoker = new HttpInvoker(URL);

        // Create the request message
        RemoteMessage message = new RemoteMessage();
        message.setService(SERVICE).setContent("InVM in SOA-P 6");

        // Invoke the service
        RemoteMessage reply = invoker.invoke(message);
        if (reply.isFault()) {
            System.err.println("Oops ... something bad happened.  "
                    + reply.getContent());
        } else {
            System.out.println(
            		"============================\n"
            		+ reply.getContent()
            		+ "\n============================");
        }
    }
}
