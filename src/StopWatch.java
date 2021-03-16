

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class StopWatch extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StopWatch frame = new StopWatch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	static int milliseconds = 0;
	static int seconds = 0;
	static int minutes = 0;
	static int hours = 0;
	
	static boolean state = true;
	
	/**
	 * Create the frame.
	 */
	public StopWatch() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(44, 62, 80));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Hour = new JLabel("0");
		Hour.setHorizontalAlignment(SwingConstants.RIGHT);
		Hour.setFont(new Font("Times New Roman", Font.PLAIN, 39));
		Hour.setBounds(77, 23, 61, 57);
		Hour.setForeground(Color.WHITE);
		contentPane.add(Hour);
		
		JLabel Minute = new JLabel("0");
		Minute.setHorizontalAlignment(SwingConstants.CENTER);
		Minute.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		Minute.setBounds(163, 22, 61, 57);
		Minute.setForeground(Color.WHITE);
		contentPane.add(Minute);
		
		JLabel Second = new JLabel("0.");
		Second.setHorizontalAlignment(SwingConstants.RIGHT);
		Second.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		Second.setBounds(228, 20, 64, 61);
		Second.setForeground(Color.WHITE);
		contentPane.add(Second);
		
		JLabel Millisecond = new JLabel("0");
		Millisecond.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		Millisecond.setBounds(291, 16, 91, 69);
		Millisecond.setForeground(Color.WHITE);
		contentPane.add(Millisecond);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = true;
				Thread t = new Thread() {
					
					public void run() {
					
						for(;;) {
							if (state == true) {
								try{
									sleep(1);
									if(milliseconds > 999) {
										milliseconds = 0;
										seconds++;
									}
									if(seconds >= 60) {
										milliseconds = 0;
										seconds = 0;
										minutes++;
									}
									if(minutes >= 60) {
										milliseconds = 0;
										seconds = 0;
										minutes = 0;
										hours++;
									}
									Millisecond.setText("." + milliseconds/10);
									milliseconds++;
									
									Second.setText("" + seconds);
									Minute.setText("" + minutes);
									Hour.setText("" + hours);
									
								}
								catch(Exception e) {
									
								}
							}
							else {
								break;
							}
						}
					}
				};
				t.start();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(30, 106, 91, 38);
		contentPane.add(btnNewButton);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = false;
			}
		});
		btnStop.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnStop.setBounds(143, 106, 91, 38);
		contentPane.add(btnStop);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = false;
				milliseconds = 0;
				seconds = 0;
				minutes = 0;
				hours = 0;
				
				Millisecond.setText("." + milliseconds);
				Second.setText("" + seconds);
				Minute.setText("" + minutes);
				Hour.setText("" + hours);
				
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnReset.setBounds(264, 106, 118, 38);
		contentPane.add(btnReset);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setForeground(Color.WHITE);
		lblHours.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHours.setBounds(90, 69, 61, 16);
		contentPane.add(lblHours);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setForeground(Color.WHITE);
		lblMinutes.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMinutes.setBounds(163, 69, 72, 16);
		contentPane.add(lblMinutes);
		
		JLabel lblSeconds = new JLabel("Seconds");
		lblSeconds.setForeground(Color.WHITE);
		lblSeconds.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSeconds.setBounds(258, 73, 80, 16);
		contentPane.add(lblSeconds);
		
		JLabel Hour_1 = new JLabel(":");
		Hour_1.setHorizontalAlignment(SwingConstants.CENTER);
		Hour_1.setForeground(Color.WHITE);
		Hour_1.setFont(new Font("Times New Roman", Font.PLAIN, 39));
		Hour_1.setBounds(228, 23, 11, 57);
		contentPane.add(Hour_1);
		
		JLabel Hour_1_1 = new JLabel(":");
		Hour_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		Hour_1_1.setForeground(Color.WHITE);
		Hour_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 39));
		Hour_1_1.setBounds(150, 23, 11, 57);
		contentPane.add(Hour_1_1);
	}
}
