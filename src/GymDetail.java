//package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GymDetail {

    public GymDetail(int id) {
        String name = null;
        String price_per_month = null;
        String status = null;
        String score = null;
        String type = null;
        String picture = null;

        JFrame frame = new JFrame("Gym Information");
        JLabel nameLabel = new JLabel();
        JPanel panelLayer = new JPanel();
        JLabel jLabelClose = new javax.swing.JLabel();
        JLabel jLabelMinimize = new javax.swing.JLabel();
        JLabel statusLabel = new JLabel();
        JLabel scoreLabel = new JLabel();
        JLabel priceLabel = new JLabel();
        JLabel typeLabel= new JLabel();
        JLabel pictureLabel = new JLabel();
        JLabel equpment = new JLabel("Equipments:");
        JPanel panel = new JPanel();
        Container contentPane1 = frame.getContentPane();
        ConnectionManager cmanager = new ConnectionManager();
        Connection conn = cmanager.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM gym WHERE gym_id = " + id + ";";
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            name = rs.getString(2);
            nameLabel.setText(name);

            price_per_month = rs.getString(3);
            priceLabel.setText(price_per_month + "$/ month");


            status = rs.getString(4);
            if(status.equals("Open")) {
                statusLabel.setIcon(new ImageIcon(new URL("https://ftp.bmp.ovh/imgs/2021/04/460a2050b040001b.png"), "open"));
            }
            else {
                statusLabel.setIcon(new ImageIcon(new URL("https://ftp.bmp.ovh/imgs/2021/04/f06f55a916347867.png"), "closed"));
            }

            score = rs.getString(5);
            scoreLabel.setText(score + "/ 5.0");

            picture = rs.getString(6);
            pictureLabel.setIcon(new ImageIcon(new URL(picture)));

            type = rs.getString(7);
            typeLabel.setText(type);

            SQL = "SELECT e.url FROM gym_equipment g JOIN equipment e WHERE g.equipment_id = e.equipment_id AND g.gym_id = " + id + ";";
            rs = stmt.executeQuery(SQL);
            int t = 0;
            while(rs.next()) {
                String equipmentURL = rs.getString(1);
                JLabel e = new JLabel();
                e.setIcon(new ImageIcon(new URL(equipmentURL)));
                e.setBounds( 20 + t * 50, 580, 50, 50);
                panel.add(e);
                t++;
            }

            SQL = "SELECT * FROM address a JOIN gym_address g WHERE a.address_id = g.address_id AND g.gym_id = " + id + ";";
            rs = stmt.executeQuery(SQL);
            int t2 = 0;
            while(rs.next()) {
                String address;
                JLabel addressLabel = new JLabel(rs.getString(2) + rs.getString(3));
                addressLabel.setBounds(25, 680 + t2 * 30, 1000, 30);
                addressLabel.setFont(new java.awt.Font(null, 1, 23));
                panel.add(addressLabel);
                t2++;
            }

            rs.close();
            stmt.close();
            conn.close();
        }

        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        panelLayer.setBounds(0, 0, 1020, 55);
        panelLayer.setBackground(new java.awt.Color(44, 62, 80));
        panelLayer.setLayout(null);
        jLabelMinimize.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinimize.setText("-");
        jLabelMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.setState(javax.swing.JFrame.ICONIFIED);
            }
        });
        jLabelMinimize.setBounds(920,0,50,50);
        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("X");
        jLabelClose.setBounds(970,0,50,50);
        jLabelClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
            }
        });
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelLayer.add(jLabelClose);
        panelLayer.add(jLabelMinimize);
        JLabel add = new JLabel("Address:");
        nameLabel.setFont(new java.awt.Font(null, 1, 32));
        nameLabel.setBounds(15, 5, 1000, 50);
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        statusLabel.setBounds(25, 75, 109, 99);
        scoreLabel.setBounds(25, 185, 150, 30);
        priceLabel.setBounds(25, 245, 150, 30);
        typeLabel.setBounds(25, 280, 150, 30);
        pictureLabel.setBounds(25, 335, 500, 200);
        equpment.setBounds(25, 550, 150, 30);
        add.setBounds(25, 640, 150, 30);
        scoreLabel.setFont(new java.awt.Font(null, 1, 29));
        priceLabel.setFont(new java.awt.Font(null, 1, 21));
        typeLabel.setFont(new java.awt.Font(null, 1, 18));
        equpment.setFont(new java.awt.Font(null, 1, 18));
        add.setFont(new java.awt.Font(null, 1, 21));
        panel.setLayout(null);
        frame.setSize(1019, 899);
        nameLabel.setBackground(new java.awt.Color(44, 62, 80));
        statusLabel.setBackground(new java.awt.Color(44, 62, 80));
        scoreLabel.setBackground(new java.awt.Color(44, 62, 80));
        priceLabel.setBackground(new java.awt.Color(44, 62, 80));
        typeLabel.setBackground(new java.awt.Color(44, 62, 80));
        add.setBackground(new java.awt.Color(44, 62, 80));
        panel.add(nameLabel);
        panel.add(statusLabel);
        panel.add(scoreLabel);
        panel.add(priceLabel);
        panel.add(typeLabel);
        panel.add(pictureLabel);
        panel.add(equpment);
        panel.add(add);
        panel.add(panelLayer);
        panel.setBackground(new java.awt.Color(248, 148, 6));
        panel.setPreferredSize(new Dimension(1000,900));
        JScrollPane js = new JScrollPane();
        js.setBounds(0, 0, 1020, 900);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        js.setViewportView(panel);
        //js.setBackground(Color.ORANGE);
        //js.setLayout(null);
        contentPane1.setLayout(null);
        contentPane1.add(js);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
