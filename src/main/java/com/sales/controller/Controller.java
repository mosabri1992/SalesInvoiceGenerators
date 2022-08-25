/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sales.controller;


import com.sales.model.Invoice;
import com.sales.model.Line;
import com.sales.model.TableModel;
import com.sales.view.Interface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author CompuFast
 */
public class Controller implements ActionListener {
    
    
    private Interface frame;
 
    public Controller(Interface frame)
    {
     this.frame = frame;   
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String actioncommand = e.getActionCommand();
     System.out.println("Action "+ actioncommand);
        switch (actioncommand) {
            case "Load File":
                loadfile();
                break;
                   case "Save File":
                savefile();
                break;
                   case "Create New Invoice":
                CreateNewInvoice();
                break;
                   case "Delete Invoice":
                DeleteInvoice();
                break;
                   case "Save":
                save();
                break;
                   case "Cancel":
                cancel();
                break;
           
        }
 
    }

    private void loadfile() {
        JFileChooser fc= new JFileChooser();
        try  {
      int result =  fc.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION)
        {
        File header_file = fc.getSelectedFile();
         Path headerpath  = Paths.get(header_file.getAbsolutePath());
         List<String> headerlines = Files.readAllLines(headerpath);
            System.out.println("Invoices have been read");
            ArrayList<Invoice> invoicearray = new ArrayList<>();
            for (String headerline : headerlines){
             String[] headerparts =  headerline.split(",");
             int invoiceindex = Integer.parseInt(headerparts[0]);
              String invoicedate = headerparts[2];
              String invoicename = headerparts[1];
                       Invoice invoice = new Invoice(invoiceindex,invoicedate,invoicename);
                       invoicearray.add(invoice);
            }
            System.out.println("Checkpoint");
            result = fc.showOpenDialog(frame);
            if(result == JFileChooser.APPROVE_OPTION)
            {
                File linefile = fc.getSelectedFile();
                Path linepath = Paths.get(linefile.getAbsolutePath());
                List<String> linelines = Files.readAllLines(linepath);
                    System.out.println("lines have been read");
                 for (String lineline : linelines) 
                 {
                     String lineparts[] = lineline.split(",");
                   int invoiceindex = Integer.parseInt(lineparts[0]) ;
                    String itemname = lineparts[1];
                    double itemprice = Double.parseDouble(lineparts[2]);
                    int count = Integer.parseInt(lineparts[3]);
                    Invoice inv = null ;
                    for (Invoice invoice :invoicearray)
                    {
                        if(invoice.getIndex() == invoiceindex){
                            inv = invoice; 
                            break;
                        }
                    }
                    Line line = new Line(invoiceindex,itemname,itemprice,count,inv);
                    inv.getLines().add(line);
                 }
                 System.out.println("Checkpoint");
            }
            
             frame.setInvoice(invoicearray);
             TableModel tablemodel = new TableModel(invoicearray);
             frame.setInvoicetable(tablemodel);
             frame.getInvoicetable().setModel(tablemodel);
             frame.getTablemodel().fireTableDataChanged();
        }
            System.out.println("checkpoint");
       
        } 
        catch(IOException ex){ 
        ex.printStackTrace();
        
        }
    }

    private void savefile() {
    }

    private void CreateNewInvoice() {
    }

    private void DeleteInvoice() {
    }

    private void save() {
    }

    private void cancel() {
    }
    
}
