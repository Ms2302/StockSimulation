//Class declared extends Superclass stocks 
public class Speculative extends Stocks{
    
    //Instance variable excitement delcared
    private int excitement;
    
    //Constructor takes two strings for name and pattern of stock
    public Speculative(String name, String pattern){
        
        //Suerclass constructor called
        super(name,pattern);
        
        //excitement set to 0
        excitement = 0;
    }
    
    //Method to return buyPrice
    public double getBuyPrice(){
        
        //calls superclass method
        return super.getBuyPrice();
    }
    
    
    //Method to return quantity
    public int getQuantity(){
        
        //Superclass method called
        return super.getQuantity();
    }
    
    //Method to set initial price
    public void setInitial(){
        
        //calls superclass method to set price
        super.setInitial();
    }
    
    //Method to print the pattern specific to speculative stock object
    public void printPattern(){
        
        //Volatility is set through method call
        setVolatility();
        
        System.out.println();
        System.out.println(getName() + " is a Speculative stock with a " + getGrowthPattern() + " pattern, meaning it is unpredicatable and will bounce up and down rap." );
        System.out.println();
        
        //Overriding
    }
    
    //Method to print statistics of stock
    public void Performance(){
        
        //Percentage change calculated
        double percentageChange = ((getBuyPrice() - getPreviousBuyPrice()) / getPreviousBuyPrice()) *100;
        
        //Rounded to 2dp
        percentageChange = Math.round(percentageChange * 100.0) / 100.0;
        
        System.out.println("Speculative: " + getName() + " percentage change: " + percentageChange + "%");
        //Overriding
    }
    
    //Method to calculate change in price 
    public void cycle(){
        
        //chance between 1 - 10 generated
        int chance = (int) (Math.random() * (10 - 1)) + 1;
        
        //50% chance
        if(chance > 5){
            
         //r is set between 0 and 60 more than the buyPrice  
         double r = (double) (Math.random() * ((getBuyPrice() + 60) - (getBuyPrice())) + getBuyPrice());
         
         //r is then increased by the % of excitement variable
         r = r+(((r*excitement)/100));
         
         
         System.out.println("Excitement level: " + excitement);
         System.out.println();
         
         setBuyPrice(r);
         System.out.println(getName() + " buy price increased to £" + getBuyPrice());
         setExcitement();
         
         
        }
        
        //if chance is below 5
        else{
            
        //r is set between 20 and 60 lower than the buyprice    
        double r = (double) (Math.random() * ((getBuyPrice() - 20) - (getBuyPrice() - 60)) + getBuyPrice() - 60);    
        
        //if statement accounts for negative value
         if(r<0){setBuyPrice(0);}
         
         
        else{setBuyPrice(r);}
        
        System.out.println(getName() + " buy price decreased to £" + getBuyPrice());
        }
      //Overriding   
    
    }
    
    //Excitement is generate between 20 and 0
    public void setExcitement(){
        double r = (double) (Math.random() * (20-0) + 0);
        
        excitement = (int) r;
        
    }
    
    
                   
}
