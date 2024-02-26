package Validation;

import java.util.Scanner;
import java.time.LocalDate;
// ดึงปีปัจจุบัน คศ

public class Validation {

    public Validation() {
    }

    public static boolean CheckMaxnum(String Num, int maxnum) {
        // String strint = Integer.toString(Num);
        int minpass = 6;
        if (Num.length() == maxnum && Num.length() >= minpass) {
            return true;
        } else {
            System.out.println("Please Enter Number try again Max digit");
            return false;
        }
    }

    public static boolean CheckCharAndMaxnum(String Cint, int maxnum) {
        // เช็คตัวเลขว่ามีข้อความหรือไม่และเช็คค่าสุงสุดของตัวเลข
        if (Cint.matches("\\d{" + maxnum + "}")) {
            return true;
        } else {
            System.out.println("Unsuccessful ");
            return false;
        }
    }

    public static boolean CheckUserInputTel(String Cint) {

        if (Cint.matches("0[0-9]{9}+$")) {
            // ตรวจสอบว่าเป็นตัวเลข 10 หลัก และเริ่มต้นด้วย 0
            return true;
        } else {
            System.out.println("Number Phone 10-digit Or Your Number Phone Start 0 try again:");
            return false;
        }
    }

    public static boolean CheckChar(String chars) {
        // เช็คข้อความว่า มีตัวเลขมั้ย
        if (!chars.matches(".*\\d.*") && chars.matches("^[a-zA-Z]+$")) {
            return true;
        } else {
            System.out.println("Please Enter String try again");
        }
        return false;

    }

    public static boolean CheckInt(String Cint) {
        // เช็คตัวเลขว่า มีข้อความมั้ย

        if (Cint.matches("\\d+")) {
            return true;
        } else {
            System.out.println("Please Enter Number try again");
            return false;

        }
    }

    public static boolean Checkpasswordequals(String pas, String Cpas, int maxnum) {
        
        if (!pas.equals(Cpas)) {
            System.out.println("Not Matching ");
            return false;
        }

        if (Validation.CheckMaxnum(Cpas, maxnum)) {
            System.out.println("successful ");
            return true;
        } else {
            System.out.println("Pls Max" + " " + maxnum + " " + "digit");
            return false;
        }
    }

    public static boolean CheckBirthdate(String dates) {
        int currentYear = LocalDate.now().getYear();
        String regex = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(\\d{4})$";
        // String regex2 = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(\\d{4})$";

        if (dates.matches(regex)) {
            // เช็ควัน 01-99 เช็ค เดือน 01-99 เช็คปี 01-99 และ ไม่มีอักษรพิเศษ
            String[] dateParts = dates.split("/"); 
            // สับสติง โดยแบ่งจาก / 
            int day = Integer.parseInt(dateParts[0]);
            // แปลง เลขindex แรก จากการแบ่ง เป็นวัน 
            int month = Integer.parseInt(dateParts[1]);
            // แปลง เลขindex สอง จากการแบ่ง เป็นเดือน
            int year = Integer.parseInt(dateParts[2]);
            // แปลง เลขindex สาม จากการแบ่ง เป็นปี

            // if(Validation.CheckLeapyear(year)){
            //     //retrun true เลยเช็ค เดือน
            //     if(month==02){
            //         if(day<=29){
            //             System.out.println("day 01 - 29 is true ");
            //             return true;
            //         }
            //     }
            // }else{
            //     System.out.println("is not a leap year Unable to enter date 29");
            //     return false;
            // }

            if(Validation.CheckLeapyear(year) == true){
                if(month==02){
                    if(day<=29){
                        System.out.println("day 01 - 29 is true ");
                        return true;
                    }else{
                        System.out.println("day 01 - 29 Only ");

                    }
                }else{
                    System.out.println("Save data");
                }
                
            }
            if(Validation.CheckLeapyear(year) == false){
                if(month==02){
                    if(day<=28){
                        System.out.println("day 01 - 28 is true ");
                        return true;
                    }else{
                        System.out.println("day 01 - 28 Only ");

                    }
                }else{
                    System.out.println("Save datas");
                }
            }
        
        }
            return false;
    }

    public static boolean CheckLeapyear(int y){
        // หา leap year
        int CS = LocalDate.now().getYear(); //ดึงปัจจุบัน คศ
        // boolean ly = false;
        if(y < CS || (y-543) >= 1925 || (y+543) >= 2468 && (y+543) <= 2566 ){
            if((y+543)>=3000){
                y = y - 543;
            }
            y=y+0;
            boolean isLeapYear = (y%4==0);
            isLeapYear = isLeapYear && (y % 100 != 0 || y % 400 == 0);
            if (isLeapYear) {
                System.out.println(y + " is a leap year.");
                return true;
              } 
        }
        return false;  
    }


    public static boolean CheckOlyNum(Scanner Nums) {
        // อ่านค่าจากที่กรอกว่าเป็นตัวเลขรึป่าว ถ้าใช้รีเทรินค่า True;
        return Nums.hasNextInt();
    }










































    public static void getCheckChar(String Strs) {
        if (Validation.CheckChar(Strs)) {
            System.out.println("succeed");
        }
    }

    public static void getCheckCharAndMaxnum(String Cint, int maxnum) {
        if (Validation.CheckCharAndMaxnum(Cint, maxnum)) {
            System.out.println("succeed");
        }
    }

    public static void getCheckUserInputTel(String t) {
        if (Validation.CheckUserInputTel(t)) {
            System.out.println("Succeed");
        }
    }

    public static boolean getCheckMaxnum(String n, int m) {
        if (Validation.CheckMaxnum(n, m)) {
            System.out.println("Succeed");
            return true;
        } else {
            System.out.println("Hi pass");
            return false;

        }
    }

    public static void getCheckpasswordequals(String p, String cf, int mn) {
        if (Validation.Checkpasswordequals(p, cf, mn)) {

        }
    }

    public static void getCheckBirthdate(String bd) {
        if(Validation.CheckBirthdate(bd)){
            // System.out.println("Susses");
        }
    }
}
