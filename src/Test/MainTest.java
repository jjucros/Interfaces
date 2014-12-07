package Test;

import java.sql.SQLException;

import MySQL.MySQL_Conn;

public class MainTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		MySQL_Conn testConn = new MySQL_Conn("aps_datamodel", "root", "root");
		
		testConn.runQuery("select * from location");
		
		String []values = new String[4];
		values[0] = "WH10";		
		values[1] = "VILLAVICENCIO";
		values[2] = "350";
		values[3] = "PL";
		
		String query = " insert into LOCATION (ID, NAME, STORAGE_CAPACITY, CAPACITY_UOM)"
		        //+ " values ("+values[0]+", "+values[1]+", "+values[2]+", "+values[3]+")";
				+ " values (?, ?, ?, ?)";
		
		System.out.println(query);
		//testConn.runInsert(query, values);
		
		
		
		
		
	}

}
