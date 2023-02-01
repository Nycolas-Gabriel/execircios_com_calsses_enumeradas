package exercicio3_fixação;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> orderItens = new ArrayList<>();

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Order() {
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItens() {
		return orderItens;
	}

	public void addItem(OrderItem item) {
		orderItens.add(item);
	}

	public void removeItem(OrderItem item) {
		orderItens.remove(item);
	}

	public Double total() {
		double sum = 0;
		for (OrderItem i : orderItens) {
			sum += i.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: " + sdf1.format(moment) + "\n");
		sb.append("Order status:" + status + " \n");
		sb.append("Client: " + client.getName() + " (" + sdf.format( client.getBirthDate())+ ") - " + client.getEmail() + " \n");
		sb.append("Order items: \n");

		for (OrderItem i : orderItens) {
			sb.append(i.getProduct().getName() + ", " + i.getPrice() + ", Quantity: " + i.getQuantity() + ", Subtotal: "
					+ i.subTotal() + "\n");
		}
		sb.append("Total price: "+ total());
		return sb.toString();
	}

}
