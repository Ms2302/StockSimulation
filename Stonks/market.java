//Scanner library imported
import java.util.Scanner;

//Main class declared
public class market{
    
    //Main method declared
    public static void main (String[] args[]){
        
        //Method from other class and file is read 
        GeneralTips.read();
        
        //Class Account variable initialised
        Account Account  = CreateAccount();
        
        //Cash is set to string input
        Account.setCash(getDouble("What is your starting cash: "));
        
        //Number of stocks set to int input
        int numOfStocks = getInt("Enter number of stocks to create: ");
        Stocks [] list = new Stocks[numOfStocks];
        
        //Variable bond initialised
        BondMarket bond = new BondMarket();
        
        //Method to fill list called
        createStocks(list, numOfStocks,Account);
        
        //method of stock market simulation called
        cycle(list,Account, bond);
    }
            
    
    //Method to fill list with stocks
    public static void createStocks(Stocks[] list, int numOfStocks, Account account){
        
        int count =0; 
        
        //loops runs for length of list
        while(count<numOfStocks){
            
            System.out.println();
            System.out.println("Amount of stocks remaining: " + (numOfStocks-count) );
            System.out.println();
            
            //Type of stock collected from input
            String stockType = getString("Is this a BlueChip, Growth, Speculative stock or Standard: ? (Case Sensitive)");
            System.out.println();
            
            //Statements set which subclass the superclass object belongs to
            
            //Set to class BlueChip
            if(stockType.equals("BlueChip")){
                
                //Substitution principle
                list[count] = new BlueChip(getString("Enter name of blueChip: "),"blueChip");
                
                list[count].printPattern();
                list[count].setInitial();
                count+=1;
            }
            
            //Set to class Speculative
            else if(stockType.equals("Speculative")){
                
                //Substituion principle
                list[count] = new Speculative(getString("Enter name of Speculative stock: "),"Speculative");
                
                list[count].printPattern();
                list[count].setInitial();
                count+=1;
            }
            
            //Set to class GrowthStock
            else if(stockType.equals("Growth")){
                
                //Substitution principle
                list[count] = new GrowthStock(getString("Enter name of Growth stock: "),"GrowthStock");
                
                list[count].printPattern();
                list[count].setInitial();
                count+=1;
            }
            
            //Leave as superclass Stocks
            else if(stockType.equals("Standard")){
                
                list[count] = new Stocks(getString("Enter name of Standard stock: "), "Standard");
                list[count].printPattern();
                list[count].setInitial();
                count+=1;
            }
                    
            else{
                System.out.println("Invalid Input");
            }
                     
                
        }
    }
    
    //Method to cycle through the market
    public static void cycle( Stocks [] list, Account Account, BondMarket bond){

            System.out.println("Which Stocks would you like to purchase: ");
            System.out.println();
                  
            //For loop prints all stocks and prices      
            for(int j = 0; j < list.length; j++){
                System.out.println(j + ": " + list[j].getName() + ", " + "Buy price: £" + list[j].getBuyPrice());
            }
                   
                    
            int StockChoice = 0;
            
            //For loop to buy stocks
            for(int i=0; i<list.length; i++){
                
                //Integer input
                StockChoice = getInt("Enter index or '111' to stop: ");
                System.out.println();
                
                //Input to break loop
                if(StockChoice == 111){
                    break;
                }
                
                //If statement checks if user has enough cash
                else if(list[StockChoice].getBuyPrice() <= Account.getCash()){
                    
                    //Method call to buy stock
                    Account.buyStock(list[StockChoice]);
                    
                    //variable owned set to true
                    list[StockChoice].setOwned(true);
                    
                    //Quanitity +=1
                    list[StockChoice].addQuantity(1);
                    
                    //Portfolio increased by stock price
                    Account.addToPortfolio(list[StockChoice].getBuyPrice());
                        
                    System.out.println("Remaining cash: £" + Account.getCash());
                }
                
                //if user doesn't have enough cash
                else{System.out.println("Insufficient funds!");}
                
            }
            
              
                
            //loop of event for user to choose    
            while (true){
                
                System.out.println("1. Cycle"+  "\n"  + "2. Deposit" + "\n" + "3. Show Balance" + "\n" + "4. Purchase Stocks" +  "\n" + "5. Purchase Bonds" +"\n" + "6. Sell Stocks" +  "\n" +  "7. Sell bonds"+ "\n" +  "8. End program" );
                int choice = getInt("Enter choice: ");
                
                //Input for cycling the market and stocks
                if (choice == 1){
                    
                   //Check if user owns bonds
                   if(bond.getOwned()){
                       
                       //call method to cycle bond
                       bond.cycle();
                       System.out.println();
                   }
                   
                   //for loop to run through list
                   for(int j = 0; j < list.length; j++){
                       
                       //if stock is owned by user
                       if(list[j].getOwned()){
                           
                           //set previous price for % change
                           list[j].setPreviousBuyPrice();
                           
                           //Class method call for cycle
                           //overriding
                           list[j].cycle();
                           
                           //If object is BlueChip
                           if(list[j] instanceof BlueChip){
                               System.out.println(list[j].getName() + " paid you £" + ((BlueChip) list[j]).getDividend() + " in dividends.");
                            
                               //Pay user dividends
                               Account.Deposit(((BlueChip) list[j]).getDividend());
                            }
                            
                        System.out.println();
                        
                        //performance printed
                        list[j].Performance();
                        
                        //Portfolio updated
                        cyclePortfolio(list,Account,bond);
                        
                        
                        System.out.println();
                        }
                        
                    
                   }
                
                }
                
                //input for deposit
                else if(choice ==2){
                    
                    //Cash += user input
                    Account.Deposit(getInt("How much would you like to deposit: "));
                    
                    System.out.println();
                }
                
                //Displays balance
                else if(choice ==3){
                    ShowBalance(Account);
                    System.out.println();
                }
                
                //Input for buying more stocks
                else if(choice==4){
                
                    //Displays stocks
                    for(int j = 0; j < list.length; j++){
                        System.out.println(j + ": " + list[j].getName() + ", " + "Buy price: £" + list[j].getBuyPrice());
                    }
                    
                    //for length of list user can buy stock
                    for(int j = 0; j < list.length; j++){
                        
                        StockChoice = getInt("Enter index or '111' to stop: ");
                        
                        //Break is 111 entered
                        if(StockChoice == 111){
                            break;
                        } 
                        
                        //check if user can afford stock
                        else if(Account.getCash() >= list[StockChoice].getBuyPrice()){
                            
                            //Method to update account
                            Account.buyStock(list[StockChoice]);
                            
                            //variable owned set to true
                            list[StockChoice].setOwned(true);
                            
                            //Quantity += 1
                            list[StockChoice].addQuantity(1);
                            
                            //Portfolio increased
                            Account.addToPortfolio(list[StockChoice].getBuyPrice());
                            
                            System.out.println("Remaining cash: £" + Account.getCash());
                            System.out.println();
                
                        }
                        
                        else{
                            System.out.println("Insufficeint funds!");
                            System.out.println();
                        }
                    }
            }
                //input for buying bonds
                else if(choice ==5){
                    
                    double investment = getDouble("How much would you like to invest in bonds: ");
                    
                    //Check if user can afford investment
                    if(investment <= Account.getCash()){
                        
                        //Account is updated
                        Account.buyBonds(investment);
                        
                        System.out.println("Cash: £" + Account.getCash());
                        
                        bond.invest(investment);
                        
                        //Portfolio increased
                        Account.addToPortfolio(investment);
                
                    }
                
                    else{
                        System.out.println("Insufficient funds!");
                    }
                
            
            
                }
                
                //Input for selling stocks
                else if(choice ==6){
                    
                    //For loop displays stocks
                    for(int j = 0; j < list.length; j++){
                        System.out.println(j + ": " + list[j].getName() + ", " + "Sell price: £" + list[j].getBuyPrice() + " Quantity owned: " + list[j].getQuantity());
                    }
                
                    //For loop for length of list
                    for(int j = 0; j < list.length; j++){
                        StockChoice = getInt("Enter index to sell or '111' to stop: ");
                        
                        //Break if input 111
                        if(StockChoice == 111){
                            break;
                        }
                        
                        //if user doesn't have stock to sell
                        else if(list[StockChoice].getQuantity() <= 0){
                            
                            //Quantity set to 0 
                            list[StockChoice].reduceQuantity(list[StockChoice].getQuantity());
                            
                            System.out.println("You own " + list[StockChoice].getQuantity() + " shares of this stocks!");
                        }
                        
                        //If user has stock to sell
                        else{
                            
                            //Quantity reduced by one 
                            list[StockChoice].reduceQuantity(1);
                            
                            //If they now own none, set is owned to false
                            if(list[StockChoice].getQuantity() == 0){
                                list[StockChoice].setOwned(false);
                            }
                               
                            //Update portfolio
                            Account.removeFromPortfolio(list[StockChoice].getBuyPrice());
                            
                            //update price
                            Account.Deposit(list[StockChoice].getBuyPrice());
                  
                            System.out.println("Portfolio Value: £" + Account.getPortfolio());
                            System.out.println("Cash: £" + Account.getCash());
                            System.out.println();
                  
                
                        }
                    }
                
                
                }
             
             //input for selling bonds
             else if(choice ==7){
                 System.out.println("You own £" + bond.getCurrentPrice()+ " in bonds"); 
                 double amount = getDouble("How much of your bonds would you like to sell: ");
                 
                 //Check if they can sell that amount of bonda
                 if(amount <= bond.getCurrentPrice()){
                     
                     //method to update bonds
                     bond.sellBonds(amount);
                 
                     //methods to update account and portfolio
                     Account.Deposit(amount);
                     Account.removeFromPortfolio(amount);
                }
                
                else{
                    System.out.println("Insufficient value of bonds");
                }
                 
                 
                }
                
                //input to exit program
               else if(choice ==8){
                   System.out.println("Thank you for using my program");
                   System.exit(0);
                }
        
        }
            
    }   
    
    //Method to create account object
    public static Account CreateAccount(){
        Account myObj = new Account();
        return myObj;
    }
    
   
    //Method to display balance
    public static void ShowBalance(Account myObj){
        
        //Most recent balance set
        myObj.updateTotalBalance();
        
        System.out.println("available cash: £" + myObj.getCash() + "\n" + "Portfolio balance: £" + myObj.getPortfolio() + "\n" + "Total Balance: £" + myObj.getTotalBalance());
    
    
    }
    
    //Method to update portfolio
    public static void cyclePortfolio(Stocks[] list, Account account, BondMarket bond ){
        
        //Set portfolio to 0
        account.setPortfolioZero();
        
        for(int j = 0; j < list.length; j++){
           if(list[j].getOwned()){
               
               //Add to portfolio value of all owned stocks
               for(int i=0; i<list[j].getQuantity(); i++){ 
                   account.addToPortfolio(list[j].getBuyPrice());
                }
            }
        }
        
        //Add bond value to portfolio
        account.addToPortfolio(bond.getCurrentPrice());
        
    }
    
    //Method to get input from user (int)
    public static int getInt(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextInt();
        
        
    }
    
    //Method to get input from user (double)
    public static double getDouble(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextDouble();
    }
    
    //Method to get input from user (string)
      public static String getString(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String temp = scanner.nextLine();
        return temp;
    }


}
