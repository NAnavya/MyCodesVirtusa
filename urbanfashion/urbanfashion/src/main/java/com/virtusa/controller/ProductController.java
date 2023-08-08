package com.virtusa.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.virtusa.entity.ProductsEntity;
import com.virtusa.exception.ProductException;
import com.virtusa.repository.ProductRepository;
import com.virtusa.service.ProductService;
import com.virtusa.service.ProductServiceImplementation;

public class ProductController {

	Logger logger = Logger.getLogger(ProductController.class.getName());
	ProductRepository prorepo = new ProductRepository();
	ProductsEntity products = new ProductsEntity();
	ProductService service = new ProductServiceImplementation();
	Scanner sc;

	public void addProducts(String str1) {

		sc = new Scanner(System.in);
		int userid = prorepo.findUser(str1);
		try {
			if (userid != 0) {
				logger.info("Enter No of Products to be created");
				int n = sc.nextInt();
				int c = 1;
				while (n != 0) {
					logger.info("Enter Product ");
					logger.log(java.util.logging.Level.SEVERE, "{0}", c);
					sc.nextLine();
					logger.info("Enter Product Name ");
					products.setProductname(sc.nextLine());

					logger.info("Enter Product Size (XS/S/M/L/XL,XXL,XXXL)");
					String ps = sc.next();
					if(ps.equalsIgnoreCase("xs") || ps.equalsIgnoreCase("S") || 
							ps.equalsIgnoreCase("M") || ps.equalsIgnoreCase("L") ||
							ps.equalsIgnoreCase("xL") || ps.equalsIgnoreCase("XXL") || 
							ps.equalsIgnoreCase("XXXL") )
						products.setProductsize(ps);
					else
						throw new ProductException("Enter product size as mentioned above");
					logger.info("Enter Product Quantity");
					int pq = sc.nextInt();
					if (pq > 0)
						products.setProductquantity(pq);
					else {
						throw new ProductException("Enter valid product quantity");
					}

					logger.info("Enter Product Company Name");
					products.setProductcompany(sc.nextLine());
					
					sc.nextLine();
					logger.info("Enter Cost of the Product");
					products.setProductcost(sc.nextInt());

					service.createProducts(products, userid);
					n--;
					c++;
				}
			} else {
				logger.info("Failed!");
			}
		}catch (InputMismatchException e) {
			logger.info("Enter input carefully");
		} catch (ProductException pe) {
			logger.info(pe.getMessage());
		}
		
	}

}
