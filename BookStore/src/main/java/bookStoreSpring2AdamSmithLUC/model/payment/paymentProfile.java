package bookStoreSpring2AdamSmithLUC.model.payment;

import java.util.Date;

enum paymentType {CARD, CHECK}



/*
Overarching comments, I have made 3 major assumptions:
    1. This store only sells books, they do not pay people for their used books
    2. The only sell direct inventory, no drop-selling
    3. I have provided API documentation from a payment gateway such as Melio or Stripe to physically process the payment
*/








public class paymentProfile {
    
    
    //General Attributes
    paymentType paymentMethod;

    //Credit Card Atrributes
    String ccNumber;
    String expDate;
    Integer secCode;
    String cardHolderName;
    String billingZip;

    //Check Atrributes
    String checkNumber;
    Date checkDate;
    String checkIssuer;
    String issuerAddress;
    String CheckPayee;
    String checkFor;
    String Notes;
    String payerRouting;
    String payerAccountNum;

  

    public paymentProfile(String num, String exp, Integer sec, String name, String zip) {

        this.paymentMethod = paymentType.CARD;
        this.ccNumber = num;
        this.expDate = exp;
        this.secCode = sec;
        this.cardHolderName = name;
        this.billingZip = zip;


    }

    public paymentProfile(String num, Date date, String issuer, String addy, String payee, String For, String notes, String routing, String account) {

        this.paymentMethod = paymentType.CHECK;
        this.checkNumber = num;
        this.checkDate = date;
        this.checkIssuer = issuer;
        this.issuerAddress = addy;
        this.CheckPayee = payee;
        this.checkFor = For;
        this.Notes = notes;
        this.payerRouting = routing;
        this.payerAccountNum = account;


    }



}
