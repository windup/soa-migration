package org.switchyard.migration.xml2pojo;

import org.jboss.soa.esb.dvdstore.Order;

public interface OrderService {

	Order process(Order order);
}
