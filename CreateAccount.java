import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;
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
        
        File file = new File("FileDB/Data.json");
        JSONArray Jaccount;
        if (file.exists()) {
            try {
                String fileContent = new String(Files.readAllBytes(Paths.get("FileDB/Data.json")));
                //chat
                Jaccount = (JSONArray) JSONValue.parse(fileContent);
            } catch (IOException e) {
                e.printStackTrace();
                Jaccount = new JSONArray();
            }
        } else {
            Jaccount = new JSONArray();
        }

        Jaccount.add(acc.toJSONs(acc));
        accounts.add(acc);

        try (FileWriter fileWriter = new FileWriter("FileDB/Data.json")) {
            fileWriter.write(Jaccount.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
