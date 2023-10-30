package Pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectExecuteUpdateJDBC {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
Driver driver = new Driver();
		
		//step 1 : register the driver
		DriverManager.registerDriver(driver);
		
		//step 2 : get connection with db
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root", "tiger");
		
		//step 3 : issue create statement
		Statement state = con.createStatement();
		
		//step 4: execute a query
		String query = "insert into empinfo values('spy','NY',10);";
		int result = state.executeUpdate(query);
		if(result==1)
		
		{
			
			System.out.println("data added sucessfully");
		}
		
		//step 5 : close the db
		con.close();

	}

}
