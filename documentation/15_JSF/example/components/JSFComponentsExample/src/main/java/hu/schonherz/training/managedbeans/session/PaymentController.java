package hu.schonherz.training.managedbeans.session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "paymentController")
@SessionScoped
public class PaymentController {

	public boolean registerCompleted = false;
	public int orderQty = 150;

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public boolean isRegisterCompleted() {
		return registerCompleted;
	}

	public void setRegisterCompleted(boolean registerCompleted) {
		this.registerCompleted = registerCompleted;
	}

}