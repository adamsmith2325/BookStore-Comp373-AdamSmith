package bookStoreSpring2AdamSmithLUC.model.payment;


import java.time.LocalDateTime;

import bookStoreSpring2AdamSmithLUC.model.payment.Bank;
import bookStoreSpring2AdamSmithLUC.model.payment.paymentProfile;
import bookStoreSpring2AdamSmithLUC.model.payment.transactionHandler;
import bookStoreSpring2AdamSmithLUC.model.order.Order;



public class Payment {
    
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

    }

    public String intializePayment(){
        Transaction.Payee = Payee;
        Transaction.Payer = Payer;
        Transaction.amount = order.getOrderTotal();
        Transaction.transactiontime = LocalDateTime.now();

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

    public String findPayment() {
        
    }


}
