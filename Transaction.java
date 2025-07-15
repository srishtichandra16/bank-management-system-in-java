package bank.mangment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit,withdrawl,ministatement,pinchnage,balanceenquiry,fastCash,exit;
   String pinnumber;
    Transaction(String pinnumber){
        setLayout(null);
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);


        deposit = new JButton("Deposit");
       deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
       image.add(deposit);


         withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
       image.add(withdrawl);

         fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

         ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);


         pinchnage = new JButton("Pin Change");
        pinchnage.setBounds(170,485,150,30);
        pinchnage.addActionListener(this);
        image.add(pinchnage);

         balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

         exit = new JButton("Exist");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

         setSize(900,900);
         setLocation(300,0);
        setUndecorated(true);
         setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
           if(ae.getSource()==exit){
                  System.exit(0);
           }
           else if(ae.getSource()==deposit){
               setVisible(false);
               new Deposit(pinnumber).setVisible(true);

           }
           else if(ae.getSource()==withdrawl){
               setVisible(false);
               new Withdrawl(pinnumber).setVisible(true);
           }
           else if(ae.getSource()==fastCash){
               setVisible(false);
               new FastCash(pinnumber).setVisible(true);
           }
           else if(ae.getSource()==pinchnage){
               setVisible(false);
               new PinChange(pinnumber).setVisible(true);
           }
           else if(ae.getSource()==balanceenquiry){
               setVisible(false);
               new BalanceEnquiry(pinnumber).setVisible(true);
           }
           else if(ae.getSource()==ministatement){
               new MiniStatement(pinnumber).setVisible(true);
           }
    }
    public static void main(String[] args) {
         new Transaction("");
    }
}
