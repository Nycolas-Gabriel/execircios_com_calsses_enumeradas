package exercicio3_fixação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String clientBirth = sc.nextLine();
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String orderStatus = sc.nextLine();

		Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus),
				new Client(clientName, clientEmail, sdf.parse(clientBirth)));
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i=1; i <= n; i ++) {
			
			System.out.println("Enter #"+i+" item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
			OrderItem item = new OrderItem(quantity, productPrice, new Product(productName, productPrice));
			order.addItem(item);		
		}
System.out.println(order);
		sc.close();
	}

}
