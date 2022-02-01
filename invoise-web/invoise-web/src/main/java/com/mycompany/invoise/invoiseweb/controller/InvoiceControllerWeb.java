package com.mycompany.invoise.invoiseweb.controller;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb implements InvoiceControllerInterface {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void createInvoice(){
        String customerName = "Customer from web";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        invoiceService.createInvoice(invoice);
    }

    @RequestMapping("/home")
    public String displayHome(Model model){
        System.out.println("La méthode displayHome a été invoquée");
        model.addAttribute("invoices", invoiceService.getInvoiceList());
        return "invoice-home";
    }

    @RequestMapping("/{id}")
    public String displayInvoice(@PathVariable("id")String number, Model model){ // nb: Model model always must be the last one param, at the end
        System.out.println("La méthode displayInvoice a été invoquée");
        model.addAttribute("invoice", invoiceService.getInvoiceByNumber(number));
        return "invoice-details";
    }
}
