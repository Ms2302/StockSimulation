//Subclass extends superclasss
public class GrowthStock extends Stocks{
 
    //Constructor for subclass takes name and pattern strings    
    public GrowthStock(String name, String pattern){
     
        //Uses constructor of superclass
        super(name,pattern);
     
    }
    
    //Method returns object buyprice
    public double getBuyPrice(){
        return super.getBuyPrice();  
    }
 
    //Method returns object quantity
    public int getQuantity(){
        return super.getQuantity();
     }
    
    //Method call superclass method to set initial variables
    public void setInitial(){
        super.setInitial();
     }
    
    //Method prints unique pattern of class
    public void printPattern(){
     
        //Volatility is set through method call
        setVolatility();
        
        System.out.println();
        
        System.out.println(getName() + " is a Growth Stock with a " + getGrowthPattern() + " pattern, meaning it is predicted to grow at a good rate but not guarenteed." );
        
        System.out.println();
        //Overriding
     }
    
    //Method prints statistics to terminal  
    public void Performance(){
        //calculated % change
        double percentageChange = ((getBuyPrice() - getPreviousBuyPrice()) / getPreviousBuyPrice()) *100;
        
        //Sets % change to 2dp
        percentageChange = Math.round(percentageChange * 100.0) / 100.0;
     
        System.out.println("GrowthStock: " + getName() + " percentage change: " + percentageChange+ "%");
        //Overriding
     }
 
    //Method to calculate price change every market cycle   
    public void cycle(){
        
        //Chance is set randomly between 1 and 10
        int chance = (int) (Math.random() * (10 - 1)) + 1;
        
        //if chance is 5 or more (50% chance)
        if(chance > 4){
            
         //Increase price bounds from 0 to +35
         double r = (double) (Math.random() * ((getBuyPrice() + 35) - (getBuyPrice())) + getBuyPrice());
         
         //BuyPrice is set to r
         setBuyPrice(r);
         
         System.out.println(getName() + " buy price increased to £" + getBuyPrice());
         
         
        }
        //if 4 or below
        else{
            
        //Price falls from 10 to 19    
        double r = (double) (Math.random() * ((getBuyPrice() - 10) - (getBuyPrice() - 19)) + getBuyPrice() - 19);    
        
        //if statement accounts for negative 
        if(r<0){setBuyPrice(0);}
        
        
        else{setBuyPrice(r);}
        
        System.out.println(getName() + " buy price decreased to £" + getBuyPrice());
        
        }
        //Overriding
        
    
      }
}