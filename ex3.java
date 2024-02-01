//A program that simulates a SuperMarket where the user inputs the max distinct products and is able to add new products until it reaches the max, buy certain amounts of each product, list all available products and present the total price of all available items in the Market.

import java.io.IOException;
import java.util.*;

public class ex3 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); 
        System.out.printf("Max distinct products:\n");
        int max = sc.nextInt();
        Supermarket market = new Supermarket(max);
        int choice;
        do{
            System.out.printf("\n1 - Add Products to Supermarket\n2 - Buy Products\n3 - List Available Products\n4 - Products Total Price\n5 - Bye\n");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice){
                case 1 -> {
                    if(market.getList().length<market.getPtr()+1){
                        System.out.printf("Unavailable to add new products.\n");
                        continue;
                    }else{  
                        System.out.printf("Product's Name:\n");
                        String name = sc.nextLine();
                        System.out.printf("Price:\n");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        System.out.printf("Expiration Date:\n");
                        String exp = sc.nextLine();
                        System.out.printf("Stock:\n");
                        int stock = sc.nextInt();
                        sc.nextLine();

                        market.add(name, price, exp, stock); 
                    }
                }
                
                case 2 -> {
                    System.out.printf("Product:\n");
                    String name = sc.nextLine();
                    System.out.printf("Amount:\n");
                    int amount = sc.nextInt();
                    sc.nextLine();
                    
                    market.buy(name,amount); 
                }
                
                case 3 ->{
                    market.show_stock();
                }
                
                case 4->{
                    System.out.printf("Total Price: "+market.show_price()+"€\n");
                }
                
                case 5 ->{
                    return;
                }
            }
        }while(choice!=5); 
    }
}

class Supermarket{
    private Product[] list; 
    private int ptr = 0; 
    
    public Supermarket(int max){
        this.list = new Product[max];
    }

    public int getPtr() {
        return ptr;
    }

    public Product[] getList() {
        return list;
    }
    
    public void add(String name, double price, String exp, int stock){
        this.list[this.ptr] = new Product(name,price,exp,stock);
        System.out.printf("Product Added Successfully!\n"+this.list[this.ptr].toString());
        this.ptr++;
    }

    public void buy(String name, int amount){
        for(int i=0;i<this.ptr;i++){
            if(this.list[i].getName().equals(name)){
                if((this.list[i].getStock()-amount)<0){
                    System.out.printf("Insufficient stock!\n");
                    return;
                }else{
                    System.out.printf("Sold: "+this.list[i].getName()+" - "+amount+" units for the price of "+amount*this.list[i].getPrice()+"€\n");
                    this.list[i].setStock(this.list[i].getStock()-amount);
                    if(this.list[i].getStock()==0){
                        for(int j=i;j<this.ptr;j++){
                            this.list[j] = this.list[j+1];
                        }
                    }
                    return;
                }
            }else{
                System.out.printf("Non-existent product!\n");
                return;
            }
        }
    }
    
    public void show_stock(){
        System.out.printf("AVAILABLE PRODUCTS:\n");
        for(int i=0;i<this.ptr;i++){
            System.out.printf(this.list[i].toString());
        }
    }
    
    public double show_price(){
        double price=0;
        for(int i=0;i<this.ptr;i++){
            price+=this.list[i].getPrice()*this.list[i].getStock();
        }
        return price;
    }
    
}
    
class Product{
    private String name;
    private double price;
    private String expiration;
    private int stock;
        
    public Product(String name, double price, String exp, int stock){
        this.name = name;
        this.price = price;
        this.expiration = exp;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }
    
    public String toString(){
        return "Product: "+this.name+"\nExpiration: "+this.expiration+"\nPrice: "+this.price+"€\nStock: "+this.stock+"\n";
    }
}