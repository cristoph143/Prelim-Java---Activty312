/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joopb16
 */
public class Medicines {
    private String brandName;
    private String genericName;
    private int quantity;
    private float price;
    private float total;
    private float grandTotal;

   
    public Medicines(String brandName, String genericName, int quantity, float price, float total, float grandTotal) {
        this.brandName = brandName;
        this.genericName = genericName;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.grandTotal = grandTotal;
    }
    
    public String getBrandName() {
        return brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }
    public float getTotal(float price, int quantity) {
        
        return price*quantity;
    }

    public float getGrandTotal(){
        return total+total;
    }
    public void setGrandTotal(float total)
    {
        this.grandTotal = total;
    }
    
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    public float setTotal(float total) {
        this.total = total;
        return total;
    }
    
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public void total(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return brandName+ "\t\t" + genericName+ "\t\t" + quantity + "\t\t" + price + "\t\t" + total  ;
    }

    void addStock(int addNum) {
        quantity+=addNum;
    }
}