package org.jboss.soa.esb.dvdstore;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

	private static final long serialVersionUID = -8386518137989129692L;

	private Customer customer;
	private OrderHeader header;
	private List<OrderItem> items;

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public OrderHeader getHeader() {
		return header;
	}
	public void setHeader(OrderHeader header) {
		this.header = header;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("header   => " + header);
		sb.append("\ncustomer => " + customer);
		if (items != null) {
			for (OrderItem item : items) {
				sb.append("\nlineitem => " + item);
			}
		}
		return sb.toString();
	}
	
}
