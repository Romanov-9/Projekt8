import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Projekt {

    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;
    private JButton button1;
    private JPanel a1;
    private JLabel vivod;
    private JTextField textField1;
    private JLabel vivod2;
    private JLabel vivod3;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Sushi");
        frame.setContentPane(new Projekt().a1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550,550);
        frame.setVisible(true);

    }


    public Projekt(){


        button1.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                String selectedItem1 = comboBox1.getItemAt(comboBox1.getSelectedIndex());
                String selectedItem2 = comboBox2.getItemAt(comboBox2.getSelectedIndex());
                String selectedItem3 = comboBox3.getItemAt(comboBox3.getSelectedIndex());

                String cena;
                if (selectedItem3.equals("Nevajag")) {
                    cena = "8";
                } else {
                    cena = "10";
                }
                String sushi = "Jūsu pautījums- " + selectedItem1 + " - " + selectedItem2 + " ar " + selectedItem3;
                vivod.setText(sushi);
                String adres = " Jūsu pasūtījama adrese- " + textField1.getText() + "; ";
                vivod2.setText(adres);
                String cena1 = "Jūsu galēja cena ir- " + cena + " euro";
                vivod3.setText(cena1);

                try {
                    FileWriter writer = new FileWriter("sushi.txt",true);

                    String sushi1 = "Jūsu pautījums- " + selectedItem1 + " - " + selectedItem2 + " ar " + selectedItem3;
                    vivod.setText(sushi);
                    writer.append(sushi);
                    String adres1 = " Jūsu pasūtījama adrese- " + textField1.getText() + "; ";
                    vivod2.setText(adres);
                    writer.append(sushi);
                    String cena2 = "Jūsu galēja cena ir- " + cena + " euro";
                    vivod3.setText(cena1);
                    writer.append(sushi);


                    System.out.print("Data written to the file successfully");
                    writer.close();

                } catch (Exception k) {
                    System.out.print("File error" + k.getMessage());
                }


            }
        });

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String combo[] = {"wakame","uramaki","maki"};
        comboBox1=new JComboBox<>(combo);


        comboBox2=new JComboBox<>();
        comboBox2.addItem("Klasiskie");
        comboBox2.addItem("Kolorado");
        comboBox2.addItem("Cepamie");
        comboBox2.addItem("Kalifornijas");
        comboBox2.addItem("Mexicas");
        comboBox2.addItem("Latvijas");

        comboBox3=new JComboBox<>();
        comboBox3.addItem("unagi");
        comboBox3.addItem("vasabi");
        comboBox3.addItem("kechup");
        comboBox3.addItem("cucumber souce");
        comboBox3.addItem("bbq");
        comboBox3.addItem("Nevajag");

        JOptionPane.showMessageDialog(null,"Šeit jūs sastadīsiaet savu pasutījumu suši restorana");
    }
}