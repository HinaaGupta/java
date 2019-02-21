import java.sql.*;
import java.util.*;
public class UpdateDemo {
	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		int cnt=0;
		String sqlUpdate;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3307/classicmodels","root","himani123");
				
				sqlUpdate="UPDATE employees "+"SET jobTitle=?"+"where employeeNumber=?";
				
			PreparedStatement pstmt=con.prepareStatement(sqlUpdate);
				
				Scanner s=new Scanner(System.in);
				System.out.println("Enter Employee ID:");
				int eid=s.nextInt();
				s.hasNextLine();
				System.out.println("Enter job title:");
				String strm=s.next();
				
				pstmt.setString(1,strm);
				pstmt.setInt(2,eid);
				
				int rowAffected=pstmt.executeUpdate();
				System.out.println("Row affected"+rowAffected);
				
				/* strm="Sales Head";
				eid=1370;
				pstmt.setString(1,strm);*/
				
				rowAffected=pstmt.executeUpdate();
				System.out.println("Row affected"+rowAffected);
			}
			catch(Exception e) {
				System.out.println(e);
			}
	}
}
