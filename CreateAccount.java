import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.io.File;
import java.util.InputMismatchException;

public class CreateAccount {
    public CreateAccount(Scanner scanner, ArrayList<Account> accounts) {

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

        Account acc = new Account(Firstname, lastname, id, password, tel, birthdate);
        JSONArray Account = new JSONArray();
        Account.add(acc.toJSON());
        accounts.add(acc);
        System.out.println("Your ID : " + acc.getId());
        new Menu(scanner, acc);
    }
}
