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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;

import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Stack;

import javax.swing.SwingConstants;

public class PhysicsReservations extends JFrame{

	private JPanel layout3;
	JLabel lbldisplayHour = new JLabel("");
	private JTextField tfreservationTitle;
	private static int weekOfYear;
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhysicsReservations frame = new PhysicsReservations();
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
	
	public PhysicsReservations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Physics Reservations");
		setBounds(100, 100, 550, 700);
		layout3 = new JPanel();
		layout3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layout3);
		getContentPane().setBackground(new Color(51, 153, 255));
		layout3.setLayout(null);
		
		JLabel lblPhysicsReservations = new JLabel("Physics Reservations");
		lblPhysicsReservations.setForeground(Color.BLACK);
		lblPhysicsReservations.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPhysicsReservations.setBounds(20, 25, 254, 50);
		layout3.add(lblPhysicsReservations);
		
		JButton btngoBack = new JButton("Back");
		btngoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout3.setVisible(false);
				dispose();
				WelcomePage wlcmpg = new WelcomePage();
				wlcmpg.lbldisplayName.setText(firstname + " " + lastname + "!");
				wlcmpg.setVisible(true);
			}
		});
		btngoBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btngoBack.setBounds(450, 619, 76, 34);
		layout3.add(btngoBack);
		
		JLabel lblpickDay = new JLabel("What day would you like to create your reservation?");
		lblpickDay.setForeground(Color.BLUE);
		lblpickDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblpickDay.setBounds(20, 85, 459, 34);
		layout3.add(lblpickDay);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(20, 129, 420, 34);
		layout3.add(dateChooser);
		
		JLabel lblpickTime = new JLabel("What time would you like to create your reservation?");
		lblpickTime.setForeground(Color.BLUE);
		lblpickTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblpickTime.setBounds(20, 212, 459, 34);
		layout3.add(lblpickTime);
		
		JLabel lblpickedHour = new JLabel("You have picked time: ");
		lblpickedHour.setForeground(Color.BLACK);
		lblpickedHour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblpickedHour.setBounds(20, 294, 164, 34);
		layout3.add(lblpickedHour);
		
		JLabel lbldisplayHour = new JLabel("");
		lbldisplayHour.setForeground(Color.BLACK);
		lbldisplayHour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbldisplayHour.setBounds(186, 294, 316, 34);
		layout3.add(lbldisplayHour);
		
		String[] hours = {"7:40-8:25", "8:25-9:10", "9:10-9:55", "9:55-10:15 [Break]", "10:15-11:00", "11:00-11:45", "11:45-12:30 [Break]", "12:30-1:15", "1:15-2:00", "2:00-2:45", "2:45-3:30", "3:30-4:15"};
		String[] wedHours = {"7:40-8:25", "8:25-9:10", "9:10-9:55", "9:55-10:15 [Break]", "10:15-11:00", "11:00-11:45", "11:45-12:05 [Break]", "12:05-12:45", "12:45-1:25", "1:25-2:15 [Faculty meeting]", "2:15-2:55", "2:55-3:35", "3:35-4:15"};
		
		JButton btnverifyDate = new JButton("I have verified that I entered the correct date*");
		btnverifyDate.setHorizontalAlignment(SwingConstants.LEFT);
		btnverifyDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date date = dateChooser.getDate();
				LocalDateTime ldt = date.toInstant()
				        .atZone(ZoneId.systemDefault())
				        .toLocalDateTime();
				DayOfWeek dow = ldt.getDayOfWeek();
				
				if(dow.name() == "WEDNESDAY") {
					JComboBox hourOption = new JComboBox(wedHours);
					hourOption.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							lbldisplayHour.setText(hourOption.getSelectedItem().toString());
						}
					});
					hourOption.setFont(new Font("Tahoma", Font.PLAIN, 16));
					hourOption.setBounds(20, 252, 230, 34);
					layout3.add(hourOption);
					layout3.validate();
				} else {
					JComboBox hourOption = new JComboBox(hours);
					hourOption.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							lbldisplayHour.setText(hourOption.getSelectedItem().toString());
						}
					});
					hourOption.setFont(new Font("Tahoma", Font.PLAIN, 16));
					hourOption.setBounds(20, 252, 230, 34);
					layout3.add(hourOption);
					layout3.validate();
				}
			}
		});
		btnverifyDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnverifyDate.setBounds(20, 173, 402, 34);
		layout3.add(btnverifyDate);
		
		
		
		JLabel lblreservationTitle = new JLabel("What is the title of your reservation?");
		lblreservationTitle.setForeground(Color.BLUE);
		lblreservationTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblreservationTitle.setBounds(20, 327, 459, 34);
		layout3.add(lblreservationTitle);
		
		tfreservationTitle = new JTextField();
		tfreservationTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfreservationTitle.setBounds(20, 366, 420, 34);
		layout3.add(tfreservationTitle);
		tfreservationTitle.setColumns(10);
		
		JLabel lblreservationDescription = new JLabel("Enter a description (Optional; max 255 characters)");
		lblreservationDescription.setForeground(Color.BLUE);
		lblreservationDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblreservationDescription.setBounds(20, 413, 459, 34);
		layout3.add(lblreservationDescription);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane.setBounds(20, 448, 420, 97);
		layout3.add(textPane);
		
		JButton btncreateReservation = new JButton("Create Reservation");
		btncreateReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stack alldates = new Stack();
				String tempdate;
				int tempweek;
				int reservationcounter = 0;
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        String date = dateFormat.format(dateChooser.getDate());
				String time = lbldisplayHour.getText();
				String title = tfreservationTitle.getText();
				String description = textPane.getText();
				
		        String x = date.substring(0,4);
		        String y = date.substring(5,7);
		        String z = date.substring(8,10);
		        
		        int year = Integer.parseInt(x);
		        int y1 = Integer.parseInt(y);
		        int month = y1 - 1;
		        int day = Integer.parseInt(z);
		        
				Calendar calendar = Calendar.getInstance(Locale.ITALY); 
				calendar.set(year, month, day); 
				weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
				
				ReservationCreations newReservation = new ReservationCreations();
				Login existingUser = new Login();
				try {
					alldates = existingUser.getDates("physicsReservations");
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				while (alldates.isEmpty() == false) {
					if (alldates.pop().equals(id)) {
						tempdate = (String) alldates.pop();
						x = tempdate.substring(0,4);
						y = tempdate.substring(5,7);
						z = tempdate.substring(8,10);
						
				        year = Integer.parseInt(x);
				        y1 = Integer.parseInt(y);
				        month = y1 - 1;
				        day = Integer.parseInt(z);
				        
				        calendar.set(year, month, day);
				        tempweek = calendar.get(Calendar.WEEK_OF_YEAR);
				        if (tempweek == weekOfYear) {
				        	reservationcounter++;
				        }
					}
				}
				
				String now = LocalDateTime.now().toString();
				Date checkdate = null;
				Date present = null;
				
				try {
					checkdate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date);
					present = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(now);
				} catch (ParseException e2) {
					e2.printStackTrace();
				}

				if(date.length() < 1) {
					JOptionPane.showMessageDialog(null, "You have not picked a date, please try again");
				} else if(time == "") {
					JOptionPane.showMessageDialog(null, "You have not picked a time, please try again");
				} else if (reservationcounter == 3) {
					JOptionPane.showMessageDialog(null, "You have created the maximum amount of reservations for this week: 3");
				} else if(title.length() < 1) {
					JOptionPane.showMessageDialog(null, "Your title is invalid, please try again");
				} else if(description.length() > 244) {
					JOptionPane.showMessageDialog(null, "Your description exceeds the limit, please try again");
				} else if(checkdate.compareTo(present) < 0) {
					JOptionPane.showMessageDialog(null, "You have provided an invalid date.");
				} 
				
				else{ 
					try {
					if (newReservation.rAlreadyExists("physicsReservations").contains(date) && newReservation.rAlreadyExists("physicsReservations").contains(time)) {
							JOptionPane.showMessageDialog(null, "Sorry, a reservation already exists at this day & time. Please use another day/time.");
					    } else {
					    	try {
								newReservation.reserveR(id, date, time, title, description, "physicsReservations");
								JOptionPane.showMessageDialog(null, "Reservation has been created! A confirmation email has been sent to you! Please check your spam folder if not visible.");
								MailerApp mailutils = new MailerApp();
								PdfTextFormat pdf = new PdfTextFormat(date, time, title, description);
								pdf.createPDF();
								mailutils.sendMail(
										"Reservation Confirmation",
										"This message is to confirm your physics lab reservation on " + date + " at " + time + ". Please check the pdf attached for more information",
										"your-email-address",
										emailaddress);
								layout3.setVisible(false);
								dispose();
								WelcomePage wlcmpg = new WelcomePage();
								wlcmpg.lbldisplayName.setText(firstname + " " + lastname + "!");
								wlcmpg.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
					    }
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btncreateReservation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btncreateReservation.setBounds(162, 573, 197, 44);
		layout3.add(btncreateReservation);
		
		JLabel documentimg = new JLabel("");
		documentimg.setBounds(268, 25, 45, 50);
		layout3.add(documentimg);
		
		ImageIcon logoutimage;
		logoutimage = new ImageIcon(getClass().getResource("/imgs/Documentimg.png"));
		Image newImage = logoutimage.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
		
		ImageIcon test = new ImageIcon(newImage);
		documentimg.setIcon(test);
		
	}
}
