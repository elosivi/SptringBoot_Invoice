package com.mycompany.invoise.controller.scan;


import com.mycompany.invoise.App;
import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;
//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {
    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void createInvoice() {
        System.out.println( "use of a shower scan code" );
        String customerName = "Customer from shower";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        invoiceService.createInvoice(invoice);

        //AddOne();
    }

//    public void AddOne(){
//        System.out.println(" Add one more invoice? Y/N");
//        Scanner sc = new Scanner(System.in);
//        String response = sc.nextLine();
//
//        if(response.equalsIgnoreCase("y")){
//            App.choiceInvoiceConfiguration();
//        }else if( response.equalsIgnoreCase("n")) {
//            System.out.println("Ok thank!");
//        }else{
//            System.out.println("wrong choice, please try again");
//            AddOne();
//        }
//    }
}
