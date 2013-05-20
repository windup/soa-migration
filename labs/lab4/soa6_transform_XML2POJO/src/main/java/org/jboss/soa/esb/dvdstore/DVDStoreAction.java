
package org.jboss.soa.esb.dvdstore;

import javax.inject.Named;

import org.apache.camel.Message;

@Named("DVDStore")
public class DVDStoreAction {

	public void process(Message message)  {
		Order order = message.getBody(Order.class);
		OrderItem item = new OrderItem();
		item.setProductId("Shawshank Redemption");
		item.setQuantity(Integer.MAX_VALUE);
		item.setPrice(.99);
		order.getItems().add(item);
	}
}
