package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
       String name;//這個是靜態class
       
       //下面的main是動態clas
	public static void main(String[] args) {
		//DBconnection db=new DBconnection();
		//System.out.println(db.name);
     System.out.println(DBconnection.getDB());
	}
	
     public static Connection getDB() 
     {
    	 Connection conn=null;
    	 
    	 String url="jdbc:mysql://localhost:3306/school";
    	 String user="root";
    	 String password="1234";
    	 
    	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 return conn;
     }

}
