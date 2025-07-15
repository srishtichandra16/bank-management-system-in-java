package bank.mangment.system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField aadharTextField,panTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JDateChooser dateChooser; // Declare it as an instance variable
    JComboBox religion,category,occupation,education,income;
    String formno;

    SignupTwo(String formno) {
          this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additinalDetails = new JLabel("Page 2: Additional Details");
        additinalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additinalDetails.setBounds(290, 80, 400, 30);
        add(additinalDetails);

        JLabel religionlabel = new JLabel("Religion:");
        religionlabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionlabel.setBounds(100, 140, 100, 30);
        add(religionlabel);

        String valReligion[] = {"Hindu","Muslim","Sikh","Christan","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String valCategory[] = {"General","OBC","ST","SC","Other"};
         category = new JComboBox(valCategory);
        category.setBackground(Color.white);
        category.setBounds(300, 190, 400, 30);
        add(category);

        JLabel incomelable = new JLabel("Income:");
        incomelable.setFont(new Font("Raleway", Font.BOLD, 20));
        incomelable.setBounds(100, 240, 200, 30);
        add(incomelable);

        String incomeCategory[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBackground(Color.white);
        income.setBounds(300, 240, 400, 30);
        add(income);

        JLabel edu = new JLabel("Educational:");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);


        JLabel qual = new JLabel("Qualification:");
       qual.setFont(new Font("Raleway", Font.BOLD, 20));
        qual.setBounds(100, 315, 200, 30);
        add(qual);


        String educatioValues[] = {"Non Graduation","Graduation","Post Graduation","Doctrate","Others"};
        education = new JComboBox(educatioValues);
       education.setBackground(Color.white);
        education.setBounds(300, 315, 400, 30);
        add(education);


        JLabel occ = new JLabel("Occupation:");
       occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(100, 390, 200, 30);
        add(occ);


        String occupationValues[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBackground(Color.white);
        occupation.setBounds(300, 390, 400, 30);
        add(occupation);


        JLabel pan = new JLabel("Pan Number:");
       pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panTextField = new JTextField("");
        panTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField("");
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);

        JLabel seniorC = new JLabel("Senior Citizen");
        seniorC.setFont(new Font("Raleway", Font.BOLD, 20));
       seniorC.setBounds(100, 540, 200, 30);
        add(seniorC);


        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);

        sno = new JRadioButton("No");
        sno.setBackground(Color.white);
        sno.setBounds(450, 540, 100, 30);
        add(syes);
        add(sno);

        ButtonGroup seniorCGroup = new ButtonGroup();
        seniorCGroup.add(syes);
        seniorCGroup.add(sno);

        JLabel account = new JLabel("Existing account");
        account.setFont(new Font("Raleway", Font.BOLD, 20));
        account.setBounds(100, 590, 200, 30);
        add(account);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);

        eno = new JRadioButton("No");
        eno.setBackground(Color.white);
        eno.setBounds(450, 590, 100, 30);
        add(eyes);
        add(eno);

        ButtonGroup accountGroup = new ButtonGroup();
       accountGroup.add(eyes);
        accountGroup.add(eno);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);

        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String formno = "",random;
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome= (String)category.getSelectedItem();
        String sedu= (String)education.getSelectedItem();
        String soccupation= (String)occupation.getSelectedItem();
        String seniorcitizen =null;
        if(syes.isSelected()) {
            seniorcitizen = "Yes";
        }
        else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        String saccount = null;

        if(eno.isSelected()){
            saccount = "Yes";
        }
        else if(eno.isSelected()){
            saccount = "No";
        }
        String span = panTextField.getText();
        String saadar = aadharTextField.getText();

        try{
                Conn c = new Conn();
                String query ="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+sedu+"','"+soccupation+"','"+span+"','"+saadar+"','"+seniorcitizen+"','"+saccount+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);

        } catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
