import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel layout2;
	private JTextField tfloginUsername;
	private JTextField tfloginPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login Page");
		setBounds(100, 100, 550, 440);
		layout2 = new JPanel();
		layout2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layout2);
		getContentPane().setBackground(new Color(51, 153, 255));
		layout2.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblLogin.setBounds(25, 23, 76, 50);
		layout2.add(lblLogin);
		
		JLabel lblloginUsername = new JLabel("Username:");
		lblloginUsername.setForeground(new Color(204, 0, 153));
		lblloginUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblloginUsername.setBounds(24, 101, 116, 32);
		layout2.add(lblloginUsername);
		
		tfloginUsername = new JTextField();
		tfloginUsername.setColumns(10);
		tfloginUsername.setBounds(136, 102, 318, 32);
		layout2.add(tfloginUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(204, 0, 153));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(25, 168, 116, 32);
		layout2.add(lblPassword);
		
		tfloginPassword = new JPasswordField();
		tfloginPassword.setColumns(10);
		tfloginPassword.setBounds(136, 168, 318, 32);
		layout2.add(tfloginPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				Login existingUser = new Login();
				User encrypt = new User();
				
				String username = tfloginUsername.getText().toString();
				String password = tfloginPassword.getText().toString();
				String encryptedpass = encrypt.encryptPassword(password);

                try {
					if (existingUser.verify(username, encryptedpass).contains(username) && existingUser.verify(username, encryptedpass).contains(encryptedpass)) {
							int index = existingUser.verify(username, encryptedpass).indexOf(username);
							String idstring = existingUser.verify(username, encryptedpass).get(index - 1);
							int id = Integer.parseInt(idstring);
							String uname = existingUser.verify(username, encryptedpass).get(index);
							String pass = existingUser.verify(username, encryptedpass).get(index + 1);
							String email = existingUser.verify(username, encryptedpass).get(index + 2);
							String fname = existingUser.verify(username, encryptedpass).get(index + 3);
							String lname = existingUser.verify(username, encryptedpass).get(index + 4);

							JOptionPane.showMessageDialog(null, "Logged in Successfully");
							existingUser.getdatabaseinfo();
							layout2.setVisible(false);
							dispose();
							WelcomePage wlcmpg = new WelcomePage();
							wlcmpg.getInfo(id, fname, lname, email, uname, pass);
							wlcmpg.lbldisplayName.setText(username + "!");
							wlcmpg.setVisible(true);
					    } else {
					        JOptionPane.showMessageDialog(null, "Incorrect Username or Password, try again.");
					        tfloginPassword.setText("");
					    }
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnLogin.setBounds(209, 237, 108, 49);
		layout2.add(btnLogin);
		
		JButton btngoBack = new JButton("Back");
		btngoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout2.setVisible(false);
				dispose();
				Frame1 homescreen = new Frame1();
				homescreen.main(null);
			}
		});
		btngoBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btngoBack.setBounds(450, 359, 76, 34);
		layout2.add(btngoBack);
		
		JButton btnforgotPass = new JButton("Forgot your password?");
		btnforgotPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout2.setVisible(false);
				dispose();
				forgotPassEmail homescreen = new forgotPassEmail();
				homescreen.main(null);
			}
		});
		btnforgotPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnforgotPass.setBounds(179, 313, 169, 32);
		layout2.add(btnforgotPass);
		
	    KeyAdapter Enter = new KeyAdapter(){
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	                btnLogin.doClick();
	            }
	        }
	    };
	    tfloginPassword.addKeyListener(Enter);
	}
}
