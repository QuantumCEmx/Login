import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class dataUser {
    private String FILE_PATH = "FileDB/Data.json";
    public dataUser(ArrayList<Account> accounts){
        
        File file = new File(FILE_PATH);
        // if(!file.exists()){
        //     try{
        //         file.createNewFile();
                
        //     }catch(Exception e){
        //         e.printStackTrace();
        //     }
        // }

        try (FileWriter files = new FileWriter(FILE_PATH)) {
            files.write(accounts.toString());
        } catch (IOException e) {
            System.out.println("Handle exception here");
            e.printStackTrace();
        }


    }

    public ArrayList<Account> getId(){

        return null;
        
    }

    public void SaveAccount(){

    }
}   
