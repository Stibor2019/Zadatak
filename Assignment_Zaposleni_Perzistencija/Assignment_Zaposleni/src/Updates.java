
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class Updates {
           JFrame menuFrame = new JFrame();

           Connection kon;


           public Updates(Connection kon) {
               this.kon = kon;

           JFrame frame = new JFrame("Update Zaposleni");
           menuFrame.setVisible(false);
           frame.getContentPane().setBackground( new Color(255,150,150) );
           JLabel label = new JLabel("Unijeti ID");
           label.setFont(new Font("Times New Roman", Font.BOLD, 20));
           label.setBounds(250,200,200,50);
           frame.add(label);

           JTextField unosID = new JTextField();
           unosID.setFont(new Font("Times New Roman", Font.BOLD, 20));
           unosID.setBounds(500,200,200,50);
           frame.add(unosID);
           unosID.addKeyListener(new KeyAdapter() {
           public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                e.consume();
           }}});

          JButton nazad1 = new JButton("Nazad");
          nazad1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
          nazad1.setBounds(275, 400, 150,40);
          nazad1.setFocusPainted(false);
          nazad1.setBackground(new Color(255,100,100));
          nazad1.addActionListener(actionListener -> {
          menuFrame.setVisible(true);
          frame.dispose();

          });
          frame.add(nazad1);

          JButton prihvati1 = new JButton("Prihvati");
          prihvati1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
          prihvati1.setBounds(525, 400, 150,40);
          prihvati1.setFocusPainted(false);
          prihvati1.setBackground(new Color(255,100,100));
          prihvati1.addActionListener(actionEvent -> {
          int zaposleni_id = Integer.parseInt(unosID.getText());
          String upit = format("select * from zaposleni_tabela  where zaposleni_id = %d;", zaposleni_id);
          Statement statement ;
          try {
          statement=kon.createStatement();
          ResultSet resultSet = statement.executeQuery(upit);
          if (resultSet.next()) {
          System.out.println(resultSet.getString(2));
          editZaposleniHelper(zaposleni_id, frame);

          }
          else{
          JFrame popup = new JFrame("Pogrešan ID");
          JLabel popupMsg = new JLabel("Unijeti ID nije ispravan.");
          popupMsg.setBounds(20,10,300,50);
          popupMsg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
          popup.add(popupMsg);

          JButton button = new JButton("OK");
          button.setBounds(120,60,70,20);
          button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
          button.addActionListener(actionEvent2 -> {
          popup.dispose();
          });
          popup.add(button);

          popup.setLayout(null);
          popup.setSize(350, 150);
          popup.setVisible(true);

          }
          } catch (SQLException throwables) {
            throwables.printStackTrace();
          }
          });

          frame.add(prihvati1);
          frame.setLayout(null);
          frame.setSize(new Dimension(1000,750));
          frame.setBackground(new Color(255,150,150));
          frame.setVisible(true);
          }

          private void editZaposleniHelper(int zaposleni_id, JFrame frame) throws SQLException {


          JFrame  parentFrame = new JFrame("Promjeniti Podatke");
          JPanel panel = new JPanel();
          Statement statement1;
          try {
          statement1 = kon.createStatement();
          String upit1 = format("select * from zaposleni_tabela  where zaposleni_id ='%d';", zaposleni_id);
          ResultSet resultSet = statement1.executeQuery(upit1);
          resultSet.next();

          JLabel labelaIme1 = new JLabel("Ime");
          labelaIme1.setFont(new Font("Times New Roman", Font.PLAIN, 20));


          JTextField unosIme1 = new JTextField(resultSet.getString(2));
          unosIme1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
          unosIme1.setBounds(500,200,200,50);
          parentFrame.add(unosIme1);

           JLabel labelaGodine1 = new JLabel("Godine");
           labelaGodine1.setFont(new Font("Times New Roman", Font.PLAIN, 20));

           JTextField unosGodine1 = new JTextField(resultSet.getString(3));
           unosGodine1.setFont(new Font("Times New Roman", Font.PLAIN, 20));

           JLabel labelaAdresa1 = new JLabel("Adresa");
           labelaAdresa1.setFont(new Font("Times New Roman", Font.PLAIN, 20));

           JTextField unosAdresa1 = new JTextField(resultSet.getString(4));
           unosAdresa1.setFont(new Font("Times New Roman", Font.PLAIN, 20));

           JLabel labelaPlata1 = new JLabel("Plata");
           labelaPlata1.setFont(new Font("Times New Roman", Font.PLAIN, 20));

           JTextField unosPlata1 = new JTextField(resultSet.getString(5));
           unosPlata1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
           unosPlata1.setBounds(500,200,200,50);
           parentFrame.add(unosPlata1);
           unosPlata1.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();

            if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                e.consume();  // if it's not a number, ignore the event
            }

            }
           });

           panel.add(labelaIme1);
           panel.add(unosIme1);
           panel.add(unosGodine1);
           panel.add(labelaGodine1);
           panel.add(unosGodine1);
           panel.add(labelaAdresa1);
           panel.add(unosAdresa1);
           panel.add(labelaPlata1);
           panel.add(unosPlata1);


           GridLayout cardLayout = new GridLayout(0, 2);
           cardLayout.setHgap(60);
           cardLayout.setVgap(40);
           panel.setLayout(cardLayout);

           panel.setSize(800, 450);
           panel.setBackground(new Color(255, 100, 100));
           panel.setBorder(new EmptyBorder(20, 50, 20, 50));

           JButton nazad2 = new JButton("Nazad");
           nazad2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
           nazad2.setBounds(250, 30, 200, 50);
           nazad2.setFocusPainted(false);

           nazad2.addActionListener(actionListener -> {
           parentFrame.dispose();
           menuFrame.setVisible(true);
           });
           panel.add(nazad2);
           JButton prihvati2 = new JButton("Prihvati");
           prihvati2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
           prihvati2.setBounds(250, 30, 200, 50);
           prihvati2.setFocusPainted(false);
           menuFrame.dispose();
           menuFrame.setVisible(true);

           prihvati2.addActionListener(actionListener -> {

           Statement statemnt;
           try {
           statemnt = kon.createStatement();
           } catch (SQLException ex) {
           throw new RuntimeException(ex);
           }

           String zaposleni_ime = unosIme1.getText();
           int zaposleni_godine = Integer.parseInt(unosGodine1.getText());
           String zaposleni_adresa = unosAdresa1.getText();
           String zaposleni_plata = unosPlata1.getText();


           String upit = String.format("update zaposleni_tabela set zaposleni_ime = '%s', zaposleni_godine = '%d', zaposleni_adresa = '%s', " +
                " zaposleni_plata = '%s' where zaposleni_id = %d;", zaposleni_ime, zaposleni_godine, zaposleni_adresa, zaposleni_plata,zaposleni_id);

           try {
           statemnt.executeUpdate(upit);
           } catch (SQLException throwables) {
           throwables.printStackTrace();
           }
           menuFrame.setVisible(true);
           frame.dispose();

           });

           panel.add(prihvati2);

           panel.setBackground(new Color(255,150, 150));
           panel.setBorder(new EmptyBorder(50, 50, 50, 50));
           parentFrame.add(panel);
           parentFrame.setLayout(null);
           parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          parentFrame.setPreferredSize(new Dimension(800, 450));

           parentFrame.setVisible(true);
           parentFrame.pack();
           frame.dispose();
            } catch (Exception e) {
            }}}





