package Validation;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner Nums = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        
        // เช็คเบอร์โทร
        System.out.println("phone number");
        String Tel = str.nextLine();
        Validation.getCheckUserInputTel(Tel);
        System.out.println("-----------------");
        

        // เช็คพวกชื่อสกุล
        System.out.println("Enter firstname");
        String firstname = str.nextLine();
        Validation.getCheckChar(firstname);
        System.out.println("-----------------");


        // เช็คเลขบัตรประชาชน
        System.out.println("Enter ID CARD");
        String ID = str.nextLine();
        Validation.getCheckCharAndMaxnum(ID,13);
        System.out.println("-----------------");

        
        // เช็ค password ว่าเหมือนกันกับ Cpassword มั้ย และ กำหนดขนาด
        System.out.println("Enter Password");
        String Password = str.nextLine();

        System.out.println("Enter Confirm Password");
        String CfPassword = str.nextLine();

        Validation.getCheckpasswordequals(Password,CfPassword,6);
        System.out.println("-----------------");

        // เช็ควันที่ในรูปแบบ วว ดด ปป 
        
        System.out.print("Enter a date (DD/MM/YYYY): ");
        String Birthdate = str.nextLine();
        
        Validation.getCheckBirthdate(Birthdate);
        System.out.println("-----------------");


        
        







    }
   
}
