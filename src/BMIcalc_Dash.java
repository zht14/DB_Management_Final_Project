
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class BMIcalc_Dash extends javax.swing.JFrame implements ActionListener
{
    private JFrame frame;
    private JLabel heightLabel;
    private JLabel weightLabel;
    private JTextField heightText;
    private JTextField weightText;
    private JTextArea showBMI;
    private JButton btnCalculate;
    private JPanel panel_1;
    private JLabel close;
    private JPanel panel_2;
    private JLabel minimize;
    private JPanel panel_3;
    private JButton btnUnitC1;
    private JButton btnUnitC2;
    private JLabel title;

    public BMIcalc_Dash()
    {
        initialize();
        showBMI.setVisible(false);
        frame.setVisible(true);

    }

    private void initialize()
    {
        frame = new JFrame("BMI Calculator Emulator");
        frame.setLocationRelativeTo(null);

        frame.setUndecorated(true);




        heightLabel = new JLabel("Height(cm): ", JLabel.LEFT);
        heightLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        heightLabel.setForeground(new java.awt.Color(255, 255, 255));

        weightLabel = new JLabel("Weight(kg): ", JLabel.LEFT);
        weightLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        weightLabel.setForeground(new java.awt.Color(255, 255, 255));

        heightText = new JTextField(16);
        heightText.setBackground(new java.awt.Color(108, 122, 137));
        heightText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        heightText.setForeground(new java.awt.Color(228, 241, 254));

        weightText = new JTextField(16);
        weightText.setBackground(new java.awt.Color(108, 122, 137));
        weightText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        weightText.setForeground(new java.awt.Color(228, 241, 254));

        btnCalculate =  new JButton("Calculate BMI");
        btnCalculate.setBackground(new java.awt.Color(192, 57, 43));
        btnCalculate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCalculate.setForeground(new java.awt.Color(255, 255, 255));
        btnCalculate.addActionListener(this);

        btnUnitC1 =  new JButton("FEET TO CM");
        btnUnitC1.setBackground(new java.awt.Color(192, 57, 43));
        btnUnitC1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnUnitC1.setForeground(new java.awt.Color(255, 255, 255));
        btnUnitC1.addActionListener(this);

        btnUnitC2 =  new JButton("LBS TO KG");
        btnUnitC2.setBackground(new java.awt.Color(192, 57, 43));
        btnUnitC2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnUnitC2.setForeground(new java.awt.Color(255, 255, 255));
        btnUnitC2.addActionListener(this);


        title = new JLabel(" BMI Calculator", JLabel.LEFT);
        title.setBackground(Color.RED);
        title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));

        close = new JLabel("  X",JLabel.RIGHT);
        close.setBackground(Color.RED);
        close.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                //System.exit(0);
                //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                frame.setVisible(false);

            }
        });

        minimize = new JLabel("-", JLabel.RIGHT);
        minimize.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        minimize.setForeground(new java.awt.Color(255, 255, 255));
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                //DashBoard DB = new DashBoard();
                frame.setState(javax.swing.JFrame.ICONIFIED);

            }
        });

        panel_1 = new JPanel(new BorderLayout());
        panel_1.setBackground(new java.awt.Color(248, 148, 6));

        panel_1.add(title,BorderLayout.LINE_START);
        panel_1.add(minimize, BorderLayout.CENTER);
        panel_1.add(close,BorderLayout.LINE_END);




        showBMI = new JTextArea();
        showBMI.setBackground(new java.awt.Color(108, 122, 137));
        showBMI.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        showBMI.setForeground(new java.awt.Color(228, 241, 254));





        frame.add(panel_1, BorderLayout.NORTH);

        panel_2 = new JPanel();
        //panel_2.setBackground(new java.awt.Color(248, 148, 6));
        panel_2.setBackground(new java.awt.Color(44, 62, 80));

        panel_2.add(heightLabel);
        panel_2.add(heightText);
        panel_2.add(btnUnitC1);
        panel_2.add(weightLabel);
        panel_2.add(weightText);
        panel_2.add(btnUnitC2);
        panel_2.add(btnCalculate);





        frame.add(panel_2, BorderLayout.CENTER);

        panel_3 = new JPanel();
        //panel_3.setBackground(new java.awt.Color(248, 148, 6));
        panel_3.add(showBMI);
        panel_3.setBackground(new java.awt.Color(44, 62, 80));

        frame.add(panel_3, BorderLayout.SOUTH);





        frame.setBounds(100, 100, 350, 350);



        pack();

    }

    public void actionPerformed(ActionEvent e)
    {
        int i = 1;
        if(e.getSource() == btnUnitC1)
        {
            BMI_Calculator BC = new BMI_Calculator();
            String CM = BC.convertFEET(heightText.getText());
            heightText.setText(CM);
            btnUnitC1.setVisible(false);


        }
        else if(e.getSource() == btnUnitC2)
        {

            BMI_Calculator BC = new BMI_Calculator();
            String KG = BC.convertLBS(weightText.getText());
            weightText.setText(KG);
            btnUnitC2.setVisible(false);
        }
        else if(e.getSource() == btnCalculate)
        {
            String h = heightText.getText();
            String w = weightText.getText();
            BMI_Calculator BC = new BMI_Calculator(h, w);
            String emulator_result = BC.BMI_Calculate();
            showBMI.setVisible(true);
            showBMI.setText("");
            //showBMI.setText("BMI: "+emulator_result);
            showBMI.setText("Heights: "+h+" cm\n" +"Weights: "+w+" kg\n"+"BMI: "+emulator_result);
            btnUnitC2.setVisible(true);
            btnUnitC1.setVisible(true);

            weightText.setText("");
            heightText.setText("");

        }




    }

}