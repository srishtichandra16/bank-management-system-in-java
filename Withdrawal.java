package bank.mangment.system;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Withdrawal extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;

    Withdrawal(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText().trim();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                return;
            }

            int withdrawAmount;
            try {
                withdrawAmount = Integer.parseInt(number);
                if (withdrawAmount <= 0) {
                    JOptionPane.showMessageDialog(null, "Enter a valid positive amount");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid amount entered");
                return;
            }

            try {
                Conn conn = new Conn();

                // Calculate current balance
                ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    String type = rs.getString("type");
                    String amtStr = rs.getString("amount");

                    if (amtStr != null && !amtStr.trim().isEmpty()) {
                        int amt = Integer.parseInt(amtStr.trim());
                        if (type.equalsIgnoreCase("deposit")) {
                            balance += amt;
                        } else if (type.equalsIgnoreCase("withdrawl")) {
                            balance -= amt;
                        }
                    }
                }

                if (withdrawAmount > balance) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                } else {
                    Date date = new Date();
                    String query = "INSERT INTO bank VALUES('" + pinnumber + "','" + date + "','withdrawl','" + withdrawAmount + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + withdrawAmount + " withdrawn successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while processing withdrawal");
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
