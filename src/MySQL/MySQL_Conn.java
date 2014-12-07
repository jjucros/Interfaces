package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class MySQL_Conn {
	private Connection con;
	private Statement st;
	private ResultSet rs;

	/**
	 * Constructor para la conexión
	 * @param db
	 * @param username
	 * @param pass
	 */
	public MySQL_Conn(String db, String username, String pass){
		try{
			/**
			 * Resgister the JDBC Driver: I need to initialize a driver so I can open a connection with the DB  
			 */
			Class.forName("com.mysql.jdbc.Driver");
			
			
			/**
			 * Opening the connection
			 */
			System.out.println("Connecting to the " + db + "database...");
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aps_datamodel", "root", "root");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db, username, pass);
			st = con.createStatement();
			
		}
		catch(Exception ex){
			System.out.println("Error: "+ex);
		}
	}
	
	/**
	 * Procedimiento para traer información de una o varias tablas desde la BD
	 * @param selectSQL
	 */
	public void runQuery(String selectSQL){
		try{
			//query = "select * from location";
			rs = st.executeQuery(selectSQL);
			
			System.out.println("Records from DataBase: \n");
			while(rs.next()){
				String locID = rs.getString("id");
				String locName = rs.getString("name");
				System.out.println("ID: "+locID+" \t Name: "+locName+" ");
			}
			
			
		}
		catch(Exception ex){
			System.out.println("Error: "+ex);
		}

	}
	
	/**
	 * Procedimiento para insertar datos en una tabla en la BD
	 * @param insertSQL
	 * @throws SQLException 
	 */
	public void runInsert(String insertSQL, String [] values) throws SQLException{
		/*
		 * Hay que trabajar más en esta función: pensar bien como se quiere
		 * 		--> Parámetros dinamicos o estaticos??
		 * 		--> Usar JPA
		 * 		--> Etc.
		 */
		
		//Inicialmente solo se inserta en la tabla de Locations
		
	      // Se crea un PreparedStatement para poder hacer el INSERT
	      PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(insertSQL);
	      
	      int numPar = 0;
	      numPar = values.length;
	      int i=1;
	      while(i <= numPar){
	    	  preparedStmt.setString (i, values[i-1]);
	    	  i++;	    	  
	      }
	      //Se agregan uno a uno los diferentes campos que se van a insertar
	      //preparedStmt.setString (1, locID);
	      //preparedStmt.setString (2, locName);
	      
	      //preparedStmt.setDouble(3, locCapacity);		      
	      //preparedStmt.setString (4, capUOM);
	      
	      
	 	// execute the preparedstatement
	      preparedStmt.execute();

		
	}
}
