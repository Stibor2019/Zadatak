import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class Dodati {
Connection kon;
    JFrame menuFrame = new JFrame();



    public Dodati(Connection kon) throws SQLException {

 this.kon = kon;
        menuFrame.setVisible(false);

        JFrame frame = new JFrame("Unos-Zaposleni");
        JPanel panel = new JPanel();

        JLabel labelaID = new JLabel("Unijeti ID");
        labelaID.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JTextField unosID = new JTextField("");
        unosID.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        unosID.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });

        JLabel labelaIme = new JLabel("Unijeti ime");
        labelaIme.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JTextField unosIme = new JTextField("");
        unosIme.setFont(new Font("Times New Roman", Font.PLAIN, 20));


        JLabel labelaGodine = new JLabel("Unijeti godine");
        labelaGodine.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JTextField unosGodine = new JTextField("");
        unosGodine.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        unosGodine.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
            }
        });


        JLabel labelaAdresa = new JLabel("Unijeti adresu");
        labelaAdresa.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JTextField unosAdresa = new JTextField("");
        unosAdresa.setFont(new Font("Times New Roman", Font.PLAIN, 20));


        JLabel labelaPlata = new JLabel("Unijeti platu(€)");
        labelaPlata.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JTextField unosPlata = new JTextField("");
        unosPlata.setFont(new Font("Times New Roman", Font.PLAIN, 20));



        panel.add(labelaID);
        panel.add(unosID);
        panel.add(labelaIme);
        panel.add(unosIme);
        panel.add(labelaGodine);
        panel.add(unosGodine);
        panel.add(labelaAdresa);
        panel.add(unosAdresa);

        panel.add(labelaPlata);
        panel.add(unosPlata);


        GridLayout cardLayout = new GridLayout(0, 2);
        cardLayout.setHgap(60);
        cardLayout.setVgap(40);
        panel.setLayout(cardLayout);

        panel.setSize(700, 400);
        panel.setBackground(new Color(255, 250, 230));
        panel.setBorder(new EmptyBorder(20, 50, 20, 50));

        JButton nazad = new JButton("Nazad");
        nazad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        nazad.setBounds(250, 30, 200, 50);
        nazad.setBackground(new Color(255, 100, 100));
        nazad.setFocusPainted(false);

        nazad.addActionListener(actionListener -> {
            frame.dispose();
            menuFrame.setVisible(true);
        });
        panel.add(nazad);

        JButton prihvati = new JButton("Prihvati");
        prihvati.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        prihvati.setBounds(400, 200, 300, 4);
        prihvati.setBackground(new Color(255, 100, 100));
        prihvati.setFocusPainted(false);

        prihvati.addActionListener(actionListener -> {

            int zaposleni_id = Integer.parseInt(unosID.getText());
            String zaposleni_ime = unosIme.getText();
            int zaposleni_godine = Integer.parseInt(unosGodine.getText());
            String zaposleni_adresa = unosAdresa.getText();
            String zaposleni_plata =unosPlata.getText();
          
            Statement statement;
            try {
                statement = kon.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
          String upit;
            upit = String.format("insert into zaposleni_tabela values('%d', '%s', '%d', '%s',' %s');",zaposleni_id, zaposleni_ime, zaposleni_godine, zaposleni_adresa, zaposleni_plata);


            try {
                statement.executeUpdate(upit);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            menuFrame.setVisible(true);
            frame.dispose();

        });
        panel.add(prihvati);

        panel.setBackground(new Color(255, 150, 150));
        panel.setBorder(new EmptyBorder(50, 50, 50, 50));

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 500));
        frame.pack();
        frame.setVisible(true);


    }
}

