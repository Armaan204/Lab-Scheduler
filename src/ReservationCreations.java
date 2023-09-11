import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ReservationCreations extends User{
	static int id;
    static String date;
    static String time;
    static String title;
    static String description;
    static String labtype;
    
    public void refreshDatabase(String lab) throws Exception{
    	labtype = lab;
    	Connection con = null;
    	PreparedStatement posted = null;
    	PreparedStatement posted1 = null;
        try{
            con = super.getConnection();
            posted = con.prepareStatement("SELECT rdate FROM " + labtype);
    		posted1 = con.prepareStatement("DELETE FROM " + labtype + " WHERE rdate =?");
            ResultSet result = posted.executeQuery();
            
			String now = LocalDateTime.now().toString();
			Date present = null;
			Date checkdate = null;
			
			try {
				present = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(now);
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
            
            ArrayList<String> dates = new ArrayList<String>();
            while(result.next()){
            	String tempdate = result.getString("rdate");
    			try {
    				checkdate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(tempdate);
    			} catch (ParseException e2) {
    				e2.printStackTrace();
    			}
    			
            	if(checkdate.compareTo(present) < 0) {
                    posted1.setString(1, tempdate);
                    posted1.executeUpdate();
            	}
            }
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Old Reservations Deleted!");
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
    
    public void reserveR(int ids, String dte, String tme, String ttl, String dscrptn, String lt) throws Exception{
    	String labtype = lt;
    	id = ids;
        date = dte;
        time = tme;
        title = ttl;
        description = dscrptn;
    	Connection con = null;
    	PreparedStatement posted = null;
        try{
            con = super.getConnection();
            posted = con.prepareStatement("INSERT INTO " + labtype + " (rdate, rtime, rtitle, rdescription, id) VALUES ('"+date+"', '"+time+"', '"+title+"', '"+description+"', '"+id+"')");
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
    
    public ArrayList<String> rAlreadyExists(String lt) throws Exception{
    	String labtype = lt;
    	Connection con = null;
    	PreparedStatement statement = null;
        try{
            con = super.getConnection();
            statement = con.prepareStatement("SELECT rdate,rtime FROM " + labtype);

            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                array.add(result.getString("rdate"));
                array.add(result.getString("rtime"));
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
