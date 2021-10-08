//Superclass stocks declared
public class Stocks{
    
    //Instance variables declared
    private double PreviousBuy;
    private String name;
    private double buyPrice;
    private String volatility;
    private String growthPattern;
    private int quantity;
    private boolean owned;
    
    //Constructor takes name and string 
    public Stocks(String name, String pattern){
    
        //Instance variables set
        this.name = name;
        buyPrice = 0;
        volatility = "";
        growthPattern = pattern;
        owned = false;
    
    
    }
    
    //Method sets initial price doubles
    public void setInitial(){
        double initial = (double) (Math.random() * (100 - 15)) + 15;
        PreviousBuy = initial; 
        buyPrice = initial;
    }
    
    //Method sets volatility to pattern
    public void setVolatility(){
           this.volatility = growthPattern;
    }
    
    //Method returned owned variable
    public boolean getOwned(){
        return this.owned;
    }
    
    //Method sets owned to parameter inpute
    
    public void setOwned(boolean check){      
       this.owned = check;
    }
    
    //Method returns name variable
    public String getName(){
        return name;
    }
    
    //Method returns buy price
    public double getBuyPrice(){      
        //Sets to 2dp
        this.buyPrice = Math.round(buyPrice * 100.0) / 100.0;
        return this.buyPrice;
    }
    
    //Method returns the previous buy price
    public double getPreviousBuyPrice(){
        return this.PreviousBuy;
    }
    
    //Method sets prvious buy price
     public void setPreviousBuyPrice(){
        this.PreviousBuy = getBuyPrice();
    }
    
    
    //Method returns quantity int
    public int getQuantity(){
        return quantity;
    }
    
    //Method sets buy price to parameter
    public void setBuyPrice(double buyPrice){
         this.buyPrice = buyPrice;
    }
    
    
    //Method adds parameter input to quantity variable
    public void addQuantity(int quantity){
        this.quantity += quantity ;
    }
    
    //Metho subtracts quantity by parameter input
    public void reduceQuantity(int quantity){
        this.quantity -= quantity ;
    }
    
    
    //Method returns volatility string
    public String getVolatility(){
        return volatility;  
    }
    
    
    //Method returns growthPattern
    public String getGrowthPattern(){
        return growthPattern;
    }
    
    
    //Method prints statistics to terminal
    public void Performance(){
        
        
        //percentage change calculated
        double percentageChange = ((buyPrice - PreviousBuy) / PreviousBuy) *100;
        
        System.out.println(name + " percentage change: " + percentageChange + "%");
    }
    
    //Pattern printed to terminal
    public void printPattern(){
        System.out.println("This Stock has not been specialised and will therefore be given a random pattern of growth");
    }
    
    
    //Method to calculate price change
    public void cycle(){
        
       //Chance generated between 1 - 10 
       int chance = (int) (Math.random() * (10 - 1)) + 1;
       
       //50% chance 
       if(chance > 5){
           
         //r is set to 0 - 10 more than buy price
         double r = (double) (Math.random() * ((getBuyPrice() + 10) - (getBuyPrice())) + getBuyPrice());
         
         setBuyPrice(r);
         
         System.out.println(getName() + " buy price increased to £" + getBuyPrice());
        }
        
       //other 50%
       else{
        //r set to 5 - 10 below the current buyprice   
        double r = (double) (Math.random() * ((getBuyPrice() - 5) - (getBuyPrice() - 10)) + getBuyPrice() - 10);    
        
        //If statement accounts for negative value
       if(r<0){setBuyPrice(0);}
        
        //Price set to r 
       else{setBuyPrice(r);}
        
        
       System.out.println(getName() + " buy price decreased to £" + getBuyPrice());
       }
        
    
    }


}