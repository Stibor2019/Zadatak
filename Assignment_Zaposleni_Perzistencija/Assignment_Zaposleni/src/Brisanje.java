import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Brisanje {
 Connection kon;
    JFrame menuFrame = new JFrame();




    public  Brisanje(Connection kon){
    this.kon = kon;
    JFrame frame = new JFrame("Izbrisati Zaposlene");
     menuFrame.setVisible(false);
    JLabel label = new JLabel("Unijeti ID zaposlenog");
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
            }
        }
    });

    JButton nazad = new JButton("Nazad");
    nazad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    nazad.setBounds(275, 400, 150,40);
    nazad.setFocusPainted(false);
    nazad.setBackground(new Color(255,100,100));
    nazad.addActionListener(actionListener -> {
        menuFrame.setVisible(true);
        frame.dispose();

    });
    frame.add(nazad);

    JButton izbrisati = new JButton("Izbrisati");
    izbrisati.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    izbrisati.setBounds(525, 400, 150,40);
    izbrisati.setFocusPainted(false);
    izbrisati.setBackground(new Color(255,100,100));

    izbrisati.addActionListener(actionEvent -> {
        int zaposleni_id = Integer.parseInt(unosID.getText());
        String q = String.format("select * from zaposleni_tabela where zaposleni_id = %d;", zaposleni_id);
         Statement statement;

        try {
            statement = kon.createStatement();
            ResultSet resultSet = statement.executeQuery(q);
            if (resultSet.next()) {
                System.out.println(resultSet.getString(2));


                String deleteQuery = String.format("delete from zaposleni_tabela where zaposleni_id = %d;",zaposleni_id);
                statement.executeUpdate(deleteQuery);
                menuFrame.setVisible(true);
                frame.dispose();

            }
            else{
                JFrame popup = new JFrame("Pogrešan ID");
                JLabel popupMsg = new JLabel("ID koji je unijet je pogrešan.");
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

    frame.add(izbrisati);frame.getContentPane().setBackground( new Color(255,150,150) );
    frame.setLayout(null);
    frame.setSize(new Dimension(1100,750));
    frame.setVisible(true);
}

}
