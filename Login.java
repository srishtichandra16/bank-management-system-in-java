package bank.mangment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login  extends JFrame implements ActionListener {
    JButton login, clear,signup;
    JTextField cardTextFeild;
    JPasswordField pinTextFeild;
        Login(){
            super("Bank managment System");
            setLayout(null);
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
            Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(70,10,100,100);
            add(label);

            JLabel text = new JLabel(("Welcome to ATM"));
            text.setFont(new Font("osward",Font.BOLD,38));
            text.setBounds(200,40,400,40);
            add(text);

            JLabel cardno = new JLabel(("Card NO:"));
            cardno.setFont(new Font("Raleway",Font.BOLD,28));
            cardno.setBounds(120,150,230,30);
            add(cardno);

            cardTextFeild = new JTextField();
            cardTextFeild.setBounds(300,150,230,30);
            cardTextFeild.setFont(new Font("Arial",Font.BOLD,14));
            add(cardTextFeild);

            JLabel pin = new JLabel(("PIN:"));
            pin.setFont(new Font("osward",Font.BOLD,28));
            pin.setBounds(120,220,230,30);
            add(pin);

            pinTextFeild = new JPasswordField();
            pinTextFeild.setBounds(300,220,230,30);
            pinTextFeild.setFont(new Font("Arial",Font.BOLD,14));
            add(pinTextFeild);

            login =new JButton(("SIGN IN"));
            login.setBounds(300,300,100,30);
            login.setBackground(Color.black);
            login.setForeground(Color.white);
            login.addActionListener(this);
            add(login);

            clear =new JButton(("CLEAR"));
            clear.setBounds(430,300,100,30);
            clear.setBackground(Color.black);
            clear.setForeground(Color.white);
            clear.addActionListener(this);
            add(clear);

            signup =new JButton(("SIGN UP"));
            signup.setBounds(300,350,230,30);
            signup.setBackground(Color.black);
            signup.setForeground(Color.white);
            signup.addActionListener(this);
            add(signup);

            getContentPane().setBackground(Color.white);

            setSize(800,480);
            setLocation(450 ,200);

            setVisible(true);

        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==clear){
                cardTextFeild.setText("");
                pinTextFeild.setText("");

               }
          else if(ae.getSource()==login){
              Conn conn = new Conn();
              String cardnumber = cardTextFeild.getText();
              String pinnumber = pinTextFeild.getText();
              String query = "select * from login where cardnumber = '"+cardnumber+"'and pin ='"+pinnumber+"'";
              try{
                 ResultSet rs = conn.s.executeQuery(query);
                 if(rs.next()){
                     setVisible(false);
                     new Transaction(pinnumber).setVisible(true);
                 }
                 else {
                     JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                 }
              }
              catch (Exception e){
                  System.out.println(e);
              }
            }
          else if(ae.getSource()==signup){
                  setVisible(false);
                  new SignupOne().setVisible(true);
               }

        }

        public static void main(String[] args) {
            new Login();
        }
    }



