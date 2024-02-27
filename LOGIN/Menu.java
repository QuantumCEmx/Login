package LOGIN;
import java.util.Scanner;

public class Menu {
    public Menu(Scanner scanner , Account acc){
        System.out.println("Welcome To Cinemx " + acc.getFirstname() + "  " + acc.getLastname());
    }
    public static void displayMenu() {
        System.out.println("Welcome to Cinemx ");
        System.out.println("1. Create Account ");
        System.out.println("2. Login ");
        System.out.println("3. Exit ");
}
    
}
