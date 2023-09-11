import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Login extends User{
	
	static String date;
	static String time;
	static String username;
    static String password;
    static String encryptedpass;
    Connection conn = null;
    
    public String[][] getdatabaseinfo() throws Exception{
    	int rows = 0, rows1 = 0, rows2 = 0, rows3 = 0, totalrows = 0;
    	Connection con = null;
    	Statement statement = null;
        try{
            con = super.getConnection();
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String SQL = "SELECT rdate,rtime,rtitle,rdescription,id FROM physicsReservations";
            ResultSet result = statement.executeQuery(SQL);
            
            while(result.next()) {
            	rows++;
            }
            result.beforeFirst();
            
            String SQL1 = "SELECT rdate,rtime,rtitle,rdescription,id FROM chemistryReservations";
            ResultSet result1 = statement.executeQuery(SQL1);
            
            while(result1.next()) {
            	rows1++;
            }
            result1.beforeFirst();
            
            String SQL2 = "SELECT rdate,rtime,rtitle,rdescription,id FROM biologyReservations";
            ResultSet result2 = statement.executeQuery(SQL2);
            
            while(result2.next()) {
            	rows2++;
            }
            result2.beforeFirst();
            
            String SQL3 = "SELECT rdate,rtime,rtitle,rdescription,id FROM itReservations";
            ResultSet result3 = statement.executeQuery(SQL3);
            while(result3.next()) {
            	rows3++;
            }
            result3.beforeFirst();
            
            totalrows = rows + rows1 + rows2 + rows3;
            
            String SQL4 = "SELECT rdate,rtime,rtitle,rdescription,id FROM physicsReservations";
            ResultSet result4 = statement.executeQuery(SQL4);
            
            int i = 0;
            String[][] array = new String[totalrows][6];
            while(result4.next()){
            	for (int j=0; j < 6; j++) {
            		array[i][j] = "Physics";
            		j++;
            		array[i][j] = result4.getString("rdate");
            		j++;
            		array[i][j] = result4.getString("rtime");
            		j++;
            		array[i][j] = result4.getString("rtitle");
            		j++;
            		array[i][j] = result4.getString("rdescription");
            		j++;
            		array[i][j] = result4.getString("id");
            	}
            	i++;
            }
            String SQL5 = "SELECT rdate,rtime,rtitle,rdescription,id FROM chemistryReservations";
            ResultSet result5 = statement.executeQuery(SQL5);
            
            while(result5.next()){
            	for (int j=0; j < 6; j++) {
            		array[i][j] = "Chemistry";
            		j++;
            		array[i][j] = result5.getString("rdate");
            		j++;
            		array[i][j] = result5.getString("rtime");
            		j++;
            		array[i][j] = result5.getString("rtitle");
            		j++;
            		array[i][j] = result5.getString("rdescription");
            		j++;
            		array[i][j] = result5.getString("id");
            	}
            	i++;
            }
            String SQL6 = "SELECT rdate,rtime,rtitle,rdescription,id FROM biologyReservations";
            ResultSet result6 = statement.executeQuery(SQL6);
            while(result6.next()){
            	for (int j=0; j < 6; j++) {
            		array[i][j] = "Biology";
            		j++;
            		array[i][j] = result6.getString("rdate");
            		j++;
            		array[i][j] = result6.getString("rtime");
            		j++;
            		array[i][j] = result6.getString("rtitle");
            		j++;
            		array[i][j] = result6.getString("rdescription");
            		j++;
            		array[i][j] = result6.getString("id");
            	}
            	i++;
            }
            String SQL7 = "SELECT rdate,rtime,rtitle,rdescription,id FROM itReservations";
            ResultSet result7 = statement.executeQuery(SQL7);
            while(result7.next()){
            	for (int j=0; j < 6; j++) {
            		array[i][j] = "IT";
            		j++;
            		array[i][j] = result7.getString("rdate");
            		j++;
            		array[i][j] = result7.getString("rtime");
            		j++;
            		array[i][j] = result7.getString("rtitle");
            		j++;
            		array[i][j] = result7.getString("rdescription");
            		j++;
            		array[i][j] = result7.getString("id");
            	}
            	i++;
            }
            return array;
        }catch(Exception e){System.out.println(e);}
        finally {
       	 try {
       	     if (statement != null) { statement.close(); }
       	   }
       	   catch (Exception e) {
       	     // log this error
       	   }
       	   try {
       	     if (con != null) { con.close(); }
       	   }
       	   catch (Exception e) {
       	     // log this error
       	   }
        }
		return null;
    }
    
    public ArrayList<String> getDeleteOptions() throws Exception{
    	Connection con = null;
    	PreparedStatement statement = null;
    	PreparedStatement statement1 = null;
    	PreparedStatement statement2 = null;
    	PreparedStatement statement3 = null;
        try{
            con = super.getConnection();
            statement = con.prepareStatement("SELECT id,rdate,rtime FROM physicsReservations");
            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
            		String id = result.getString("id");
            		String date = result.getString("rdate");
            		String time = result.getString("rtime");
            		
            		String combinedDT = date + " | " + time + " (Physics)";
            		
            		array.add(id);
            		array.add(combinedDT);
            		}
            statement1 = con.prepareStatement("SELECT id,rdate,rtime FROM chemistryReservations");
            ResultSet result1 = statement1.executeQuery();
            
            while(result1.next()){
        		String id = result1.getString("id");
        		String date = result1.getString("rdate");
        		String time = result1.getString("rtime");
        		
        		String combinedDT = date + " | " + time + " (Chemistry)";
        		
        		array.add(id);
        		array.add(combinedDT);
        		}
            statement2 = con.prepareStatement("SELECT id,rdate,rtime FROM biologyReservations");
            ResultSet result2 = statement2.executeQuery();
            
            while(result2.next()){
        		String id = result2.getString("id");
        		String date = result2.getString("rdate");
        		String time = result2.getString("rtime");
        		
        		String combinedDT = date + " | " + time + " (Biology)";
        		
        		array.add(id);
        		array.add(combinedDT);
        		}
            statement3 = con.prepareStatement("SELECT id,rdate,rtime FROM itReservations");
            ResultSet result3 = statement3.executeQuery();
            
            while(result3.next()){
        		String id = result3.getString("id");
        		String date = result3.getString("rdate");
        		String time = result3.getString("rtime");
        		
        		String combinedDT = date + " | " + time + " (IT)";
        		
        		array.add(id);
        		array.add(combinedDT);
        }
            return array;
            
        }catch(Exception e){System.out.println(e);}
        finally {
       	 try {
       	     if (statement != null) { statement.close(); }
       	   }
       	   catch (Exception e) {
       	     // log this error
       	   }
       	   try {
       	     if (con != null) { con.close(); }
       	   }
       	   catch (Exception e) {
       	     // log this error
       	   }
        }
		return null;
    }
    
    public Stack getDates(String lab) throws Exception{
    	String labtype = lab;
    	Connection con = null;
    	Statement statement = null;
        try{
            con = super.getConnection();
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            
            String SQL = "SELECT id,rdate FROM " + labtype;
            
            ResultSet result = statement.executeQuery(SQL);
            
            Stack dates = new Stack();
            
            while(result.next()){
            	dates.add(result.getString("rdate"));
            	dates.add(result.getInt("id"));
            }
            return dates;
        }catch(Exception e){System.out.println(e);}
        finally {
       	 try {
       	     if (statement != null) { statement.close(); }
       	   }
       	   catch (Exception e) {
       	     // log this error
       	   }
       	   try {
       	     if (con != null) { con.close(); }
       	   }
       	   catch (Exception e) {
       	     // log this error
       	   }
        }
		return null;
    }
    
    public void deleteReservation(String d, String t, String lab) throws Exception{
    	date = d;
    	time = t;
    	String labtype = lab;
    	Connection con = null;
    	PreparedStatement posted = null;
        try{
            con = super.getConnection();
            posted = con.prepareStatement("DELETE FROM " + labtype + " WHERE (rdate =? AND rtime =?)");
            posted.setString(1, date);
            posted.setString(2, time);
            posted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
        	 try {
        	     if (posted != null) { posted.close(); }
        	   }
        	   catch (Exception e) {
        	     // log this error
        	   }
        	   try {
        	     if (con != null) { con.close(); }
        	   }
        	   catch (Exception e) {
        	     // log this error
        	   }
        }
    }
    
    
    public ArrayList<String> verify(String usern, String pass) throws Exception{
    	username = usern;
        password = pass;
    	Connection con = null;
    	PreparedStatement statement = null;
        try{
            con = super.getConnection();
            statement = con.prepareStatement("SELECT id,username,password,email,fname,lname FROM Users");

            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
            	array.add(result.getString("id"));
                array.add(result.getString("username"));
                array.add(result.getString("password"));
                array.add(result.getString("email"));
                array.add(result.getString("fname"));
                array.add(result.getString("lname"));
            }
            return array;
        }catch(Exception e){System.out.println(e);}
        finally {
       	 try {
       	     if (statement != null) { statement.close(); }
       	   }
       	   catch (Exception e) {
       	     // log this error
       	   }
       	   try {
       	     if (con != null) { con.close(); }
       	   }
       	   catch (Exception e) {
       	     // log this error
       	   }
        }
		return null;
    }
    
}
