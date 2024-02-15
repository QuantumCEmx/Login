import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public Login(Scanner scanner ,ArrayList<Account> accounts) {

        System.out.println("Enter Your Account ID : ");
        scanner.nextLine();
        String Id = scanner.nextLine();

        System.out.println("Enter Your Password : ");
        String Password = scanner.nextLine();

        Account account = new Account();
        boolean Exist = false;
        
        for(Account acc : accounts){
            if(acc.getId().equals(Id) && acc.getPassword().equals(Password)){
                System.out.println("Login successful!");
                Exist = true;
                account = acc;
                new Menu(scanner, account);
            }
        }
        if(Exist){
            new Menu(scanner, account);
        }else{
            System.out.println("Invalid ID or password. Please try again.");
        }

        
        // for (Account acc : accounts) {
        //     if (acc.getId().equals(Id) && acc.getPassword().equals(Password)) {
        //         Exist = true;
        //         account = acc;
        //         break; // Break the loop once the account is found
        //     }
        // }
        // if (Exist) {
        //     System.out.println("Login successful!");
        //     new Menu(scanner, account);
        // } else {
        //     System.out.println("Entered ID: " + Id);
        //     System.out.println("Entered Password: " + Password);

        //     System.out.println("Invalid ID or password. Please try again.");
        // }
    }
}
