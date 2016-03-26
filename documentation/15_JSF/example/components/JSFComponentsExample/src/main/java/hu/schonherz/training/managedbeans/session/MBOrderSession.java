package hu.schonherz.training.managedbeans.session;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import hu.schonherz.training.records.Order;

@ManagedBean(name = "order")
@SessionScoped
public class MBOrderSession implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Order newOrder = new Order();

	private final List<Order> orderList = new ArrayList<Order>();

	@PostConstruct
	public void init() {
		orderList.add(new Order("A0001", "Intel CPU", new BigDecimal("700.00"), 1));
		orderList.add(new Order("A0002", "Harddisk 10TB", new BigDecimal("500.00"), 2));
		orderList.add(new Order("A0003", "Dell Laptop", new BigDecimal("11600.00"), 8));
		orderList.add(new Order("A0004", "Samsung LCD", new BigDecimal("5200.00"), 3));
		orderList.add(new Order("A0005", "A4Tech Mouse", new BigDecimal("100.00"), 10));

	}

	public List<Order> getOrderList() {

		return orderList;

	}

	public Order getNewOrder() {
		return newOrder;
	}

	public void setNewOrder(Order newOrder) {
		this.newOrder = newOrder;
	}
}