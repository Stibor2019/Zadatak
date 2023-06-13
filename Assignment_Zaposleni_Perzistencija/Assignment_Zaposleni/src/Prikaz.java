import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;

public class Prikaz{
    JFrame menuFrame = new JFrame();
    Connection kon;
    public Prikaz(Connection kon) throws SQLException {


        menuFrame.setVisible(false);

        JFrame frame=new JFrame("Zaposleni prikaz");
        JPanel panel=new JPanel();

        Statement statement = kon.createStatement();
        String upit = "select * from zaposleni_tabela";
        ResultSet resultSet = statement.executeQuery(upit);

        while (resultSet.next()) {
            JPanel zaposlenikartica = new JPanel();

            JLabel labelaID = new JLabel("ID");
            labelaID.setFont(new Font("Times New Roman", Font.PLAIN, 20));


            JLabel unosID = new JLabel(String.valueOf(resultSet.getInt(1)));
            unosID.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel labelaIme = new JLabel("Ime");
            labelaIme.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel unosIme = new JLabel(resultSet.getString(2));
            unosIme.setFont(new Font("Times New Roman", Font.PLAIN, 20));


            JLabel labelaAdresa = new JLabel("Adresa");
            labelaAdresa.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel unosAdresa = new JLabel(resultSet.getString(3));
            unosAdresa.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel labelaGodine = new JLabel("Godine");
            labelaGodine.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel unosGodine = new JLabel(resultSet.getString(4));
            unosGodine.setFont(new Font("Times New Roman", Font.PLAIN, 20));


            JLabel labelaPlata = new JLabel("Plata");
            labelaPlata.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel unosPlata =( new JLabel(resultSet.getString(5)));
            unosPlata.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            zaposlenikartica.add(labelaID);
            zaposlenikartica.add(unosID);
            zaposlenikartica.add(labelaIme);
            zaposlenikartica.add(unosIme);
            zaposlenikartica.add(labelaAdresa);
            zaposlenikartica.add(unosAdresa);
            zaposlenikartica.add(labelaGodine);
            zaposlenikartica.add(unosGodine);
            zaposlenikartica.add(labelaPlata);
            zaposlenikartica.add(unosPlata);

            zaposlenikartica.setSize(800, 400);
            zaposlenikartica.setBackground(new Color(255,150,150));
            zaposlenikartica.setBorder(new EmptyBorder(20, 50, 20, 50));
            GridLayout cardLayout = new GridLayout(0, 2);
            cardLayout.setHgap(5);
            cardLayout.setVgap(10);
            zaposlenikartica.setLayout(cardLayout);
            panel.add(zaposlenikartica);
        }

        JPanel buttonPanel = new JPanel();
        JButton nazad = new JButton("Nazad");
        nazad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        nazad.setBounds(450, 30, 200,50);
        nazad.setFocusPainted(false);

        nazad.addActionListener(actionListener -> {
            frame.dispose();
            menuFrame.setVisible(true);
        });
        buttonPanel.add(nazad);
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(new Color(255,100, 100));
        panel.add(buttonPanel);

        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(30);
        panel.setLayout(layout);
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(new EmptyBorder(50, 0, 50, 0));

        JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1100,750));
        frame.pack();
        frame.setVisible(true);


    }}
