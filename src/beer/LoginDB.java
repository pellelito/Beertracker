package beer;

import java.sql.*;  
  
public class LoginDB {  
public static boolean validate(String uname,String psw){  
boolean status=false;  
try{  
	Class.forName("com.mysql.jdbc.Driver"); 
	
	Connection con=DriverManager.getConnection(  
			
	"jdbc:mysql://localhost:8889/mooreBeerToThePeople",uname,psw);
	
	//here mooreBeerToThePeople is database name, root is username and password 
	
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from beers");
	status = rs.next(); 
	if(rs.next())  
		
	//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	
	con.close();  
	}catch(Exception e){ 
		System.out.println(e);
		}  

	return status;
	}  
	
public  String list(String uname,String psw,String table){ 
	StringBuilder str = new StringBuilder();
try{  
	Class.forName("com.mysql.jdbc.Driver"); 
	
	Connection con=DriverManager.getConnection(  
			
	"jdbc:mysql://localhost:8889/mooreBeerToThePeople",uname,psw);
	
	//here mooreBeerToThePeople is database name, 
	
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from "+table);
	
	int i= 0;
	while(rs.next())  
		if(table.equals("brewery")) {
			
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)); 
			str.append(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			str.append("<br>");
			
		}else if(table.equals("customers")) {
			
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
			str.append(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			str.append("<br>");
			
		}else if(table.equals("beers")) {
			
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getLong(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
			str.append(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
			str.append("<br>");
			
		}else if(table.equals("orders")) {
			
			System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+" " +rs.getInt(4));
			str.append(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" " +rs.getInt(4));
			str.append("<br>");
		}
	
	con.close();  
	}catch(Exception e){ 
		System.out.println(e);
		} 
	
	return str.toString();
	
	}  
	
public static void update(String uname,String psw, String table, String a,String b,String c, String d){  
 
try{  
	Class.forName("com.mysql.jdbc.Driver"); 
	
	Connection con=DriverManager.getConnection(  
			
	"jdbc:mysql://localhost:8889/mooreBeerToThePeople",uname,psw);
	
	//here mooreBeerToThePeople is database name, root is username and password 
	PreparedStatement ps = null;
	
	
	if (table.equals("customers")){
		System.out.println("In update customers");
		String sql= "INSERT INTO " + table + " (Customer_Name, Customer_Location) VALUES(?,?);";
		ps = con.prepareStatement(sql);
		ps.setString(1, a);
		ps.setString(2, b);
		int i = ps.executeUpdate();
		if(i != 0){
			System.out.println("Record Updated Successfully");   
		}
	} else if(table.equals("brewery")){
		System.out.println("In update brewery");
		String sql= "INSERT INTO " + table + " (Brewery_Name, Location) VALUES(?,?);";
		ps = con.prepareStatement(sql);
		ps.setString(1, a);
		ps.setString(2, b);
		int i = ps.executeUpdate();
		if(i != 0){
			System.out.println("Record Updated Successfully");
		}
	}else if(table.equals("beers")){
		
		System.out.println("In update beers");
		String sql= "INSERT INTO " + table + " (Beer_Name, In_Stock, Maker_ID, Price) VALUES(?,?,?,?);";
		ps = con.prepareStatement(sql);
		ps.setString(1, a);
		ps.setInt(2, Integer.parseInt(b));
		ps.setInt(3, Integer.parseInt(c));
		ps.setString(4, d);
		int i = ps.executeUpdate();
		if(i != 0){
			System.out.println("Record Updated Successfully");
		}
		
	}else if(table.equals("orders")){
		
		System.out.println("In update orders");
		
		String sql= "INSERT INTO " + table + " (Customer_ID, Beer_ID, Amount) VALUES(?,?,?);";
		ps = con.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(a));
		ps.setInt(2, Integer.parseInt(b));
		ps.setInt(3, Integer.parseInt(c));
		
		int i = ps.executeUpdate();
		if(i != 0){
			System.out.println("Record Updated Successfully");
		}

	}
	con.close();  
	}catch(Exception e){ 
		
		System.out.println(e);
		
		}  

	
	}  
}	 