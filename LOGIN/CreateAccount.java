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
        Validation.getCheckChar(Firstname);
        

        System.out.println("Enter Your Lastname : ");
        String lastname = str.nextLine();
        Validation.getCheckChar(lastname);

        System.out.println("Enter Your id :");
        String id = str.nextLine();
        Validation.getCheckCharAndMaxnum(id, 13);

        System.out.println("Enter Your password :");
        
        String password = str.nextLine();

        System.out.println("Enter Your Comfirm password :");
        
        String Cfpassword = str.nextLine();

        Validation.getCheckpasswordequals(password,Cfpassword,8);

        System.out.println("Enter Your tel :");
        String tel = str.nextLine();
        Validation.CheckUserInputTel(tel);

        System.out.println("Enter Your birthdate ('dd','mm','yy') :");
        // String birthdate = CheckUserInputNum(scanner);
        String birthdate = scanner.nextLine();
        Validation.getCheckBirthdate(birthdate);

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

    public  String CheckUserInputStr(Scanner scanner) {
        String input = " ";
        boolean Vinput = false;
        while (!Vinput) {
            input = scanner.nextLine();

            if (!input.matches(".*\\d.*")) {
                // ใช้ Regular Expression (regex)
                // .*\\d.* ห้ามมีตัวเลขในString
                Vinput = true;
            } else {
                System.out.println("Please Enter String try again");
            }
        }
        return input;
    }

    public String CheckUserInputNum(Scanner scanner) {
        String input = " ";
        boolean Vinput = false;
        while (!Vinput) {
            input = scanner.nextLine();

            if (input.matches("\\d+") && input.length() == 13) {
                // ใช้ Regular Expression (regex)
                Vinput = true;
            } else {
                System.out.println("Please Enter Number try again Or ID 13-digit");
            }
        }
        return input;
    }

    public String CheckUserInputTel(Scanner scanner) {
        String input = "";
        boolean Vinput = false;
    
        while (!Vinput) {
            input = scanner.nextLine();
    
            if (input.matches("0[0-9]{9}")) {
                // ตรวจสอบว่าเป็นตัวเลข 10 หลัก และเริ่มต้นด้วย 0
                Vinput = true;
            } else {
                System.out.println(" Number Phone 10-digit Or Your Number Phone Start 0 Please try again:");
            }
        }
        return input;
    }
}
