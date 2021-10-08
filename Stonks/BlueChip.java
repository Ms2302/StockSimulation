//Subclass extends Stocks superclass
public class BlueChip extends Stocks{
    //Instance variable declared
    private double dividend; 
    
    //Constructor takes in name and pattern
    public BlueChip(String name,String pattern){
        //super used to set name and pattern
        super(name, pattern);
        
        dividend= 0;
        
    }
    
    //Method to return current price
    public double getBuyPrice(){
        //Calls method of superclass
        return super.getBuyPrice();
        
    }
    
    //Method to return quantity
    public int getQuantity(){
        //Calls method of superclass
        return super.getQuantity();
    }
    
    //Method to set initial prices
    public void setInitial(){
        //Calls method of superclas
        super.setInitial();
    }
    
    //Method to print specific pattern of subclass
     public void printPattern(){
        //Volatility variable set by method call 
        setVolatility();
        
        System.out.println();
        //Unique String is printed showing growth and name of BlueChip
        System.out.println(getName() + " is a Blue Chip Stock with a " + getGrowthPattern() + " pattern, meaning it is predicted to grow at a slow but almost guarenteed rate." );
        
        System.out.println();
        //Overriding 
    }
    
    
    //Method to print statistics of stocks per cycle
    public void Performance(){
        //percentage change calculated
        double percentageChange = ((getBuyPrice() - getPreviousBuyPrice()) / getPreviousBuyPrice()) *100;
        
        //percentage change rounded to 2dp
        percentageChange = Math.round(percentageChange * 100.0) / 100.0;
        
        System.out.println("BlueChip: " + getName() + " percentage change: " + percentageChange+ "%");
        //Overriding 
    }
    
    
    //Method to calculate rate of change every Market cycle
    public void cycle(){
        //Chance between 1 and 10 calculated
        int chance = (int) (Math.random() * (10 - 1)) + 1;
        
        //only if chance is 1 or 0 will price fall
        if(chance > 1){
            
         //Change calculated between 0 and 20   
         double r = (double) (Math.random() * ((getBuyPrice() + 20) - (getBuyPrice())) + getBuyPrice());
         
         //New price is set
         setBuyPrice(r);
         
         //Change is printed to terminal
         System.out.println(getName() + " buy price increased to £" + getBuyPrice());
        }
        //If change is 1 or 0 
        else{
            
        //Price decreases from 2 to 20 
        double r = (double) (Math.random() * ((getBuyPrice() - 2) - (getBuyPrice() - 20)) + getBuyPrice() - 20);
        
        //If statement corrects price if it becomes negative
        if(r<0){setBuyPrice(0);}
        
        //Set price as r if it isn't negative
        else{setBuyPrice(r);}
        
        //Fall in price printed to terminal
        System.out.println(getName() + " buy price decreased to £" + getBuyPrice());
        
        }
        
        //Dividend is set after price change
        setDividend();
        
        //overriding
    }
    
    //Method to set the value of dividend
    public void setDividend(){
        
        //Dividend set to be 5% of stock price, user is paid this amount every cycle
        dividend = getBuyPrice() * 0.05;
        
        //Dividend rounded to 2dp
        dividend = Math.round(dividend * 100.0) / 100.0;
        
        //Dividend multiplied by number of stocks owned
        dividend *= getQuantity();
    }
    
    //Method to return dividend.
    public double getDividend(){
        return dividend;
    }
    
    
}