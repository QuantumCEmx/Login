// import org.json.simple.JSONArray;
// import org.json.simple.JSONObject;

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

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public JSONObject toJSON() {
        JSONObject InsertData = new JSONObject();
        InsertData.put( this.Firstname);
        InsertData.put( this.lastname);
        InsertData.put( this.id);
        InsertData.put( this.password);
        InsertData.put( this.birthdate);
        return InsertData;
    }
}