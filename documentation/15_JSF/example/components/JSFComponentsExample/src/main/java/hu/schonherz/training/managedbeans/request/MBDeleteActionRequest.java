package hu.schonherz.training.managedbeans.request;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import hu.schonherz.training.managedbeans.session.MBOrderSession;
import hu.schonherz.training.records.Order;

@ManagedBean(name = "deleteActionRequest")
@RequestScoped
public class MBDeleteActionRequest {

	@ManagedProperty(value = "#{order}")
	private MBOrderSession orderSession;

	public String action(Order order) {
		orderSession.getOrderList().remove(order);
		return null;
	}

	public MBOrderSession getOrderSession() {
		return orderSession;
	}

	public void setOrderSession(MBOrderSession orderSession) {
		this.orderSession = orderSession;
	}

}
