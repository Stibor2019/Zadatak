import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//00:43 sve radi 13.6/ save
public class ZaposleniGui extends JFrame{


    Connection kon;
    ZaposleniGui(Connection kon){
        this.kon = kon;
    }

       public static void main(String[] args) throws SQLException, ClassNotFoundException {

           Class.forName("com.mysql.cj.jdbc.Driver");

           String imeBaza = "zaposleni";
           String korisnikBaza = "root";
           String lopzinkaBaza = "monalisa1984";
           Connection kon= DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/"+imeBaza, korisnikBaza, lopzinkaBaza);

        JFrame menuFrame =  new JFrame();
        menuFrame.setSize(1200,800);
        menuFrame.setBackground(new Color(255,150,150));
        menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuFrame.setLayout(null);
        menuFrame.setVisible(true);
        menuFrame.getContentPane().setBackground(new Color(255,100,100));
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setVisible(true);
        contentPane.setLayout(null);

        JLabel welcomeLabel = new JLabel("Baza Podataka Zaposlenih");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        welcomeLabel.setBounds(250,50,800,50);

        menuFrame.add(welcomeLabel);

        JButton prikazzaposleni = new JButton("Prikaz");
        prikazzaposleni.setBounds(400, 200, 300, 40);
        prikazzaposleni.setBackground(Color.pink);
        prikazzaposleni.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        prikazzaposleni.setFocusPainted(false);
        prikazzaposleni.addActionListener(actionEvent -> {
            try {
                new Prikaz(kon);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        menuFrame.add(prikazzaposleni);

        JButton dodatizaposleni = new JButton("Dodati");
        dodatizaposleni.setBounds(400, 270, 300, 40);
        dodatizaposleni.setBackground(Color.pink);
        dodatizaposleni.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        dodatizaposleni.setFocusPainted(false);
        dodatizaposleni.addActionListener(actionEvent -> {
            try {
                new Dodati(kon);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
        menuFrame.add(dodatizaposleni);

        JButton updatezaposleni = new JButton("Update ");
        updatezaposleni.setBounds(400, 340, 300, 40);
        updatezaposleni.setBackground(Color.pink);
        updatezaposleni.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        updatezaposleni.setFocusPainted(false);
        updatezaposleni.addActionListener(updateEvent -> {
            new Updates(kon);
        });
        menuFrame.add(updatezaposleni);


        JButton izbrisatizaposleni = new JButton("Izbrisati");
        izbrisatizaposleni.setBounds(400, 410, 300, 40);
        izbrisatizaposleni.setBackground(Color.pink);
        izbrisatizaposleni.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        izbrisatizaposleni.setFocusPainted(false);
        izbrisatizaposleni.addActionListener(deleteEvent -> {
            new Brisanje(kon);
        });
        menuFrame.add(izbrisatizaposleni);

           JButton izlaz = new JButton("Izlaz");
           izlaz.setBounds(400, 480, 300, 40);
           izlaz.setBackground(Color.pink);
           izlaz.setFont(new Font("Times New Roman", Font.PLAIN, 15));
           izlaz.setFocusPainted(false);

           izlaz.addActionListener(actionEvent -> {
               menuFrame.dispose();
           });
           menuFrame.add(izlaz);}}

