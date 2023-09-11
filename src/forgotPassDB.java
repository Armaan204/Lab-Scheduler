import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class forgotPassDB extends User{
	
	private static int number = (int)(Math.random()*(1000000)+0);
    private static String seccode = String.format("%06d", number);
    static String email;
    
    public forgotPassDB(String mail) {
    	email = mail;
    }
	
    public void createCode() throws Exception{
    	Connection con = null;
    	PreparedStatement posted = null;

        try{
            con = super.getConnection();
        	Statement stmt = con.createStatement();
            // Use TRUNCATE
            String sql = "TRUNCATE securityCode";
            // Execute deletion
            stmt.executeUpdate(sql);
            // Use DELETE
            sql = "DELETE FROM securityCode";
            // Execute deletion
            stmt.executeUpdate(sql);
            
            posted = con.prepareStatement("INSERT INTO securityCode (code) VALUES ('"+seccode+"')");
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
    
    public String getSecurityCode() {
        return seccode;
    }
    
    public ArrayList<String> resetEmailExists() throws Exception{
    	Connection con = null;
    	PreparedStatement statement = null;
        try{
            con = super.getConnection();
            statement = con.prepareStatement("SELECT email FROM Users");
            ResultSet result = statement.executeQuery();
            
            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                array.add(result.getString("email"));
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
    
    public ArrayList<String> codeExists() throws Exception{
    	Connection con = null;
    	PreparedStatement statement = null;
        try{
            con = super.getConnection();
            statement = con.prepareStatement("SELECT code FROM securityCode");

            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                array.add(result.getString("code"));
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
    
    public void editUser(String em, String pass) throws Exception{
    	String email = em;
    	String newpass = pass;
    	String finalpass = super.encryptPassword(newpass);
    	Connection con = null;
    	PreparedStatement posted = null;

        try{
            con = super.getConnection();
            posted = con.prepareStatement("UPDATE Users SET password=? WHERE email=?");
            posted.setString(1, finalpass);
            posted.setString(2, email);
        	int delete = posted.executeUpdate();
        	if(delete == 1){
        		System.out.println("Password Changed");
        	}
            
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
}
