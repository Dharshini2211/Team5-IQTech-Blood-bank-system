package bloodbanksystem1;
import java.sql.*;
import java.util.*;



public class JdbcDemo {
	//main program
	public static void main(String args[])throws Exception{
		System.out.println("-------Welcome to the Blood Bank System--------");
		System.out.println("Select Any required action from the List");
		System.out.println("1.Enter the details of the donor\n2.Update the details of the donor\n3.Display list of donors\n4.Delete a donor\n5.Display the Availability of Blood\n6.Edit Expiry Details of the Blood\n7.Increase the Quantity of Blood Available\n8.Decrease the Quantity of Blood Available");
		
		Scanner sc=new Scanner(System.in);
		
	    String url1="jdbc:mysql://localhost:3306/javajdbc?";
	    String uname1="vijayasri";
		String pass1="Vijaya@02";
		
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1 = DriverManager.getConnection(url1,uname1,pass1);
		
		switch(sc.nextInt()) {
		case 1:
			DonorDetails(con1); 
			break;
		case 2:
			EditDonorDetails(con1);
			break;
		case 3:
			DisplayDonorDetails(con1);
			break;
		case 4:
			DeleteDonor(con1,sc);
			break;
		case 5:
			DisplayBloodAvailability(con1);
			break;
		case 6:
			EditExpiryDate(con1,sc);
			break;
		case 7:
			EditBloodQuantityInc(con1,sc);
			break;
		case 8:
			EditBloodQuantityDec(con1,sc);
			break;
		}
		
	    con1.close();
	    sc.close();
			
	}
	public static void EditBloodQuantityInc(Connection con1, Scanner sc)throws Exception {
		System.out.println("BloodID\nA+ve = 1\nA-ve = 2\nB+ve = 3\nB-ve = 4\nO+ve = 5\nO-ve = 6\nAB+ve = 7\nAB-ve = 8");
		System.out.print("Enter the BloodId:");
		int id=sc.nextInt();
		System.out.print("Enter the units of blood to be Increased:");
		int units=sc.nextInt();
		String query="Update BloodAvailable SET BloodQuantity=BloodQuantity+? Where BloodID=?;";
		PreparedStatement pstmt = con1.prepareStatement(query);
		pstmt.setInt(1, units);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
		System.out.println("Successfully Updated the Blood Quantity");
		
	}

	public static void EditBloodQuantityDec(Connection con1, Scanner sc)throws Exception {
		System.out.println("BloodID\nA+ve = 1\nA-ve = 2\nB+ve = 3\nB-ve = 4\nO+ve = 5\nO-ve = 6\nAB+ve = 7\nAB-ve = 8");
		System.out.println("Enter the BloodId:");
		int id=sc.nextInt();
		System.out.print("Enter the units of blood to be Decreased:");
		int units=sc.nextInt();
		String query="Update BloodAvailable SET BloodQuantity=BloodQuantity-? Where BloodID=?;";
		PreparedStatement pstmt = con1.prepareStatement(query);
		pstmt.setInt(1, units);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
		System.out.println("Successfully Updated the Blood Quantity");
		
		
	}
	
}
