
package org.switchyard.migration.wsproxy;

import org.switchyard.component.test.mixins.http.HTTPMixIn;

public class ProxyClient {
	
	private static final String URL = "http://localhost:8080/HelloWorldProxy/HelloWorldWSService";
    private static final String XML = "src/test/resources/request.xml";


    public static void main(String args[]) {
    	
    	HTTPMixIn httpMixIn = new HTTPMixIn();
        httpMixIn.setDumpMessages(true);
        httpMixIn.initialize();
        httpMixIn.postFile(URL, XML);
    }
}

