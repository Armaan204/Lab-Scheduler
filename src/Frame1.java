import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Frame1 {

	private JFrame frame;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfEmail;
	private JTextField tfUsername;
	private JTextField tfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Frame1 window = new Frame1();
				window.frame.setVisible(true);
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Frame1() {
		ReservationCreations refresh = new ReservationCreations();
		try {
			refresh.refreshDatabase("physicsReservations");
			refresh.refreshDatabase("chemistryReservations");
			refresh.refreshDatabase("biologyReservations");
			refresh.refreshDatabase("itReservations");
		} catch (Exception e) {
			e.printStackTrace();
		}
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Lab Reservation App");
		frame.setBounds(100, 100, 550, 600);
		frame.getContentPane().setBackground(new Color(51, 153, 255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblimage = new JLabel();
		lblimage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				   URI uri = null;
				try {
					uri = new URI("https://ic-lab-reservation-app-view-reservations.000webhostapp.com/");
				} catch (URISyntaxException e2) {
					e2.printStackTrace();
				}
				   try {
					java.awt.Desktop.getDesktop().browse(uri);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblimage.setForeground(Color.WHITE);
		lblimage.setBounds(339, 458, 38, 42);
		frame.getContentPane().add(lblimage);
		
		ImageIcon logoutimage;
		logoutimage = new ImageIcon(getClass().getResource("/imgs/viewicon.png"));
		Image newImage = logoutimage.getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH);
		
		ImageIcon test = new ImageIcon(newImage);
		lblimage.setIcon(test);
		
		JLabel lblTitle = new JLabel("Welcome to the Lab Reservation App!");
		lblTitle.setForeground(new Color(153, 0, 153));
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(43, 10, 450, 80);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setForeground(new Color(204, 0, 153));
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFirstName.setBounds(25, 100, 86, 32);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastname = new JLabel("Last Name:");
		lblLastname.setForeground(new Color(204, 0, 102));
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLastname.setBounds(25, 145, 86, 32);
		frame.getContentPane().add(lblLastname);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(204, 0, 153));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(25, 190, 86, 32);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(204, 0, 153));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsername.setBounds(25, 235, 86, 32);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(204, 0, 153));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(25, 280, 86, 32);
		frame.getContentPane().add(lblPassword);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(137, 100, 318, 32);
		frame.getContentPane().add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(137, 145, 318, 32);
		frame.getContentPane().add(tfLastName);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(137, 190, 318, 32);
		frame.getContentPane().add(tfEmail);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(137, 235, 318, 32);
		frame.getContentPane().add(tfUsername);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(137, 280, 318, 32);
		frame.getContentPane().add(tfPassword);
		
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				String inputfname = tfFirstName.getText().toString();
				String inputlname = tfLastName.getText().toString();
				String inputemail = tfEmail.getText().toString();
				String inputusername = tfUsername.getText().toString();
				String inputpassword = tfPassword.getText().toString();

				Boolean emailValidity = false;
				Boolean emailExists = false;
				Boolean usernameExists = false;
				
				if (inputemail.contains("@")){ 
					emailValidity = true;
				}
				//check if email is valid and contains "@".
				
				User newUser = new User();

                try {
					if (newUser.verifyEmail(inputfname, inputlname, inputemail, inputusername, inputpassword).contains(inputemail)) {
							emailExists = true;
					    }
					if (newUser.verifyEmail(inputfname, inputlname, inputemail, inputusername, inputpassword).contains(inputusername)) {
						usernameExists = true;
				    }
					} catch (Exception e1) {
					e1.printStackTrace();
				}
                //check if email & username already exists.
                
				if (inputfname.length() < 2) {
					JOptionPane.showMessageDialog(null, "You have left First Name blank / it is too short. Please fill it out.");
				} else if (inputlname.length() < 1) {
					JOptionPane.showMessageDialog(null, "You have left Last Name blank / it is too short. Please fill it out.");
				} else if (inputemail.length() < 1) {
					JOptionPane.showMessageDialog(null, "You have entered an invalid email, please try again.");
				} else if (emailValidity.equals(false)) {
					JOptionPane.showMessageDialog(null, "You have entered an invalid email, please try again.");
				} else if (emailExists == true) {
					JOptionPane.showMessageDialog(null, "This email is already in use. Please login if you already have an account or use another email.");
				} else if (inputusername.length() < 1) {
					JOptionPane.showMessageDialog(null, "You have left Username blank. Please fill it out.");
				} else if (usernameExists == true) {
					JOptionPane.showMessageDialog(null, "This username is taken by another user. Please use another one.");
				} else if (inputpassword.length() < 1) {
					JOptionPane.showMessageDialog(null, "You have left Password blank. Please fill it out.");
				} else {
					try {
						newUser.saveUser(inputfname, inputlname, inputemail, inputusername, inputpassword);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "Account has been created");
					frame.dispose();
					WelcomePage wlcmpg = new WelcomePage();
					wlcmpg.getInfo(newUser.getID(), inputfname, inputlname, inputemail, inputusername, inputpassword);
					wlcmpg.lbldisplayName.setText(inputfname + " " + inputlname + "!");
					wlcmpg.setVisible(true);
				}	
			}
		});
		btnCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCreateAccount.setBounds(173, 341, 168, 49);
		frame.getContentPane().add(btnCreateAccount);
		
		JLabel lblexistinguser = new JLabel("Already have an account?");
		lblexistinguser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblexistinguser.setForeground(Color.BLACK);
		lblexistinguser.setBounds(137, 405, 201, 32);
		frame.getContentPane().add(lblexistinguser);
		
		JButton btnredirectToLogin = new JButton("Login");
		btnredirectToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginPage lgnpg = new LoginPage();
				lgnpg.setVisible(true);
			}
		});
		btnredirectToLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnredirectToLogin.setBounds(304, 408, 77, 25);
		frame.getContentPane().add(btnredirectToLogin);
		
		JLabel lblguestView = new JLabel("View existing reservations in guest mode:");
		lblguestView.setForeground(new Color(204, 0, 153));
		lblguestView.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblguestView.setBounds(25, 463, 329, 32);
		frame.getContentPane().add(lblguestView);
		
	    KeyAdapter Enter = new KeyAdapter(){
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	                btnCreateAccount.doClick();
	            }
	        }
	    };
	    tfPassword.addKeyListener(Enter);
	}
}
