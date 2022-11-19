package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DatabaseConnectionFactory;

public class ProductDAO {
	private static Connection con=null;
	private static ResultSet result=null;
	private static Statement stmt=null;
	private static PreparedStatement pstmt=null;
	
	public ProductDAO() {
		try {
			DatabaseConnectionFactory dc=new DatabaseConnectionFactory();
			con=dc.getConnection();
			stmt=con.createStatement();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet getAllProducts() {
		try {
			String prodQuery="select * from products";
			result=stmt.executeQuery(prodQuery);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void addProduct() {
		try {
			String addQuery="INSERT INTO products(product_code,product_name,quantity,product_price) VALUES('abc','name',15,200)";
			 pstmt = (PreparedStatement) con.prepareStatement(addQuery);
			 pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void deleteProduct() {
		try {
			String query="delete from products where product_id=100";
			 pstmt = (PreparedStatement) con.prepareStatement(query);
	         pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static ResultSet viewAllProducts() {
		try {
			 String query = "SELECT * FROM products ORDER BY product_id";
			 result=stmt.executeQuery(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ProductDAO pd=new ProductDAO();
		ResultSet rs=pd.getAllProducts();
		pd.addProduct();
		/*while(rs.next()) {
			System.out.println(rs.getInt(1));
		}
		pd.deleteProduct();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+rs.getInt(2));
		}*/
		
		rs=pd.viewAllProducts();
		while(rs.next()) {
			System.out.println(rs.getInt(1));
		}
		

	}

}
