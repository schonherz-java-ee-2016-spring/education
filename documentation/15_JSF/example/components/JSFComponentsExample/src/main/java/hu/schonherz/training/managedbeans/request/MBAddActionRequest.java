package hu.schonherz.training.managedbeans.request;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import hu.schonherz.training.managedbeans.session.MBOrderSession;
import hu.schonherz.training.records.Order;

@ManagedBean(name = "addActionRequest")
@RequestScoped
public class MBAddActionRequest {

	@ManagedProperty(value = "#{order}")
	private MBOrderSession orderSession;

	public String action() {
		Order order = new Order();
		order.setOrderNo(orderSession.getNewOrder().getOrderNo());
		order.setProductName(orderSession.getNewOrder().getProductName());
		order.setPrice(orderSession.getNewOrder().getPrice());
		order.setQty(orderSession.getNewOrder().getQty());
		orderSession.getOrderList().add(order);
		return null;
	}

	public MBOrderSession getOrderSession() {
		return orderSession;
	}

	public void setOrderSession(MBOrderSession orderSession) {
		this.orderSession = orderSession;
	}

}
