import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.FileNameMap;
import java.util.ArrayList;


public class Login extends JPanel implements ActionListener {

    //Window size
    private static int WIDTH = 700;
    private static int HEIGHT = 700;

    //instance variables
    //database basically
    private static ArrayList<User> users = new ArrayList();

    //login panel elements
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passLabel;
    private static JPasswordField passField;
    private static JButton loginButton;
    private static JButton registerButton;
    private static CardLayout c1;

    //Register panel elements
    private static JLabel fName;
    private static JTextField fNameText;
    private static JLabel lName;
    private static JTextField lNameText;
    private static JLabel userName;
    private static JTextField userNameText;
    private static JLabel passSelection;
    private static JTextField passFieldReg;
    private static JLabel email;
    private static JTextField emailField;
    private static JLabel phoneNumber;
    private static JTextField phoneText;
    private static JButton regButton;



    public Login() {
        users.add(new User("Ehsan", "Baghdadi", "eb", "123", 1, "123",
                "eb@gmail.com", true));
        users.add(new User("Migo", "Divo", "md", "1234", 2, "1234",
                "ewe", true));
    }



    public static void main(String[] args) {
        //setting up window
        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);

        JPanel panelCont = new JPanel();
        JPanel panelLog = new JPanel();
        panelLog.setLayout(new BoxLayout(panelLog, BoxLayout.Y_AXIS));
        JPanel panelReg = new JPanel();
        panelReg.setLayout(new BoxLayout(panelReg, BoxLayout.Y_AXIS ));

        //cardlayout for panel switching
        c1 = new CardLayout();
        panelCont.setLayout(c1);
        panelLog.setBackground(Color.blue);
        panelReg.setBackground(Color.lightGray);
        panelCont.add(panelLog, "1");
        panelCont.add(panelReg, "2");
        c1.show(panelCont,"1");


        //login panel
        //user text and label
        userLabel = new JLabel("User");
        userLabel.setPreferredSize(new Dimension(80,25));
        panelLog.add(userLabel);
        userText = new JTextField(20);
        userText.setPreferredSize(new Dimension(165,25));
        userText.setMaximumSize(new Dimension(userText.getPreferredSize().width, userText.getMinimumSize().height));
        panelLog.add(userText);

        //password text and label
        passLabel = new JLabel("Password");
        panelLog.add(passLabel);
        passField = new JPasswordField();
        passField.setPreferredSize(new Dimension(165,25));
        passField.setMaximumSize(new Dimension(passField.getPreferredSize().width, passField.getMinimumSize().height));
        panelLog.add(passField);

        //login button
        loginButton = new JButton("Login");
        loginButton.setBounds(250, 400,80,25);
        loginButton.addActionListener(new Login());
        panelLog.add(loginButton);

        loginButton.addActionListener(e -> {
            String tempUser = userText.getText();
            String tempPass = passField.getText();

            for (int i = 0; i < users.size(); i++) {
                if (tempUser.equals(users.get(i).getUserName()) && tempPass.equals(users.get(i).getPassword())) {
                    System.out.println("Success");
                    break;
                }
                if (i == users.size() - 1) {
                    System.out.println("No match");
                }
            }
        });

        //registration button
        registerButton = new JButton("Register");
        registerButton.setBounds(350, 400,80,25);
        registerButton.addActionListener(new Login());
        panelLog.add(registerButton);
        registerButton.addActionListener(e -> c1.show(panelCont, "2"));

        //register panel
        //all info fields to create an account
        fName = new JLabel("First Name");
        panelReg.add(fName);
        fNameText = new JTextField(20);
        fNameText.setPreferredSize(new Dimension(80,25));
        fNameText.setMaximumSize(new Dimension(fNameText.getPreferredSize().width, fNameText.getMinimumSize().height));
        panelReg.add(fNameText);

        lName = new JLabel("Last Name");
        panelReg.add(lName);
        lNameText = new JTextField(20);
        lNameText.setPreferredSize(new Dimension(80,25));
        lNameText.setMaximumSize(new Dimension(lNameText.getPreferredSize().width, lNameText.getMinimumSize().height));
        panelReg.add(lNameText);

        userName= new JLabel("User Name");
        panelReg.add(userName);
        userNameText= new JTextField(20);
        userNameText.setPreferredSize(new Dimension(80,25));
        userNameText.setMaximumSize(new Dimension(userNameText.getPreferredSize().width, userNameText.getMinimumSize().height));
        panelReg.add(userNameText);

        passSelection = new JLabel("Password");
        panelReg.add(passSelection);
        passFieldReg= new JTextField(20);
        passFieldReg.setPreferredSize(new Dimension(80,25));
        passFieldReg.setMaximumSize(new Dimension(passFieldReg.getPreferredSize().width, passFieldReg.getMinimumSize().height));
        panelReg.add(passFieldReg);

        email= new JLabel("Email");
        panelReg.add(email);
        emailField= new JTextField(20);
        emailField.setPreferredSize(new Dimension(80,25));
        emailField.setMaximumSize(new Dimension(emailField.getPreferredSize().width, emailField.getMinimumSize().height));
        panelReg.add(emailField);

        phoneNumber= new JLabel("Phone Number");
        panelReg.add(phoneNumber);
        phoneText= new JTextField(20);
        phoneText.setPreferredSize(new Dimension(80,25));
        phoneText.setMaximumSize(new Dimension(phoneText.getPreferredSize().width, phoneText.getMinimumSize().height));
        panelReg.add(phoneText);

        regButton = new JButton("Register");
        regButton.setBounds(250, 400,80,25);
        regButton.addActionListener(new Login());
        panelReg.add(regButton);

        //creating user account if conditions met
        regButton.addActionListener(e ->  {
            String tempUN = userNameText.getText();
            String tempEM = emailField.getText();
            int tempID = users.size();
            boolean createAcc = true;

            User tempUser = new User(fNameText.getText(), lNameText.getText(), userNameText.getText(),
                    passFieldReg.getText(), tempID, phoneText.getText(), emailField.getText(), false );


            for (int i = 0; i < users.size(); i++) {
                if (fNameText.getText().equals("") || lNameText.getText().equals("")  || userNameText.getText().equals("")
                        || passFieldReg.getText().equals("") || phoneText.getText().equals("") ||
                        emailField.getText().equals("")) {
                    System.out.println("Please fill all fields");
                    createAcc = false;
                    break;
                }
                else if (tempUN.equals(users.get(i).getUserName())) {
                    System.out.println("UserName Already taken");
                    createAcc = false;
                    break;
                }
                else if (tempEM.equals(users.get(i).getEmailID())) {
                    System.out.println("Email Already in Use");
                    createAcc = false;
                    break;
                }
            }
            if (createAcc) {
                users.add(tempUser);
            }
        });


        //more graphics things
        frame.add(panelCont);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {}

}
