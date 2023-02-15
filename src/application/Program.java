package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("_________Teste 1_______");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("TEST 2 ");
		Department dep = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		list.forEach(System.out::println);

		System.out.println("TEST 3 ");
		list = sellerDao.findAll();
		
		list.forEach(System.out::println);

		System.out.println("TEST 4 ");
		Seller newSeller = new Seller(null, "greg", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new Id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 6: seller delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");

		sc.close();
		
	}

}
