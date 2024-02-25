import java.util.ArrayList;
import java.util.Scanner;

public class Main {
     Scanner scanner;
    private  ArrayList<Account> accounts;

    public  void main(String[] args) {
        scanner = new Scanner(System.in);
        accounts = new ArrayList<>();
        // dataUser data = new dataUser(accounts);
        int choice;

        do {
            System.out.println("Welcome to Cinemx ");
            System.out.println("1. Create Account ");
            System.out.println("2. Login ");
            System.out.println("3. Exit ");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    new CreateAccount(scanner ,accounts);
                    break;
                case 2:
                    new Login(scanner,accounts);
                    break;
                default:
                    System.out.println("Please Enter Choice(1-3)");
                    break;
            }

        } while (choice != 3);

    }
}
