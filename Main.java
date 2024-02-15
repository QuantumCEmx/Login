import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    private static ArrayList<Account> accounts;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        accounts = new ArrayList<>();
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
                default:
                    System.out.println("Please Enter Choice(1-3)");
                    break;
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

        Account Acc = new Account(Firstname, lastname, id, password, tel, birthdate);
        accounts.add(Acc);
        System.out.println("Your ID : " + Acc.getId());
        Menu(Acc);

    }

    private static void Login() {

        System.out.println("Enter Your Account ID : ");
        scanner.nextLine();
        String Id = scanner.nextLine();

        System.out.println("Enter Your Password : ");
        String Password = scanner.nextLine();

        Account account = new Account();
        boolean Exist = false;
        for(Account Acc : accounts){
            if(Acc.getId().equals(Id)&&Acc.getPassword().equals(Password)){
                Exist = true;
                Acc.getPassword();
                account = Acc;
            }
            else if(!Acc.getPassword().equals(Password)){
                System.out.println("ํ Your password is wrong !!!");
                
            }
            else if(!Acc.getId().equals(Id)&&!Acc.getPassword().equals(Password)){
                System.out.println("Your Not Have Account Or Your password is wrong ");
            }
            else if(Exist){
                System.out.println("please try agin");
                Menu(account);
            }
            else{
                System.out.println("Your Not Have Account!!");
            }
        }
        // for (Account Acc : accounts) {
        //     if (Acc.getId().equals(id)) {
        //         Exist = true;
        //         Acc.getId();
        //         account = Acc;
        //     } else if (Acc.getPassword().equals(password)) {
        //         System.out.println("ํYour password is wrong !!!");
        //         Login();
        //     } else {
        //         Exist = false;
        //         System.out.println("Your Not Have Account!!");
        //         Menu(account);
        //     }
        // }

    }

    private static void Menu(Account Acc) {
        System.out.println("Welcome To Cinemx " + Acc.getFirstname() + "  " + Acc.getLastname());
    }
}
