import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    private static ArrayList<Accout> accouts;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        accouts = new ArrayList<>();
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
                    CreateAccount();
                    break;
                case 2:
                    Login();
                    break;

                    // default:
                    // System.out.println("Please Enter Choice(1-3)");
            }

        } while (choice != 3);

    }

    private static void CreateAccount() {

        System.out.println("Enter Your Firstname :");
        scanner.nextLine();
        String Firstname = scanner.nextLine();

        System.out.println("Enter Your Lastname :");
        String lastname = scanner.nextLine();

        System.out.println("Enter Your id :");
        String id = scanner.nextLine();

        System.out.println("Enter Your password :");
        String password = scanner.nextLine();

        System.out.println("Enter Your Comfirm password :");
        String Cfpassword = scanner.nextLine();
        if (!password.equals(Cfpassword)) {
            System.out.println("please Try Agin (Not Matching) \n");
            return;
        }

        System.out.println("Enter Your tel :");
        String tel = scanner.nextLine();

        System.out.println("Enter Your birthdate ('dd','mm','yy') :");
        String birthdate = scanner.nextLine();

        Accout Acc = new Accout(Firstname, lastname, id, password, tel, birthdate);
        accouts.add(Acc);
        // System.out.println("Your ID : " + Acc.getId());
        Menu(Acc);

    }

    private static void Login() {
        
        System.out.println("Enter Your Account ID : ");
        scanner.nextLine();
        String id = scanner.nextLine();

        // System.out.println("Enter Your Password : ");
        // String password = scanner.nextLine();
        Accout accout = new Accout();
        boolean Exist = false;
        for (Accout Acc : accouts) {
            if (Acc.getId().equals(id)) {
                Exist = true;
                accout = Acc;
            }
            // if (Acc.getId().equals(id)&&Acc.getPassword().equals(password)) {
            // Exist = true;
            // accout = Acc;
            // }
            if (Exist) {
                Menu(accout);
            } else {
                System.out.println("Your Not Have Account!!");
            }
        }

    }

    private static void Menu(Accout Acc) {
        System.out.println("Welcome To Cinemx " + Acc.getFirstname() + "  " + Acc.getLastname());
    }
}
