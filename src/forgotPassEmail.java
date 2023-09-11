import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class forgotPassEmail extends JFrame {

	private JPanel layout4;
	private JTextField tfgetResetEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgotPassEmail frame = new forgotPassEmail();
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
	public forgotPassEmail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 325);
		layout4 = new JPanel();
		layout4.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layout4);
		getContentPane().setBackground(new Color(51, 153, 255));
		layout4.setLayout(null);
		
		JLabel lblPasswordReset = new JLabel("Password Reset");
		lblPasswordReset.setForeground(Color.BLACK);
		lblPasswordReset.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPasswordReset.setBounds(10, 10, 210, 50);
		layout4.add(lblPasswordReset);
		
		JLabel lblenterEmail = new JLabel("Enter the email linked to the account you would");
		lblenterEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblenterEmail.setForeground(new Color(204, 0, 153));
		lblenterEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblenterEmail.setBounds(0, 67, 456, 33);
		layout4.add(lblenterEmail);
		
		JLabel lblenterEmail1 = new JLabel("like to reset the password for:");
		lblenterEmail1.setHorizontalAlignment(SwingConstants.CENTER);
		lblenterEmail1.setForeground(new Color(204, 0, 153));
		lblenterEmail1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblenterEmail1.setBounds(0, 96, 456, 33);
		layout4.add(lblenterEmail1);
		
		tfgetResetEmail = new JTextField();
		tfgetResetEmail.setBounds(87, 139, 284, 33);
		layout4.add(tfgetResetEmail);
		tfgetResetEmail.setColumns(10);
		
		JButton btnsendCode = new JButton("Send Code");
		btnsendCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = tfgetResetEmail.getText().toString();
				forgotPassDB forgotpass = new forgotPassDB(email);
				forgotPassCode transportEmail = new forgotPassCode();
				try {
					if (forgotpass.resetEmailExists().contains(email)) {
						forgotpass.createCode();
						String code = forgotpass.getSecurityCode();
			            MailerApp mailcode = new MailerApp();
			            mailcode.sendCode(
								"Security Code",
								"Here is the security code needed to reset your Lab Reservation App password: " + code + ". If this was not requested by you, please ignore this message.",
								"labreservationapp@gmail.com",
								email);
						transportEmail.setEmail(email);
					} else {}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "If an email is registered with this account, a security code has been sent");
				layout4.setVisible(false);
				dispose();
				forgotPassCode homescreen = new forgotPassCode();
				homescreen.main(null);
			}
		});
		btnsendCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnsendCode.setBounds(161, 193, 131, 27);
		layout4.add(btnsendCode);
		
		JButton btngoBack = new JButton("Back");
		btngoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout4.setVisible(false);
				dispose();
				LoginPage homescreen = new LoginPage();
				homescreen.main(null);
			}
		});
		btngoBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btngoBack.setBounds(370, 244, 76, 34);
		layout4.add(btngoBack);
		
	    KeyAdapter Enter = new KeyAdapter(){
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	                btnsendCode.doClick();
	            }
	        }
	    };
	    tfgetResetEmail.addKeyListener(Enter);
	}
}
