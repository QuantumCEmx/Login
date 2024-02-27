package LOGIN;

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
        Scanner Nums = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        Object a = new Object();

        System.out.println("Enter Your Firstname :");
        scanner.nextLine();
        String Firstname = str.nextLine();
        if(!Validation.getCheckChar(Firstname)){
            System.out.println(" Firstname Fail");
            return; // ไม่ทำการบันทึกข้อมูล
        }
        // Validation.getCheckChar(Firstname);

        System.out.println("Enter Your Lastname : ");
        String lastname = str.nextLine();
        if(!Validation.getCheckChar(lastname)){
            System.out.println(" lastname Fail");
            return; // ไม่ทำการบันทึกข้อมูล
        }
        // Validation.getCheckChar(lastname);

        System.out.println("Enter Your id :");
        String id = str.nextLine();
        if(!Validation.getCheckCharAndMaxnum(id, 13)){
            System.out.println(" Id Card Fail");
            return; // ไม่ทำการบันทึกข้อมูล
        }
        
        // Validation.getCheckCharAndMaxnum(id, 13);

        System.out.println("Enter Your password :");

        String password = str.nextLine();

        System.out.println("Enter Your Comfirm password :");

        String Cfpassword = str.nextLine();

       if(!Validation.getCheckpasswordequals(password, Cfpassword, 8)){
            System.out.println(" Password Fail");
            return; // ไม่ทำการบันทึกข้อมูล
       }

        System.out.println("Enter Your tel :");
        String tel = str.nextLine();
        if(!Validation.CheckUserInputTel(tel)){
            System.out.println(" Tel Fail");
            return; // ไม่ทำการบันทึกข้อมูล
        }
        // Validation.CheckUserInputTel(tel);

        System.out.println("Enter Your birthdate ('dd','mm','yy') :");
        // String birthdate = CheckUserInputNum(scanner);
        String birthdate = scanner.nextLine();
        if(!Validation.getCheckBirthdate(birthdate)){
            System.out.println(" birthdate Fail");
            return; // ไม่ทำการบันทึกข้อมูล
        }
        // Validation.ReCheckBirthdate(birthdate);
        // Validation.getCheckBirthdate(birthdate);

        Account acc = new Account(Firstname, lastname, id, password, tel, birthdate);
       

        File file = new File("FileDB/Data.json");
        JSONArray Jaccount;
        if (file.exists()) {
            try {
                // readAllBytes อ่านข้อมูลไฟล์ทั้งหมดเป็น byte array
                String fileContent = new String(Files.readAllBytes(Paths.get("FileDB/Data.json")));
                // chat
                Jaccount = (JSONArray) JSONValue.parse(fileContent);
                // JSONValue.parse แปงล json string เป็น JSONArray
            } catch (IOException e) {
                e.printStackTrace();
                Jaccount = new JSONArray();
            }
        } else {
            Jaccount = new JSONArray();
        }
        if (Validation.CheckIdInJson(Jaccount, accounts, id)) {
            System.out.println("Id Card " + id + " have accounts");
            return; // ไม่ทำการบันทึกข้อมูล
        }
        Jaccount.add(acc.toJSONs(acc));
        // เพิ่มข้อมูลลง Jaccount (JSONArray)
        accounts.add(acc);
        // เพิ่มข้อมูลลง accounts (Arraylist)

        try (FileWriter fileWriter = new FileWriter("FileDB/Data.json")) {
            fileWriter.write(Jaccount.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
