package bookStoreSpring2AdamSmithLUC.model.payment;

import java.time.LocalDateTime;

public class transactionHandler {
    
    //This is my fake payment gateway API class

    //Attributes
    Integer paymentID;
    paymentProfile Payer;
    Bank Payee;
    Double amount;
    LocalDateTime transactiontime;

    
    
    public String getStatus(){
        //This is where I'd contact the bank system to determine whether the payment was successful. We will assume all payments are successful here
        return "Completed";
    }

    public String submitTransaction(){
        
        //I would have an API call here where payment profile details, amount, etc where within the body of the API call, actually submitting the bayment to the bank

        return "Submitted";
    }
}
