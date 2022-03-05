package bloodbanksystem1;
import java.sql.*;
import java.util.*;



public class JdbcDemo {
	public static void main(String args[])throws Exception{
		System.out.println("-------Welcome to the Blood Bank System--------");
		System.out.println("Select Any required action from the List");
		System.out.println("1.Enter the details of the donor\n2.Edit the details of the donor\n3.");
		
		Scanner sc=new Scanner(System.in);
		
	    String url1="jdbc:mysql://localhost:3306/javajdbc?";
	    String uname1="vijayasri";
		String pass1="Vijaya@02";
		
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1 = DriverManager.getConnection(url1,uname1,pass1);
		
		switch(sc.nextInt()) {
		case 1:
			System.out.println("Enter the Details of the Donor:");
			System.out.print("Enter the First Name:");
			String firstName=sc.next();
			System.out.print("Enter the Last Name:");
			String lastName=sc.next();
			System.out.print("Enter the Blood Group:");
			String bloodGroup=sc.next();
			System.out.print("Enter the Age:");
			int age=sc.nextInt();
			System.out.print("Enter the Gender:");
			String gender=sc.next();
			System.out.print("Enter the Address:");
			String address=sc.next();
			System.out.print("Enter the Phone Number:");
			String phoneNo=sc.next();
			System.out.print("Enter the Date of Last Donation(YYYY-MM-DD):");
			String dateOfLastDonation=sc.next();
			String query="insert into BloodBank(FirstName,LastName,BloodGroup,Age,Gender,Address,PhoneNumber,DateOfLastDonation) values(?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt = con1.prepareStatement(query); 
			pstmt.setString(1,firstName);
			pstmt.setString(2,lastName);
			pstmt.setString(3,bloodGroup);
			pstmt.setInt(4,age);
			pstmt.setString(5,gender);
			pstmt.setString(6,address);
			pstmt.setString(7,phoneNo);
			pstmt.setString(8,dateOfLastDonation);
			pstmt.executeUpdate();
			System.out.println("Inserted"); 
			break;
		}
	    con1.close();
	    sc.close();
			
	}

}
