package bookStoreSpring2AdamSmithLUC.client;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bookStoreSpring2AdamSmithLUC.model.customer.Address;
import bookStoreSpring2AdamSmithLUC.model.customer.Customer;
import bookStoreSpring2AdamSmithLUC.model.order.Order;
import bookStoreSpring2AdamSmithLUC.model.order.OrderDetail;
import bookStoreSpring2AdamSmithLUC.model.product.Book;
import bookStoreSpring2AdamSmithLUC.model.product.Product;
import bookStoreSpring2AdamSmithLUC.model.service.CustomerService;
import jdk.internal.util.xml.impl.Input;
import java.util.Scanner;

import bookStoreSpring2AdamSmithLUC.model.payment.Bank;
import bookStoreSpring2AdamSmithLUC.model.payment.Payment;
import bookStoreSpring2AdamSmithLUC.model.payment.paymentProfile;
import bookStoreSpring2AdamSmithLUC.model.payment.transactionHandler;

public class BookStoreClient {
			
		public static void main (String args[]) throws Exception { 
			
			Scanner keyboard = new Scanner(System.in);

	        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
	        System.out.println("***************** Application Context instantiated! ******************");

	        //Spring to inject the right object implementation in CustomerService for customer using Setter Injection
	        //Also, bootstrapping the CustomerService instantiation using factory
	        CustomerService customerService = (CustomerService) context.getBean("customerService");
	     
	        Customer customer = customerService.getCustomer();
			customer.setFirstName("Michael");
	        customer.setLastName("Gerard");
	        customer.setCustomerId("AY2345");
	        
	        //Spring to inject the right object implementation in Customer object for BillingAddress using Setter Injection
	        Address billingAddress = customer.getBillingAddress();
	        
	        billingAddress.setStreet("500 West Madison St.");
	        billingAddress.setUnit("Suite 1000");
	        billingAddress.setCity("Chicago");
	        billingAddress.setState("IL");
	        billingAddress.setZip("66610");	               
	        
	        /**********************************************************************/
	        //Bootstrapping the Order instantiation using factory
	        Order order1 = (Order) context.getBean("order");
	        
	        order1.setOrderId("XX-66734");

	        //Associate the order with the customer
	        customer.addOrder(order1);
	        
	        //order detail contains products ordered
	        OrderDetail orderDetail1 = (OrderDetail) context.getBean("orderDetail");
	        //First product
	        Book product1 = orderDetail1.getBook(); 
	        product1.setId("BF-7898");
	        product1.setISBN("234-89675-27690");
	        product1.setTitle("Patterns of Enterprise Application Architecture");
	        product1.setAuthor("Folwer, Martin");
	        product1.setPrice(50.99);
	        orderDetail1.setQuantity(1);
	        //Add product to order
	        order1.addProduct(orderDetail1);
	        
	        //Second order detail
	        OrderDetail orderDetail2 = (OrderDetail) context.getBean("orderDetail");
	        //Second product
	        Book product2 = orderDetail2.getBook();
	        product2.setId("BF-2345");
	        product2.setISBN("892-12345-93667");
	        product2.setTitle("Web Application Architecture");
	        product2.setAuthor("Shklar, Leon");
	        product2.setPrice(45.99);
	        orderDetail2.setQuantity(1);
	        //Add product to order
	        order1.addProduct(orderDetail2);
	        
	        //finish order	        
	        order1.confirmOrder();
	        order1.orderPayed();
	        
	        // NOTE: To cancel the request, un-comment the following line.
	        //order.cancel(); Then, comment out the next 2 lines.
	        order1.orderSendOut();
	        order1.orderDelivered();
	        
	        // Print out an order summary
        	System.out.println("\tCustomer Name: \t\t\t" + customer.getFirstName() + " " + customer.getLastName() + "\n");
        	System.out.println("\tBilling Address:\t" + customer.getBillingAddress().getStreet() + 
        		"\n\t\t\t\t" + customer.getBillingAddress().getUnit() + 
        		"\n\t\t\t\t" + customer.getBillingAddress().getCity() + ", " + 
        		customer.getBillingAddress().getState() + " " + customer.getBillingAddress().getZip() +
        		"\n");
	        List<Order> orders = customer.getOrders();
	        for (Order order : orders) {        
	        	// Format order output
	        	System.out.println("\n\t" +"+++++++++++++++++++++++++++++++++");
	        	System.out.println("\tOrder Id: \t\t" + order.getOrderId() + "\n");
	        	System.out.println("\tOrder status: \t\t" + order.getOrderState() + "\n");

	        	System.out.println("\tOrder Items: ");
	        	List<OrderDetail> orderLines = order.getOrderDetails();
	        	for (OrderDetail line : orderLines) {
	        		System.out.println("\t\t\t\t" + line.getBook().getTitle() + "\t" + 
	        			line.getBook().getPrice() + " x " + line.getQuantity());
	        	}
	        	double orderTotal = order.getOrderTotal();
		        System.out.println("\n\tOrder Total:\t\t" + orderTotal);
	        }

			
			Bank bookStore = new Bank();
			
			
			System.out.println("\n");
			System.out.println("Please press 1 to pay with card or 2 to pay with check");
			Integer payMethod = keyboard.nextInt();


		if(payMethod == 1){
			System.out.println("Please enter the name of the card holder"); //, credit card number, expiration date, security code, and billing zip code
			String ccName = "Michael Gerard";
			System.out.println("Michael Gerard");

			System.out.println("Please enter your credit card number");
			String ccNumber = "1234567890";
			System.out.println("1234567890");

			System.out.println("Please enter your expiration date");
			String exp = "09/24";
			System.out.println("09/24");

			System.out.println("Please enter your security code");
			Integer sec = 124;
			System.out.println("124");

			System.out.println("Please enter your billing zip code");
			String zip = "66610";
			System.out.println("66610");
			

			paymentProfile clientCard = new paymentProfile(ccNumber, exp, sec, ccName, zip);

			transactionHandler paymentHandler = new transactionHandler(clientCard, order1, bookStore);

			Payment orderPayment = new Payment(paymentHandler, order1);
			System.out.println("\n");
			System.out.println("Thank you for adding your card " + ccName);
			System.out.println(orderPayment.intializePayment());
			System.out.println("\n");
			
			} else if(payMethod == 2) {

				System.out.println("Please enter the name of the card holder");
				String checkNum = keyboard.nextLine();

				System.out.println("Please enter your name");
				String writer = keyboard.nextLine();

				System.out.println("Please enter your address");
				String checkaddress = keyboard.nextLine();

				System.out.println("Add any notes you would like on the check. If none, please press enter");
				String notes= keyboard.nextLine();

				System.out.println("What is your routing number?");
				String routing = keyboard.nextLine();

				System.out.println("What is your account number?");
				String account = keyboard.nextLine();


				LocalDate today = LocalDate.now();
				String storeName = "Adam's Books";
				String For = "Order Number " + order1.getOrderId();



				paymentProfile clientCheck = new paymentProfile(checkNum, today, writer, checkaddress, storeName, For, notes, routing, account);
				

				transactionHandler paymentHandler = new transactionHandler(clientCheck, order1, bookStore);

				Payment orderPayment2 = new Payment(paymentHandler, order1);
				System.out.println("\n");
				System.out.println(orderPayment2.intializePayment());

				keyboard.close();
		}
	
	}
}
