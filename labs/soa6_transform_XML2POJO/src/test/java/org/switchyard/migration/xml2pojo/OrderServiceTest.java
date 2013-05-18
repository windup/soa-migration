package org.switchyard.migration.xml2pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.jboss.soa.esb.dvdstore.Customer;
import org.jboss.soa.esb.dvdstore.Order;
import org.jboss.soa.esb.dvdstore.OrderHeader;
import org.jboss.soa.esb.dvdstore.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class, config = SwitchYardTestCaseConfig.SWITCHYARD_XML, exclude="jms")
public class OrderServiceTest {

	@ServiceOperation("OrderService")
	private Invoker service;
	
	private SwitchYardTestKit testKit;

	@Test
	public void testProcessJava() throws Exception {
		Order message = createOrder();
		service.operation("process").sendInOnly(message);
	}
	
	@Test
	public void testProcessXML() throws Exception {
		service.operation("process")
            .inputType(QName.valueOf("{urn:org.switchyard.migration:soa6_transform_XML2POJO:1.0}order"))
            .sendInOut(testKit.readResourceDocument("SampleOrder.xml"));
	}

	private Order createOrder() {
		Order order = new Order();
		OrderHeader header = new OrderHeader();
		header.setNetAmount(52);
		header.setStatusCode(1);
		header.setOrderId("order-123");
		Customer customer = new Customer();
		customer.setFirstName("george");
		customer.setLastName("curious");
		OrderItem item1 = new OrderItem();
		item1.setProductId("bananas");
		item1.setPrice(1.00);
		order.setHeader(header);
		order.setCustomer(customer);
		List<OrderItem> items = new ArrayList<OrderItem>();
		items.add(item1);
		order.setItems(items);
		return order;
	}
}

