//Declaration of class for bonds
public class BondMarket{
    //Instance variables declared
    private double currentPrice;
    private double previousPrice;
    private double interestRate; 
    private double investedAmount;
    private boolean isOwned;




public BondMarket(){
    //Instance variables initialised
    currentPrice =0;
    previousPrice =0;
    interestRate = 0;
    investedAmount = 0;
    isOwned = false;
}

//Method to be called once bond is sold to reduce the amount owned
public void sellBonds(double amount){
    currentPrice -= amount; 
    
    
}

//Method to add amount of bond owned
public void invest(double amount){
    //isOwned shows that the user owns bonds
    isOwned = true;
    investedAmount += amount;
    currentPrice = investedAmount;

}

//Method called every market cycle to calculate the new price of the user's bond
public void cycle(){
    
    
    //Sets previous price to calculate % change
    previousPrice = currentPrice;
    
    
    //Random number between boundary for change
    double r = (double) (Math.random() * ((5) - (2)) + 2);
    
    
    //add r as a percentage
    currentPrice = currentPrice + (currentPrice*(r/100));
    
    
    //Round price to 2dp
    currentPrice = Math.round(currentPrice * 100.0) / 100.0;
    
    
    //Workout % and round to 2dp
    double percentage = ((currentPrice - previousPrice) / previousPrice) *100;
   
    percentage = Math.round(percentage * 100.0) / 100.0;
    
    System.out.println();
    System.out.println("Bond investment grew to £" + currentPrice + " which is an increase of " + percentage + "%");
   
}


//Method to return variable isOwned
public boolean getOwned(){
    return isOwned;
}


//Method to return bond price
public double getCurrentPrice(){
    return currentPrice;
}



}