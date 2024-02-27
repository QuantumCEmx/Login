package LOGIN;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Login {
    public Login(Scanner scanner, ArrayList<Account> accounts) {

        boolean loginSuccessful = false;
        Account account = null;
        
        while (!loginSuccessful) {
            System.out.println("Enter Your Account ID : ");
            String id = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Enter Your Password : ");
            String password = scanner.nextLine();

            for (Account acc : loadAccountsFromJson()) {
                // System.out.println(acc.getId() + acc.getFirstname() + acc.getPassword() + acc.getTel() );
                if (acc.getId().endsWith(id)&&acc.getPassword().endsWith(password)) {
                    System.out.println("Login successful!");
                    loginSuccessful = true;
                    account = acc;
                    break; 
                }
            }
            if (!loginSuccessful) {
                System.out.println("Invalid ID or password. Please try again.");
            }
        }
        new Menu(scanner, account);

    }
     private ArrayList<Account> loadAccountsFromJson() {
        ArrayList<Account> loadedAccounts = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("FileDB/Data.json"));

            JSONArray jsonArray = (JSONArray) obj;

            for (Object jsonObj : jsonArray) {
                JSONObject jsonAccount = (JSONObject) jsonObj;

                //Use Chat
                Account account = Account.fromJSON(jsonAccount);
                loadedAccounts.add(account);
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        return loadedAccounts;
    }
}
