package Test;

import MySQL.MySQL_Conn;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySQL_Conn testConn = new MySQL_Conn("aps_datamodel", "root", "root");
		
		testConn.runQuery("select * from location");
		
		String query = " insert into LOCATION (ID, NAME, STORAGE_CAPACITY, CAPACITY_UOM)"
		        + " values (?, ?, ?, ?)";
		
		
		
		
		
	}

}
