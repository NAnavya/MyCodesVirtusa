package com.virtusa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.virtusa.entity.CartEntity;
import com.virtusa.exception.ProductException;
import com.virtusa.jdbc.DatabaseConnection;

public class CartRepository {

	CartEntity cart = new CartEntity();
	private PreparedStatement stmt = null;
	private PreparedStatement stmt1 = null;
	private PreparedStatement stmt2 = null;
	private PreparedStatement stmt3 = null;
	private PreparedStatement stmt4 = null;
	private PreparedStatement stmt5 = null;
	private Connection connection = DatabaseConnection.getConnection();
	Scanner sc;
	private static final String INSERT_QUERY = "insert into cart(userid,productid,productname,productquantity,cost) values (?,?,?,?,?)";
	private static final String PRODUCTS_QUERY = "select userid,productid,productname,productcost from products where productid =?";
	private static final String GETUSERIDFROMREGISTRATION = "select userid from registration where useremail=?";
	private static final String VIEWCART = "select productid,productname,productquantity,cost from cart where userid=?";
	private static final String COSTCALCULATION = "select sum(cost) from cart where userid =?";
	private static final String PRODUCTQUANTITY = "select productquantity from products where productid=?";
	private static final String UPDATEPRODUCTQUANTITY = "update products set productquantity=? where productid=?";
	private static final String UPDATECART = "update cart set productquantity = ?,cost=? where userid=? and productid =?";

	Logger logger = Logger.getLogger(CartRepository.class.getName());

	public void addToCart(int id,int upq,String str) {

		try {
			stmt3 = connection.prepareStatement(PRODUCTQUANTITY);
			stmt3.setInt(1, id);
			ResultSet rs2 = stmt3.executeQuery();
			rs2.next();
			int pq = rs2.getInt(1);
			if(upq > pq) {
				logger.info("Product Quantity is exceeded");
			}
			else {
				stmt4 = connection.prepareStatement("select productcost from products where productid=? ");
				stmt4.setInt(1,id);
				ResultSet rs3 = stmt4.executeQuery();
				rs3.next();
				int cost = rs3.getInt(1);
				stmt5 = connection.prepareStatement(UPDATEPRODUCTQUANTITY);
				stmt5.setInt(1, pq-upq);
				stmt5.setInt(2, id);
				stmt5.executeUpdate();
				stmt = connection.prepareStatement(GETUSERIDFROMREGISTRATION);
				stmt.setString(1, str);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				int uid = rs.getInt(1);
				stmt1 = connection.prepareStatement(PRODUCTS_QUERY);
				stmt1.setInt(1, id);
				ResultSet rs1 = stmt1.executeQuery();
				while(rs1.next()) {
					stmt2 = connection.prepareStatement(INSERT_QUERY);
					stmt2.setInt(1, uid);
					stmt2.setInt(2, rs1.getInt(2));
					stmt2.setString(3, rs1.getString(3));
					stmt2.setInt(4, upq);
					stmt2.setInt(5, cost*upq);
					stmt2.executeUpdate();
				}
				logger.info("Cart updated");
			}

		} catch (SQLException e) {
			logger.info("Failed!!");
		}

	}
	public boolean viewCart(String str1) {
		try {
			stmt1 = connection.prepareStatement(GETUSERIDFROMREGISTRATION);
			stmt1.setString(1, str1);
			ResultSet rs1 = stmt1.executeQuery();
			rs1.next();
			int uid = rs1.getInt(1);
			stmt = connection.prepareStatement(VIEWCART);
			stmt.setInt(1, uid);
			ResultSet rs = stmt.executeQuery();
			int c=0;
			while(rs.next()) {
				cart.setProductid(rs.getInt(1));
				cart.setProductname(rs.getString(2));
				cart.setproductquantity(rs.getInt(3));
				cart.setCost(rs.getInt(4));
				logger.log(java.util.logging.Level.SEVERE, "{0}",cart);
				c=c+1;
			}
			if(c>0)
				return true;
		} catch (SQLException e) {
			logger.info("failed");
		}
		return false;
	}
	public boolean bookProducts(String str1) {
		try {
			stmt1 = connection.prepareStatement(GETUSERIDFROMREGISTRATION);
			stmt1.setString(1, str1);
			ResultSet rs1 = stmt1.executeQuery();
			rs1.next();
			int uid = rs1.getInt(1);
			stmt = connection.prepareStatement(COSTCALCULATION);
			stmt.setInt(1, uid);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int totalCost = rs.getInt(1);
			if(totalCost!=0) {
				logger.info("Total Cost to be paid");
				logger.log(java.util.logging.Level.SEVERE, "{0}", totalCost);
				return true;
			}
		} catch (SQLException e) {
			logger.info("Failed!");
		}
		return false;
	}
	public void getMetaData() {
		
		try {
			stmt = connection.prepareStatement("select *from cart");
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData)rs.getMetaData();
			logger.info("Total columns.."+rsmd.getColumnCount());
			logger.info("Column Name and Type of 1st Column..."+rsmd.getColumnName(1)+
					" "+rsmd.getColumnTypeName(1));
		} catch (SQLException e) {
			logger.info("Failed");
		}
		
	}
	public void updateCart(String str1) {
		
		try {
			sc = new Scanner(System.in);
			stmt = connection.prepareStatement(GETUSERIDFROMREGISTRATION);
			stmt.setString(1, str1);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int uid = rs.getInt(1);
			logger.info("Enter Product id to update product Quantity");
			int pid =sc.nextInt();
			stmt1 = connection.prepareStatement("select productquantity from products where productid =?");
			stmt1.setInt(1, pid);
			ResultSet rs1 = stmt1.executeQuery();
			rs1.next();
			int ppq = rs1.getInt(1);
			stmt2 = connection.prepareStatement("select productquantity from cart where productid=? and userid=?");
			stmt2.setInt(1, pid);
			stmt2.setInt(2, uid);
			ResultSet rs2 = stmt2.executeQuery();
			rs2.next();
			int cpq = rs2.getInt(1);
			stmt3 = connection.prepareStatement("select productcost from products where productid=?");
			stmt3.setInt(1, pid);
			ResultSet rs3 = stmt3.executeQuery();
			rs3.next();
			int cost = rs3.getInt(1);
			logger.info("Enter ProductQuantity to update");
			int pq = sc.nextInt();
			stmt4 = connection.prepareStatement(UPDATECART);
			stmt4.setInt(1, pq);
			stmt4.setInt(2, cost*pq);
			stmt4.setInt(3, uid);
			stmt4.setInt(4, pid);
			stmt4.executeUpdate();
			if((ppq+cpq)>pq) {
			stmt5 = connection.prepareStatement(UPDATEPRODUCTQUANTITY);	
			stmt5.setInt(1, (ppq+cpq)-pq);
			stmt5.setInt(2, pid);
			stmt5.executeUpdate();
			logger.info("Updation successful");
			}
			else {
				logger.info("ProductQuantity exceeded");
			}
		} catch (SQLException e) {
			logger.info("Failed!");
		}
		
	}
	public void deleteCart(String str1) {
		sc = new Scanner(System.in);
		try {
			stmt = connection.prepareStatement(GETUSERIDFROMREGISTRATION);
			stmt.setString(1, str1);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int uid = rs.getInt(1);
			logger.info("Enter Product id to delete");
			int pid = sc.nextInt();
			stmt2 = connection.prepareStatement("select count(*) from cart where productid = ? and userid =?");
			stmt2.setInt(1, pid);
			stmt2.setInt(2, uid);
			ResultSet rs1 = stmt2.executeQuery();
			rs1.next();
			int count = rs1.getInt(1);
			if(count > 0) {
				stmt1 = connection.prepareStatement("delete from cart where productid = ? and userid=?");
				stmt1.setInt(1, pid);
				stmt1.setInt(2, uid);
				stmt1.executeUpdate();
				logger.info("Deleted successfully");
			}
			else {
				throw new ProductException("This user's cart doesn't consist the productid given");
			}
		} catch (SQLException e) {
			logger.info("failed!!!!");
		}
		catch(ProductException e) {
			logger.info(e.getMessage());
		}
		
	}
	
}
