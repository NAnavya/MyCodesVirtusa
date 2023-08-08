package com.virtusa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.virtusa.entity.ProductsEntity;
import com.virtusa.jdbc.DatabaseConnection;

public class ProductRepository {
	
	private static final String FOREIGNKEY_DISABLED = "SET FOREIGN_KEY_CHECKS=0";
	private static final String FOREIGNKEY_ENABLED = "SET FOREIGN_KEY_CHECKS=1";
	private static final String FINDUSERBYEMAILID = "select userid from registration where useremail=?";
	private static final String INSERTQUERY = "insert into products (productname,productsize,"
			+ "productquantity,productcompany,userid,productcost)"
			+ " values (?,?,?,?,?,?)";
	private static final String FINDPRODUCTS = "select count(*) from products";
	private static final String VIEWPRODUCTS = "select *from products";
	private static final String FINDPRODUCTSBYPID = "select count(*) from products where productid=?";
	private static final String UPDATEPRODUCTS = "update products set productsize=?,productquantity=? where productid=? ";
	private static final String VIEWPRODUCT_BYID = "select *from products where productid=	?";
	private static final String DELETEPRODUCT_BYID = "delete from products where productid=?";
	
	private Connection connection = DatabaseConnection.getConnection();
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	PreparedStatement stmt2 = null;
	Scanner sc;
	Logger logger = Logger.getLogger(ProductRepository.class.getName());
	int userid = 0;
	public int findUser(String checkemail) {
		try {
			stmt = connection.prepareStatement(FINDUSERBYEMAILID);
			stmt.setString(1, checkemail);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			userid = rs.getInt(1);
			return userid;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.info("Email doesn't Exist or This EmailID is not admin's");
		}
		
		return 0;
	}

	public void createProducts(ProductsEntity products, int uid) {
		
		try {
			stmt = connection.prepareStatement(INSERTQUERY);
			stmt.setString(1, products.getProductname());
			stmt.setString(2,products.getProductsize());
			stmt.setInt(3,products.getProductquantity());
			stmt.setString(4, products.getProductcompany());
			stmt.setInt(5, uid);
			stmt.setInt(6, products.getProductcost());
			stmt1 = connection.prepareStatement(FOREIGNKEY_DISABLED);
			stmt1.execute();
			stmt.executeUpdate();
			stmt2 = connection.prepareStatement(FOREIGNKEY_ENABLED);
			stmt2.execute();
			logger.info("Created Product Successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
			logger.info("Creation Failed");
		}
		
	}

	public boolean findProducts() {
		try {
			stmt = connection.prepareStatement(FINDPRODUCTS);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if(count!=0)
				return true;
		}
		catch(SQLException e) {
			logger.info("Failed!");
		}
		return false;
	}

	public List<ProductsEntity> viewProducts() {
		List<ProductsEntity> list = new ArrayList<>();
		try {
			stmt = connection.prepareStatement(VIEWPRODUCTS);
			ResultSet rs = stmt.executeQuery();
			ProductsEntity products = null;
			while(rs.next()) {
				products=new ProductsEntity();
				products.setProductid(rs.getInt(1));
				products.setProductname(rs.getString(2));
				products.setProductsize(rs.getString(3));
				products.setProductquantity(rs.getInt(4));
				products.setProductcompany(rs.getString(5));
				products.setUserid(rs.getInt(6));
				products.setProductcost(rs.getInt(7));
				list.add(products);
			}
		} catch (SQLException e) {
			logger.info("Failed!");
		}
		return list;
	}

	public boolean findProductsId(int pid) {
		try {
			stmt = connection.prepareStatement(FINDPRODUCTSBYPID);
			stmt.setInt(1, pid);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if(count > 0)
				return true;
		} catch (SQLException e) {
			logger.info("input Missmatch");
		}
		return false;
	}

	public void updateProducts(int productid) {
		
		try {
			sc = new Scanner(System.in);
			stmt = connection.prepareStatement(UPDATEPRODUCTS);
			logger.info("Enter product size to UPDATE..");
			stmt.setString(1, sc.next());
			logger.info("Enter product Quantity to UPDATE..");
			stmt.setInt(2, sc.nextInt());
			stmt.setInt(3, productid);
			stmt.executeUpdate();
			logger.info("Updation Successful");
		} catch (SQLException e) {
			logger.info("Updation Failed");
		}
	}

	public void viewProductById(ProductsEntity products, int pid) {
		try {
			stmt = connection.prepareStatement(VIEWPRODUCT_BYID);
			stmt.setInt(1,pid);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				products.setProductid(rs.getInt(1));
				products.setProductname(rs.getString(2));
				products.setProductsize(rs.getString(3));
				products.setProductquantity(rs.getInt(4));
				products.setProductcompany(rs.getString(5));
				products.setUserid(rs.getInt(6));
				products.setProductcost(rs.getInt(7));
				logger.log(java.util.logging.Level.SEVERE, "{0}", products);
			}
		} catch (SQLException e) {
			logger.info("Failed");
		}
		
	}

	public void deleteProducts(int id) {
		try {
			stmt = connection.prepareStatement(DELETEPRODUCT_BYID);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			logger.info("Deleted successfully");
			
		} catch (SQLException e) {
			logger.info("Failed");
		}
		
	}

	public boolean findProductsBySize(String size) {
		try {
			stmt = connection.prepareStatement("select count(*) from products where productsize = ?");
			stmt.setString(1, size);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if(count>0)
				return true;
		} catch (SQLException e) {
			logger.info("Failed!!!");
		}
		return false;
	}

	public void viewProductsBysize(String size) {
		
		try {
			ProductsEntity products = new ProductsEntity();
			stmt = connection.prepareStatement("select * from products where productsize = ?");
			stmt.setString(1, size);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				products.setProductid(rs.getInt(1));
				products.setProductname(rs.getString(2));
				products.setProductsize(rs.getString(3));
				products.setProductquantity(rs.getInt(4));
				products.setProductcompany(rs.getString(5));
				products.setUserid(rs.getInt(6));
				products.setProductcost(rs.getInt(7));
				logger.log(java.util.logging.Level.SEVERE, "{0}", products);
			}
			
		} catch (SQLException e) {
			logger.info("Failed!!!!");
		}
		
	}

}
