import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class User {
    static String fname;
    static String lname;
    static String emailad;
    static String username;
    static String password;
    static String encryptedpass;
    static int id;

    public static void saveUser(String firstname, String lastname, String mail, String usern, String pass) throws Exception{
        fname = firstname;
        lname = lastname;
        emailad = mail;
        username = usern;
        password = pass;
        encryptedpass = encryptPassword(password);
    	Connection con = null;
    	PreparedStatement posted = null;
    	PreparedStatement posted1 = null;
        try{
            con = getConnection();
            posted = con.prepareStatement("INSERT INTO Users (fname, lname, email, username, password) VALUES ('"+fname+"', '"+lname+"', '"+emailad+"', '"+username+"', '"+encryptedpass+"')");
            posted.executeUpdate();
            
            posted1 = con.prepareStatement("SELECT id FROM Users WHERE email =?");
            posted1.setString(1, emailad);
            ResultSet result = posted1.executeQuery();
            while(result.next()) {
            	id = result.getInt("id");
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
    
    public ArrayList<String> verifyEmail(String firstname, String lastname, String mail, String usern, String pass) throws Exception{
        fname = firstname;
        lname = lastname;
        emailad = mail;
        username = usern;
        password = pass;
    	Connection con = null;
    	PreparedStatement statement = null;
        try{
            con = getConnection();
            statement = con.prepareStatement("SELECT id,fname,lname,email,username,password FROM Users");

            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                array.add(result.getString("id"));
                array.add(result.getString("fname"));
                array.add(result.getString("lname"));
                array.add(result.getString("email"));
                array.add(result.getString("username"));
                array.add(result.getString("password"));
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

    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "your-database-url";
            String username = "your-database-username";
            String password = "your-database-password";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url,username,password);
            //System.out.println("Connected");
            return conn;
        } catch(Exception e){System.out.println(e);}


        return null;
    }
    
    
    
    public static String encryptPassword(String pass) {
    	String password = pass, encryptedpassword = "";
    	
    	for (int i=0;i<password.length();i++)  
        {  
            char ch=Character.toLowerCase(password.charAt(i));  
            switch (ch)  
            {  
            case 'a':  
                encryptedpassword=encryptedpassword+"{";  
                break;  
            case 'b':  
                encryptedpassword=encryptedpassword+"}";  
                break;  
            case 'c':  
                encryptedpassword=encryptedpassword+"#";  
                break;  
            case 'd':  
                encryptedpassword=encryptedpassword+"~";  
                break;  
            case 'e':  
                encryptedpassword=encryptedpassword+"+";  
                break;  
            case 'f':  
                encryptedpassword=encryptedpassword+"-";  
                break;  
            case 'g':  
                encryptedpassword=encryptedpassword+"*";  
                break;  
            case 'h':  
                encryptedpassword=encryptedpassword+"@";  
                break;  
            case 'i':  
                encryptedpassword=encryptedpassword+"/";  
                break;  
            case 'j':  
                encryptedpassword=encryptedpassword+"\\";  
                break;  
            case 'k':  
                encryptedpassword=encryptedpassword+"?";  
                break;  
            case 'l':  
                encryptedpassword=encryptedpassword+"$";  
                break;  
            case 'm':  
                encryptedpassword=encryptedpassword+"!";  
                break;  
            case 'n':  
                encryptedpassword=encryptedpassword+"^";  
                break;  
            case 'o':  
                encryptedpassword=encryptedpassword+"(";  
                break;  
            case 'p':  
                encryptedpassword=encryptedpassword+")";  
                break;  
            case 'q':  
                encryptedpassword=encryptedpassword+"<";  
                break;  
            case 'r':  
                encryptedpassword=encryptedpassword+">";  
                break;  
            case 's' :  
                encryptedpassword=encryptedpassword+"=";  
                break;  
            case 't':  
                encryptedpassword=encryptedpassword+";";  
                break;  
            case 'u':  
                encryptedpassword=encryptedpassword+",";  
                break;  
            case 'v' :  
                encryptedpassword=encryptedpassword+"_";  
                break;  
            case 'w':  
                encryptedpassword=encryptedpassword+"[";  
                break;  
            case 'x' :  
                encryptedpassword=encryptedpassword+"]";  
                break;  
            case 'y':  
                encryptedpassword=encryptedpassword+":";  
                break;  
            case 'z' :  
                encryptedpassword=encryptedpassword+"\"";  
                break;
            case '1':  
                encryptedpassword=encryptedpassword+"r";  
                break;  
            case '2':  
                encryptedpassword=encryptedpassword+"k";  
                break;  
            case '3':  
                encryptedpassword=encryptedpassword+"b";  
                break;  
            case '4':  
                encryptedpassword = encryptedpassword+"e";  
                break;  
            case '5':  
                encryptedpassword = encryptedpassword+"q";  
                break;  
            case '6':  
                encryptedpassword = encryptedpassword+"h";  
                break;  
            case '7':  
                encryptedpassword = encryptedpassword+"u";  
                break;  
            case '8' :  
                encryptedpassword= encryptedpassword+"y";  
                break;  
            case '9':  
                encryptedpassword = encryptedpassword+"w";  
                break;  
            case '0':  
                encryptedpassword = encryptedpassword+"z";  
                break;  
             default:  
                encryptedpassword=encryptedpassword+"0";  
                break; 
            }
    }  
    	
    	return encryptedpassword;
    }
    
    public static int getID() {
    	return id;
    }


}
