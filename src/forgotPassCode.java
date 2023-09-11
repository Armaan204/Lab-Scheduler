import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class forgotPassCode extends JFrame {
	static String email;
	
	private JPanel layout5;
	private JTextField textsecurityCode;
	private JPasswordField pf;
	private JPasswordField pfrepeatPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgotPassCode frame = new forgotPassCode();
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
	public forgotPassCode() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 440);
		layout5 = new JPanel();
		layout5.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layout5);
		getContentPane().setBackground(new Color(51, 153, 255));
		layout5.setLayout(null);
		
		JLabel lblSecurityCode = new JLabel("Security Code:");
		lblSecurityCode.setForeground(new Color(204, 0, 153));
		lblSecurityCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSecurityCode.setBounds(10, 88, 139, 32);
		layout5.add(lblSecurityCode);
		
		textsecurityCode = new JTextField();
		textsecurityCode.setColumns(10);
		textsecurityCode.setBounds(179, 88, 318, 32);
		layout5.add(textsecurityCode);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setForeground(new Color(204, 0, 153));
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewPassword.setBounds(11, 155, 138, 32);
		layout5.add(lblNewPassword);
		
		JTextField tfnewPassword = new JTextField();
		tfnewPassword.setColumns(10);
		tfnewPassword.setBounds(179, 154, 318, 32);
		layout5.add(tfnewPassword);
		
		JLabel lblresetPassword = new JLabel("Reset Password:");
		lblresetPassword.setForeground(Color.BLACK);
		lblresetPassword.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblresetPassword.setBounds(11, 10, 202, 50);
		layout5.add(lblresetPassword);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password: ");
		lblRepeatPassword.setForeground(new Color(204, 0, 153));
		lblRepeatPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRepeatPassword.setBounds(10, 220, 169, 32);
		layout5.add(lblRepeatPassword);
		
		JTextField pfrepeatPassword = new JTextField();
		pfrepeatPassword.setColumns(10);
		pfrepeatPassword.setBounds(178, 220, 318, 32);
		layout5.add(pfrepeatPassword);
		
		JButton btnresetPassword = new JButton("Reset Password");
		btnresetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = textsecurityCode.getText().toString();
				String password = tfnewPassword.getText().toString();
				String rpassword = pfrepeatPassword.getText().toString();
				
				forgotPassDB verifycode = new forgotPassDB(email);
				
				try {
					if (verifycode.codeExists().contains(code)) {
						if (password.equals(rpassword)) {
							verifycode.editUser(email, rpassword);
							
							JOptionPane.showMessageDialog(null, "Your password has been reset!");
							
							layout5.setVisible(false);
							dispose();
							LoginPage homescreen = new LoginPage();
							homescreen.main(null);
							
						} else {
							JOptionPane.showMessageDialog(null, "The two passwords do not match.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "The security code you entered is wrong. Please try again.");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnresetPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnresetPassword.setBounds(246, 285, 169, 49);
		layout5.add(btnresetPassword);
		
		JButton btngoBack = new JButton("Back");
		btngoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout5.setVisible(false);
				dispose();
				LoginPage homescreen = new LoginPage();
				homescreen.main(null);
			}
		});
		btngoBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btngoBack.setBounds(450, 359, 76, 34);
		layout5.add(btngoBack);
		
	    KeyAdapter Enter = new KeyAdapter(){
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	                btnresetPassword.doClick();
	            }
	        }
	    };
	    pfrepeatPassword.addKeyListener(Enter);
	}
	
	public static void setEmail(String m) {
		email = m;
	}
}
