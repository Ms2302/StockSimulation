//Scanner imported
import java.util.Scanner;
//Class declared
public class Account{
    //Instance variables declared
    public double cash;
    public double portfolio;
    public double totalBalance;
    public Stocks[] StocksOwned;
    




    public Account(){
        //Instance variables initialised
        portfolio = 0;
        totalBalance = 0;
    
    
    }
    
    
    //Method to increase portfolio double
    public void addToPortfolio(double amount){
        portfolio += amount;
    }
    
    
    //Method to decrease portfolio 
    public void removeFromPortfolio(double sellPrice){
        portfolio -= sellPrice; 
    }
    
    
    //Method to return portfolio double
    public double getPortfolio(){
        //Set portfolio to 2dp
        portfolio = Math.round(portfolio * 100.0) / 100.0;
        return portfolio; 
    }
    
    
    //Set double portfolio to 0 
    public void setPortfolioZero(){
        portfolio = 0;
    }
    
    
    //Method to set cash variable to parameter
    public void setCash(double cash){
        this.cash = cash;
    }
    
    
    //Method to increase to cash and set it to 2dp
    public void Deposit(double amount){
        cash += amount;
        cash =  Math.round(cash * 100.0) / 100.0;
        //Call method to update total balance double
        updateTotalBalance();
    }
    
    
    //Method to reduce cash buy the price of a stock once it has been bought
    public void buyStock(Stocks stock){
        cash = cash - stock.getBuyPrice();
    }
    
    
    //Return cash double
    public double getCash(){
        //Set cash to 2dp
        cash = Math.round(cash * 100.0) / 100.0;
        return cash;
    }
    
    
    //Method to set balance to new increased cash
    public void updateTotalBalance(){
        totalBalance = cash + portfolio;
        //Round total balance to 2dp
        totalBalance = Math.round(totalBalance * 100.0) / 100.0;
    }
    
    
    //Method for buying bonds
    public void buyBonds(double amount){
        //cash reduced by amount of bonds bought
        cash -= amount;
    }
    
    
    //Return total balance double
    public double getTotalBalance(){
        return totalBalance;
    }

}
