import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class showReservations extends JFrame {
	private static String firstname;
	private static String lastname;
	private static String emailaddress;
	private static String uname;
	private static String pword;
	static String id;

	private JPanel layout6;
	private JTable reservationsTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showReservations frame = new showReservations();
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
	public showReservations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		layout6 = new JPanel();
		layout6.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layout6);
		getContentPane().setBackground(new Color(51, 153, 255));
		layout6.setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel(new Object[]{"Reserved Lab Type", "Date", "Time", "Title", "Description"}, 0);
		JTable reservationsTable = new JTable(model);

		reservationsTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		reservationsTable.setRowHeight(30);
		layout6.add(reservationsTable);
		
		Login x = new Login();
		String[][] allData = new String[1][1];
		try {
			allData = x.getdatabaseinfo();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final String[][] data = allData;
		
		JButton btnshowReservations = new JButton("Show Reservations");
		btnshowReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)reservationsTable.getModel();
		        for(int i = 0; i < data.length; i++)
		        {
		        	String[] row = new String[6];
		            for(int j = 0; j < data[i].length; j++){

		            	if (data[i][j].equals(id)) {
		            		row[0] = data[i][j-5];
		            		row[1] = data[i][j-4];
		            		row[2] = data[i][j-3];
		            		row[3] = data[i][j-2];
		            		row[4] = data[i][j-1];
		            		row[5] = data[i][j];
		            		
		            		model.addRow(row);
		            	}
		            }
		        }
		        
			}
		});
		btnshowReservations.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnshowReservations.setBounds(632, 10, 206, 56);
		layout6.add(btnshowReservations);
		
		JScrollPane scrollpane = new JScrollPane(reservationsTable);
		scrollpane.setSize(1494, 607);
		scrollpane.setLocation(22, 86);
		layout6.add(scrollpane, BorderLayout.CENTER);
		
		JButton btngoBack = new JButton("Back");
		btngoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout6.setVisible(false);
				dispose();
				WelcomePage wlcmpg = new WelcomePage();
				wlcmpg.lbldisplayName.setText(firstname + " " + lastname + "!");
				wlcmpg.setVisible(true);
			}
		});
		btngoBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btngoBack.setBounds(1454, 732, 76, 34);
		layout6.add(btngoBack);
		

	}
	public class MultilineTableCellEditor extends AbstractCellEditor implements TableCellEditor {

	    JComponent component = new JTextArea();
	    JTable table;
	    int lastRowIndex;

	    public MultilineTableCellEditor() {
	        JTextArea textArea = ((JTextArea) component);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        textArea.addComponentListener(new ComponentAdapter() {
	            @Override
	            public void componentResized(ComponentEvent e) {
	                super.componentResized(e);
	                table.setRowHeight(lastRowIndex, (int) (textArea.getPreferredSize().getHeight()));
	            }
	        });
	        textArea.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyTyped(KeyEvent e) {
	                super.keyTyped(e);
	                table.setRowHeight(lastRowIndex, (int) (textArea.getPreferredSize().getHeight()));
	            }
	        });
	    }

	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
                int rowIndex, int vColIndex) {
	    	this.table = table;
	    	lastRowIndex = rowIndex;

	    	((JTextArea) component).setText((String) value);
	    	component.setFont(table.getFont());

	    	return component;
	    }

	    public Object getCellEditorValue() {
	    	return ((JTextArea) component).getText();
	    }
	}
	public static void getInfo(int ids, String fname, String lname, String em, String us, String pass) {
		id = Integer.toString(ids);
		firstname = fname;
		lastname = lname;
		emailaddress = em;
		uname = us;
		pword = pass;
	}
}
