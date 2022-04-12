public class User {

    public String firstName;
    public String lastName;
    public String userName;
    public String password;
    public int userID;
    public String phoneNum;
    private String email;
    public boolean proAcc;

    public User(String fname, String lname, String uname, String pass, int id, String phone, String em, boolean pro) {
        firstName = fname;
        lastName = lname;
        userName = uname;
        password = pass;
        userID = id;
        phoneNum = phone;
        email = em;
        proAcc = pro;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public String getPhoneNumber(){
        return phoneNum;
    }
    public String getEmailID(){
        return email;
    }
    public Boolean getAccountType(){
        return proAcc;
    }

}
