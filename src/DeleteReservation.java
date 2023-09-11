import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteReservation extends JFrame {
	private static int id;
	private static String firstname;
	private static String lastname;

	private JPanel layout7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteReservation frame = new DeleteReservation();
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
	public static void getNames(String fname, String lname) {
		firstname = fname;
		lastname = lname;
	}
	
	public DeleteReservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Delete a Reservation");
		setBounds(100, 100, 550, 330);
		layout7 = new JPanel();
		layout7.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layout7);
		getContentPane().setBackground(new Color(51, 153, 255));
		layout7.setLayout(null);
		
		JLabel lbldeleteRv = new JLabel("Delete a Reservation:");
		lbldeleteRv.setForeground(Color.BLACK);
		lbldeleteRv.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbldeleteRv.setBounds(21, 10, 264, 50);
		layout7.add(lbldeleteRv);
		
		JLabel lblwhichRv = new JLabel("Which reservation would you like to delete?");
		lblwhichRv.setForeground(new Color(204, 0, 153));
		lblwhichRv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblwhichRv.setBounds(21, 70, 406, 32);
		layout7.add(lblwhichRv);
		
		WelcomePage wlcmpg = new WelcomePage();
		id = wlcmpg.returnID();
		Login existingUser = new Login();
		ArrayList<String> tempdeleteOptions = null;
		
		try {
			tempdeleteOptions = existingUser.getDeleteOptions();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int reservedcounter = 0;
		for (int j = 0; j < tempdeleteOptions.size(); j++) {
			if (tempdeleteOptions.get(j).equals(Integer.toString(id))) {
				reservedcounter++;
			}
		}
		
		String[] deleteOptions = new String[reservedcounter];
		
		int i = 0;
		for (int c = 0; c < tempdeleteOptions.size(); c++) {
			if (tempdeleteOptions.get(c).equals(Integer.toString(id))) {
				deleteOptions[i] = tempdeleteOptions.get(c+1);
				i++;
			}
		}
		JComboBox comboBox = new JComboBox(deleteOptions);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(21, 113, 325, 39);
		layout7.add(comboBox);
		
		JButton btnDeleteReservation = new JButton("Delete Reservation");
		btnDeleteReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String)comboBox.getSelectedItem();
				String truncatedate = selectedOption.substring(0,selectedOption.indexOf("|")-1);
				String truncatetime = selectedOption.substring(selectedOption.indexOf("|")+2, selectedOption.indexOf("(")-1);
				String templabtype = selectedOption.substring(selectedOption.indexOf("(")+1, selectedOption.indexOf(")"));
				String labtype = templabtype.toLowerCase() + "Reservations";
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this reservation?", "Deletion Confirmation", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					try {
						existingUser.deleteReservation(truncatedate, truncatetime, labtype);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					layout7.setVisible(false);
					dispose();
					WelcomePage wlcmpg = new WelcomePage();
					wlcmpg.lbldisplayName.setText(firstname + " " + lastname + "!");
					wlcmpg.setVisible(true);
				    JOptionPane.showMessageDialog(null, "Reservation has been deleted!");
				} else {
				}
			}
		});
		btnDeleteReservation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeleteReservation.setBounds(167, 178, 197, 44);
		layout7.add(btnDeleteReservation);
		
		JButton btngoBack = new JButton("Back");
		btngoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout7.setVisible(false);
				dispose();
				WelcomePage wlcmpg = new WelcomePage();
				wlcmpg.lbldisplayName.setText(firstname + " " + lastname + "!");
				wlcmpg.setVisible(true);
			}
		});
		btngoBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btngoBack.setBounds(450, 249, 76, 34);
		layout7.add(btngoBack);
	}
}
