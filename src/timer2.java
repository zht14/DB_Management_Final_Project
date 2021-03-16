
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class timer2 extends javax.swing.JFrame {

	private JPanel contentPane;

	int sec, min, hour;
	int sec1, min1, hour1;
	Timer timer;
	JLabel secondLabel, minuteLabel, hourLabel;
	JButton startButton;
	JComboBox cbMinutes, cbHour, cbSeconds;
	
	boolean flag = true;
	boolean ifStop = false;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timer2 frame = new timer2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public timer2() {
		addWindowListener(new WindowAdapter() {
			@Override
			public synchronized void windowClosed(WindowEvent e) {
			}
		});
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new java.awt.Color(44, 62, 80));
		
		hourLabel = new JLabel("0");
		hourLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		hourLabel.setBounds(96, 54, 34, 29);
		hourLabel.setForeground(Color.WHITE);
		contentPane.add(hourLabel);
		
		
		minuteLabel = new JLabel("0");
		minuteLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		minuteLabel.setBounds(197, 54, 34, 29);
		minuteLabel.setForeground(Color.WHITE);
		contentPane.add(minuteLabel);
		
		secondLabel = new JLabel("0");
		secondLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		secondLabel.setBounds(295, 54, 34, 29);
		secondLabel.setForeground(Color.WHITE);
		contentPane.add(secondLabel);
		
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Times New Roman", Font.BOLD, 24));
		label.setBounds(142, 54, 16, 29);
		label.setForeground(Color.WHITE);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		label_1.setBounds(256, 54, 16, 29);
		label_1.setForeground(Color.WHITE);
		contentPane.add(label_1);
		
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				btnStartActionPerformed(e);
			}
		});

		
		startButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		startButton.setBounds(20, 152, 117, 29);
		
		contentPane.add(startButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(new ActionListener() {
			public  synchronized void actionPerformed(ActionEvent e) {
				startButton.setVisible(true);
				sec1 = sec;
				min1 = min;
				hour1 = hour;
				ifStop = true;
				timer.stop();
				
			}
		});
		stopButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		stopButton.setBounds(149, 152, 117, 29);
		contentPane.add(stopButton);
		
		cbHour = new JComboBox();

		cbHour.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cbHour.setBounds(73, 107, 74, 33);
		contentPane.add(cbHour);
		
		JComboBox cbSeconds = new JComboBox();
		cbSeconds.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cbSeconds.setBounds(267, 109, 70, 29);
		contentPane.add(cbSeconds);
		
		JComboBox cbMinutes = new JComboBox();
		cbMinutes.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cbMinutes.setBounds(168, 106, 74, 34);
		contentPane.add(cbMinutes);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				try {
					timer.stop();
				}catch(Exception ex) {}
				
				startButton.setVisible(true);
				minuteLabel.setText("0");
				secondLabel.setText("0");
				hourLabel.setText("0");
				min = 0;
				sec = 0;
				hour = 0;
				min1 = 0;
				sec1 = 0;
				hour1 = 0;
				cbHour.setSelectedIndex(0); 
				cbMinutes.setSelectedIndex(0); 
				cbSeconds.setSelectedIndex(0); 
				minuteLabel.setForeground(Color.WHITE);
				secondLabel.setForeground(Color.WHITE);
				hourLabel.setForeground(Color.WHITE);
			}
		});
		resetButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		resetButton.setBounds(277, 152, 117, 29);
		contentPane.add(resetButton);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHours.setBounds(73, 84, 61, 16);
		lblHours.setForeground(Color.WHITE);
		contentPane.add(lblHours);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMinutes.setBounds(168, 84, 72, 16);
		lblMinutes.setForeground(Color.WHITE);
		contentPane.add(lblMinutes);
		
		JLabel lblSeconds = new JLabel("Seconds");
		lblSeconds.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSeconds.setBounds(268, 84, 80, 16);
		lblSeconds.setForeground(Color.WHITE);
		contentPane.add(lblSeconds);
		
		for(int i = 0; i <60; i++) {
			
			cbMinutes.addItem(i);
		}
		
		for(int i = 0; i <100; i++) {
			cbHour.addItem(i);
		}
		
		for(int i = 0; i <60; i++) {
			cbSeconds.addItem(i);
		}
		

		

		
		
		cbHour.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				hourLabel.setText(cbHour.getSelectedItem().toString());
				hour = Integer.parseInt(hourLabel.getText());
			}
		});
		
		cbMinutes.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				minuteLabel.setText(cbMinutes.getSelectedItem().toString());
				min = Integer.parseInt(minuteLabel.getText());
			}
		});
		
		cbSeconds.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				secondLabel.setText(cbSeconds.getSelectedItem().toString());
				sec = Integer.parseInt(secondLabel.getText());
				
			}
		});
		
		
		
	}
	
	public synchronized void btnStartActionPerformed(java.awt.event.ActionEvent evt) {	
		startButton.setVisible(false);
		timer = new Timer(1000, new ActionListener() {
		
		@Override
		public synchronized void actionPerformed(ActionEvent e) {
			

			if(ifStop) {
				sec1 = sec;
				min1 = min;
				hour1 = hour;
				ifStop = false;
			}

			if(sec == 0) {
				if(sec == 0 && min == 0 && hour ==0) {
					JOptionPane.showMessageDialog(rootPane,  "Times Up!", "Stopped", 0);
					timer.stop();

					hour = 0;
					min = 0;
					sec = 0;

					hourLabel.setText(""+ hour);
					minuteLabel.setText(""+ min);
					secondLabel.setText(""+ sec);

					return;


				}
					
				if(min == 0 && hour > 0) {
					min = 59;
					sec = 60;
					sec--;
					hour--;
					hourLabel.setText(""+ hour);
					minuteLabel.setText(""+ min);
					secondLabel.setText(""+ sec);

				}
				else {
					sec = 59;
					min--;
					if( min == 0 && hour ==0) {
					minuteLabel.setForeground(Color.RED);
					secondLabel.setForeground(Color.RED);
					hourLabel.setForeground(Color.RED);
					}
					hourLabel.setText(""+ hour);
					minuteLabel.setText(""+ min);
					secondLabel.setText(""+ sec);
				}
				
			}
			else {
			
				sec--;
				hourLabel.setText(""+ hour);
				minuteLabel.setText(""+ min);
				secondLabel.setText(""+ sec);

			}
		}
		});
		timer.start();
	}
}
