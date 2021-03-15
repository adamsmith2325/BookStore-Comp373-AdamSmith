package bookStoreSpring2AdamSmithLUC.model.payment;


import java.time.LocalDateTime;

import bookStoreSpring2AdamSmithLUC.model.payment.Bank;
import bookStoreSpring2AdamSmithLUC.model.payment.paymentProfile;
import bookStoreSpring2AdamSmithLUC.model.payment.transactionHandler;
import bookStoreSpring2AdamSmithLUC.model.order.Order;



public class Payment {
    
    Integer paymentID; //Would be stored as auto-incrementing in DB, going to leave as 999 for purposes of this exercise
    paymentProfile Payer;
    Bank Payee;
    transactionHandler Transaction = new transactionHandler();
    String orderID;
    Order order;


    public Payment(paymentProfile customer, Bank store, transactionHandler payment, Order order) {

        this.Payer = customer;
        this.Payee = store;
        this.Transaction = payment;
        this.orderID = order.getOrderId();
        this.paymentID = 999; //Again this would be based upon feedback from the database, I would not actually put this line in real code
    }

    public String intializePayment(){
        Transaction.Payee = Payee;
        Transaction.Payer = Payer;
        Transaction.amount = order.getOrderTotal();
        Transaction.transactiontime = LocalDateTime.now();
        Transaction.submitTransaction();

        return "Your transaction for " + order.getOrderTotal() + " has been intialized. Thank you for doing business with us!";
    }

    public String validatePayment(){
        String status = null;

        if(Transaction.getStatus().equals("Completed")){
            status = "Your payment was completed";
        } 

        if(Transaction.getStatus().equals("Error")){
            status = "There was an error with your payment. Please contact support immediately at 888-888-8888";
        } 

        return status;
    }

    public String findPayment(Integer ID) {
        return "Test Find Complete"; //As I said previously, this would be hooked up to a database where I'd use a DAO to query the database to pull this payment record
    }


}
