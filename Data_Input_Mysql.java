package school_college;
import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;

public class Data_Input_Mysql {
	private static final String url = "jdbc:mysql://localhost:3306/kp";
    private static final String user = "root";
    private static final String password = "kush";
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queries q = new Queries();
		try {
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement st = con.prepareStatement(q.insert_query);
		ArrayList<Student_mysql> stud = new ArrayList<>();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
