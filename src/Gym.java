//package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Gym extends javax.swing.JFrame {
    boolean isDraging;
    int xx;
    int yy;
    public void initComponents() {
        String[] names = new String[1];
        int[] id = new int[1];
        JFrame frame = new JFrame("Gym");
        JLabel label = new JLabel("Gyms:");
        JPanel panelLayer = new JPanel();
        DefaultListModel dlm = new DefaultListModel();
        JList list1 = new JList();
        JLabel jLabelClose = new javax.swing.JLabel();
        JLabel jLabelMinimize = new javax.swing.JLabel();
        JScrollPane scrollPane = new JScrollPane(list1);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        list1.setBackground(Color.ORANGE);
        ConnectionManager cmanager = new ConnectionManager();
        Connection conn = cmanager.getConnection();
        try {
            int t = 0;
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM gym";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()) {
                t++;
            }
            rs = stmt.executeQuery(SQL);
            names = new String[t];
            id = new int[t];
            t = 0;
            while(rs.next()) {
                dlm.addElement(rs.getString(2));
                names[t] = rs.getString(2);
                id[t] = rs.getInt(1);
                t++;
            }
            list1.setModel(dlm);
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        Container contentPane = frame.getContentPane();
        contentPane.setBackground(new java.awt.Color(248, 148, 6));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        String[] finalNames = names;
        int[] finalId = id;
        list1.addMouseListener(new MouseAdapter() {
                                   @Override
                                   public void mouseClicked(MouseEvent e) {
                                       String name = list1.getSelectedValue().toString();
                                       int gymId = -1;
                                       for(int t = 0; t < finalNames.length; t++){
                                           if(finalNames[t].equals(name)) {
                                               gymId = finalId[t];
                                           }
                                       }
                                       new GymDetail(gymId);
                                   }
                               }
        );
        contentPane.setLayout(null);
        panelLayer.setBounds(0, 0, 500, 55);
        panelLayer.setBackground(new java.awt.Color(44, 62, 80));
        panelLayer.setLayout(null);
        contentPane.add(panelLayer);
        jLabelMinimize.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinimize.setText("-");
        jLabelMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.setState(javax.swing.JFrame.ICONIFIED);
            }
        });
        jLabelMinimize.setBounds(400,0,50,50);
        label.setFont(new java.awt.Font(null, 1, 42));
        label.setForeground(new java.awt.Color(255, 255, 255));
        scrollPane.setBounds(50,70,300,300);
        scrollPane.setBackground(Color.ORANGE);
        list1.setFont(new java.awt.Font(null, 1, 21));
        label.setBounds(15,5,300,50);
        contentPane.add(scrollPane);
        panelLayer.add(label);
        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("X");
        jLabelClose.setBounds(450,0,50,50);
        jLabelClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
            }
        });
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelLayer.add(jLabelClose);
        panelLayer.add(jLabelMinimize);
        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                isDraging = true;
                xx = e.getX();
                yy = e.getY();
                System.out.println(xx+" "+ yy);
            }
            public void mouseReleased(MouseEvent e) {
                isDraging = false;
            }
        });
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isDraging) {
                    int left = getLocation().x;
                    int top = getLocation().y;
                    System.out.println(left + e.getX() - xx);
                    frame.setLocation(left + e.getX() - xx, top + e.getY() - yy);
            }
        }
        });

        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


}
