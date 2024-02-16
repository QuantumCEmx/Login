import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Account {

    private String Firstname;
    private String lastname;
    private String id;
    private String password;
    private String tel;
    private String birthdate;
    

    public Account() {
    }

    public Account(String Firstname, String lastname, String id, String password, String tel, String birthdate) {
        super();
        this.Firstname = Firstname;
        this.lastname = lastname;
        this.id = id;
        this.password = password;
        this.tel = tel;
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        Firstname = Firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return (id != null) ? id : "";
    }

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public JSONObject toJSONs(Account acc) {
        JSONObject InsertData = new JSONObject();
        InsertData.put("Firstname", acc.getFirstname());
        InsertData.put("Lastname", acc.getLastname());
        InsertData.put("Id", acc.getId());
        InsertData.put("Password", acc.getPassword());
        InsertData.put("Birthdate", acc.getBirthdate());
        InsertData.put("Tel", acc.getTel());
        return InsertData;
    }
    public static Account fromJSON(JSONObject json) {
        String id = (String) json.get("Id");
        String Firstname = (String) json.get("Firstname");
        String lastname = (String) json.get("Lastname");
        String password = (String) json.get("Password");
        String tel = (String) json.get("Tel");
        String birthdate = (String) json.get("Birthdate");

        // Assuming you have a constructor in your Account class
        return new Account(Firstname, lastname, id, password, tel, birthdate);
    }
}