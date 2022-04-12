public class ProAccount extends User{

    public ProAccount(String fname, String lname, String uname, String pass, int id, String phone, String em, boolean pro) {
        super(fname, lname, uname, pass, id, phone, em, true);
    }
}
