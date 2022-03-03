package bloodbanksystem1;
import java.sql.*;
import java.util.*;



public class JdbcDemo {
	public static void main(String args[])throws Exception{
		System.out.println("Welcome to the Blood Bank System");
		System.out.println("Select Any required action from the List");
		System.out.println("Enter the Details of the Donor");
		Scanner sc=new Scanner(System.in);
		String firstName=sc.next();
		String lastName=sc.next();
		String bloodGroup=sc.next();
		int age=sc.nextInt();
		String gender=sc.next();
		String address=sc.next();
		String phoneNo=sc.next();
		String dateOfLastDonation=sc.next();
		
	    String url1="jdbc:mysql://localhost:3306/javajdbc?";
	    String uname1="root";
		String pass1="";
		String query="insert into BloodBank(FirstName,LastName,BloodGroup,Age,Gender,Address,PhoneNumber,DateOfLastDonation"+ "values(?,?,?,?,?,?,?,?)";
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1 = DriverManager.getConnection(url1,uname1,pass1);
		
		PreparedStatement pstmt = con1.prepareStatement(query); 
		pstmt.setString(1, firstName);
		pstmt.setString(2, lastName);
		pstmt.setString(3, bloodGroup);
		pstmt.setInt(4, age);
		pstmt.setString(5, gender);
		pstmt.setString(6, address);
		pstmt.setString(7, phoneNo);
		pstmt.setString(8, dateOfLastDonation);
        System.out.println("Inserted");
		con1.close();
		sc.close();
	}

}
