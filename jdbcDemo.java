package bloodbanksystem1;
import java.sql.*;

public class JdbcDemo{
  public static void main(String args[]){  
  try{  
    Class.forName("com.mysql.cj.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javajdbc?","vijayasri","Vijaya@02");
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select FirstName from bloodbank where ID=1");  
     rs.next();
     String name=rs.getString(1);
      System.out.println(name);
     st.close();
     con.close();
    }catch(Exception e){
      System.out.println(e);
    }  
}  
}  
}
