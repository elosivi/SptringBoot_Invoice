package com.mycompany.invoise.controller;

import com.mycompany.invoise.App;
import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceService;
import com.mycompany.invoise.service.InvoiceServiceMichel;

import java.util.Scanner;

public class InvoiceControllerMichel {

    public static void addInvoiceUsingWeb(){
        System.out.println( "What is the customer name?" );
        String customerName = "Customer from web";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        InvoiceServiceMichel invoiceServiceMichel = new InvoiceServiceMichel();
        invoiceServiceMichel.createInvoice(invoice);

        AddOne();
    }

    public static void AddOne(){
        System.out.println(" Add one more invoice? Y/N");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();

        if(response.equalsIgnoreCase("y")){
            App.choiceInvoiceConfiguration();
        }else if( response.equalsIgnoreCase("n")) {
            System.out.println("Ok thank!");
        }else{
            System.out.println("wrong choice, please try again");
            AddOne();
        }
    }
}
