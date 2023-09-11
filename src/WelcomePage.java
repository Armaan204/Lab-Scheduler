import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePage extends JFrame {

	private JPanel layout1;
	JLabel lbldisplayName = new JLabel("");
	private static int id;
	private static String firstname;
	private static String lastname;
	private static String emailaddress;
	private static String uname;
	private static String pword;
	

	/**
	 * Launch the application.
	 */
	public static void getInfo(int ids, String fname, String lname, String em, String us, String pass) {
		id = ids;
		firstname = fname;
		lastname = lname;
		emailaddress = em;
		uname = us;
		pword = pass;
		
	}
	public static int returnID() {
		return id;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
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
	public WelcomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Welcome Page");
		setBounds(100, 100, 550, 600);
		layout1 = new JPanel();
		layout1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layout1);
		getContentPane().setBackground(new Color(51, 153, 255));
		layout1.setLayout(null);
		
		JLabel lblimage = new JLabel();
		lblimage.setBounds(382, 515, 38, 42);
		layout1.add(lblimage);
		
		ImageIcon logoutimage;
		logoutimage = new ImageIcon(getClass().getResource("/imgs/LogOut.png"));
		Image newImage = logoutimage.getImage().getScaledInstance(37, 37, Image.SCALE_SMOOTH);
		
		ImageIcon test = new ImageIcon(newImage);
		lblimage.setIcon(test);

		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWelcome.setBounds(25, 23, 97, 50);
		layout1.add(lblWelcome);
		lbldisplayName.setForeground(new Color(0, 0, 0));
		
		lbldisplayName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbldisplayName.setBounds(132, 23, 383, 50);
		layout1.add(lbldisplayName);
		
		JButton btnphysicsLab = new JButton("Physics Lab");
		btnphysicsLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout1.setVisible(false);
				dispose();
				PhysicsReservations physpg = new PhysicsReservations();
				physpg.getInfo(id, firstname, lastname, emailaddress, uname, pword);
				physpg.setVisible(true);
			}
		});
		btnphysicsLab.setBackground(new Color(51, 153, 0));
		btnphysicsLab.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnphysicsLab.setBounds(36, 87, 208, 139);
		layout1.add(btnphysicsLab);
		
		JButton btnChemistryLab = new JButton("Chemistry Lab");
		btnChemistryLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout1.setVisible(false);
				dispose();
				ChemistryReservations chempg = new ChemistryReservations();
				chempg.getInfo(id, firstname, lastname, emailaddress, uname, pword);
				chempg.setVisible(true);
			}
		});
		btnChemistryLab.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnChemistryLab.setBackground(new Color(51, 153, 0));
		btnChemistryLab.setBounds(280, 87, 208, 139);
		layout1.add(btnChemistryLab);
		
		JButton btnBiologyLab = new JButton("Biology Lab");
		btnBiologyLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout1.setVisible(false);
				dispose();
				BiologyReservations biopg = new BiologyReservations();
				biopg.getInfo(id, firstname, lastname, emailaddress, uname, pword);
				biopg.setVisible(true);
			}
		});
		btnBiologyLab.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnBiologyLab.setBackground(new Color(51, 153, 0));
		btnBiologyLab.setBounds(35, 260, 208, 139);
		layout1.add(btnBiologyLab);
		
		JButton btnItLab = new JButton("IT Lab");
		btnItLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout1.setVisible(false);
				dispose();
				ITReservations itpg = new ITReservations();
				itpg.getInfo(id, firstname, lastname, emailaddress, uname, pword);
				itpg.setVisible(true);
			}
		});
		btnItLab.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnItLab.setBackground(new Color(51, 153, 0));
		btnItLab.setBounds(280, 260, 208, 139);
		layout1.add(btnItLab);
		
		JButton btnLogout = new JButton("Log Out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Logged out successfully!");
				layout1.setVisible(false);
				dispose();
				Frame1 homescreen = new Frame1();
				homescreen.main(null);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogout.setBounds(429, 518, 97, 34);
		layout1.add(btnLogout);
		
		JButton btnmyReservations = new JButton("My Reservations");
		btnmyReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout1.setVisible(false);
				dispose();
				showReservations show = new showReservations();
				show.getInfo(id, firstname, lastname, emailaddress, uname, pword);
				show.setVisible(true);
			}
		});
		btnmyReservations.setBackground(new Color(0, 204, 51));
		btnmyReservations.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnmyReservations.setBounds(36, 434, 208, 57);
		layout1.add(btnmyReservations);
		
		JButton btndeleteReservation = new JButton("Delete A Reservation");
		btndeleteReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout1.setVisible(false);
				dispose();
				DeleteReservation delete = new DeleteReservation();
				delete.getNames(firstname, lastname);
				delete.setVisible(true);
			}
		});
		btndeleteReservation.setBackground(new Color(204, 0, 0));
		btndeleteReservation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btndeleteReservation.setBounds(280, 434, 208, 57);
		layout1.add(btndeleteReservation);
		}
}
