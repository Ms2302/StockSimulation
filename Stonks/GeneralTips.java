//Importing all needed libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//Class declaration
public class GeneralTips{
    
    
    public static void read(){
        
        
        //Try and catch handle error exceptions 
        try{
            
            
            //Reads through file and prints each line to the terminal 
            File Tips = new File("Tips.txt");
            Scanner scanner = new Scanner(Tips);
            while(scanner.hasNextLine()){
                String text = scanner.nextLine();
                System.out.println(text);
                
            }
            scanner.close();
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
        catch(FileNotFoundException e){
            
            
            //String printed if error occurs
            System.out.println("An error has occured");
            e.printStackTrace();
            
        }
    
    }

}
