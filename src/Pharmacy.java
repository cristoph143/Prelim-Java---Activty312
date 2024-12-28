import static java.lang.Boolean.TRUE;
import java.util.Scanner;


public class Pharmacy {
    public static Medicines[] med;
    public static Scanner scan = new Scanner(System.in);
    public static int stockNum = 0;
    public static String brandname = null, genericname = null;
    public static float price = 0, total = 0;
    public static int quantity;
    public static String medName = null, S;
    public static char choice, news;
    public static int addNum = 0, i = 0, addMon = 0;
    public static char ans;
    public static float grandTotal;
    
    public static void main(String[] args) {
        
        int num;
        
        med = new Medicines[10];
        
        System.out.print("How many medicines you want to be inputted: ");
        num = scan.nextInt();
        
        inputProducts(num);
        
        displayTable(num);
        while(TRUE)
        {
            ans = displayMainMenu();
            switches(ans,num,med);
        }
        
    }
    
    public static void inputProducts(int num)
    {
        
        for(i = 0; i < num; i++)
        {
            System.out.print("Enter Brand Name:");
            brandname = scan.next();
            System.out.print("Enter Generic Name:");
            genericname = scan.next();
            System.out.print("Enter Number of Stocks:");
            quantity = scan.nextInt();
            System.out.print("Enter Enter Price:");
            price = scan.nextFloat();
            
            med[i] = new Medicines(brandname, genericname, quantity, price,total, grandTotal);
        }
    }
    
  
    
    public static void displayTable(int num)
    {
        
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Brand Name\tGeneric Name\tQuantity\tPrice\t\tTotal");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        for(i = 0; i < num; i++)
        {
            System.out.println(med[i].toString());
            
        }
        
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("\t\t\t\t\t\tTotal\t\t"+grandTotal);
    }
    
    public static char displayMainMenu()
    {
        
        
        System.out.print("Menu\n[A] dd quantity\n[C] hange Price\n[S] ell Medicine\n[D] isplay medicine Info\n[Q] uit\n[I] nput Answer: ");
        S = scan.next();
        choice = S.charAt(0);
        news = Character.toUpperCase(choice);

        return news;
    }
    
    public static void switches(char ans, int num, Medicines meds[])
    {
        boolean anser;
        
            switch(ans){
                case 'A':   medName =  answerQues();
                            anser = checkMed(num, medName, meds);
                            addStocks(num,medName,meds);
                            answer(anser,num);
                            break;
                case 'S':   medName =  answerQues();
                            anser = checkMed(num, medName, meds);
                            sellMed(num, meds);
                            answer(anser,num);
                            break;
                case 'C':   medName =  answerQues();
                            anser = checkMed(num, medName, meds);
                            changePrice(num,meds);
                            answer(anser,num);
                            break;
                case 'D':   displayTable(num);
                            break;
                case 'Q':   System.out.println("Thank You for using This App!");
                            System.exit(0);
                            break;
            }   
    }
    
    public static String answerQues(){
        System.out.print("Enter Brand Name of the Medicine to be Modified: ");
        medName = scan.next();
        return medName;
    }
    
    public static void answer(boolean answer, int num){
        
        if(answer != true)
        {
            System.out.println("Medicine not found!\n");
            displayTable(num);
            ans = displayMainMenu();
        }
    }
    
    
    public static boolean checkMed(int num, String medName, Medicines meds[])
    {
       for(int i = 0; i < num;i++) {
           if(meds[i].getBrandName().equalsIgnoreCase(medName)) 
           {
                return true;
           }
       }
       return false;
    }
    
    public static void addStocks(int num, String medName, Medicines meds[])
    {
        
        System.out.print("Decrease or Increase? ");
        S = scan.next();
        System.out.print("Enter Number of Medicine to be Modified: ");
        addNum = scan.nextInt();
        if (S.equalsIgnoreCase("increase")) 
        {
            med[i].addStock(addNum);
            total = med[i].setTotal(med[i].getPrice()*med[i].getQuantity());
            
            displayTable(num);
        }
        else
        {
            if(med[i].getQuantity() < addNum)
            {
                System.out.println("Low Stock! Please try again!1");
                displayTable(num);
                ans = displayMainMenu();
                switches(ans,num,meds);
            }
            else
            {
                med[i].setQuantity(med[i].getQuantity()-addNum);
                displayTable(num);
            }
        }
        solve();
    }
    
    
    public static void sellMed(int num, Medicines meds[])
    {
        System.out.print("Enter Number of Medicine to be Modified: ");
        addNum = scan.nextInt();
        System.out.print("Enter your Money: ");
        addMon = scan.nextInt();
        
        if(addMon < med[i].getPrice())
        {
            System.out.print("Low Money! Please try again!1");
        }
        else if(med[i].getQuantity() < addNum)
        {
            System.out.print("Low Stock! Please try again!1");
        }
        else
        {
            med[i].setQuantity(med[i].getQuantity()-addNum);  
            med[i].setTotal(med[i].getTotal(price,quantity)-addMon); 
        }
        solve();
        displayTable(num);
        ans = displayMainMenu();
        switches(ans,num,meds);
    }
    
    public static void changePrice(int num, Medicines[] meds)
    {
        System.out.print("Enter Number of Money to be Modified: ");
        addMon = scan.nextInt();
        displayTable(num);
           
    }
    
    public static void solve(){
        
        med[i].setTotal(med[i].getTotal(price,quantity));
        med[i].setGrandTotal(med[i].getTotal(price,quantity));
    }
}