package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("----- Test #1: seller findById -----");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("--------------------------------------------");
        System.out.println();

        System.out.println("----- Test #2: seller findByDepartment -----");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(System.out::println);
        System.out.println("--------------------------------------------");
        System.out.println();

        System.out.println("----- Test #3: seller findAll -----");
        List<Seller> list1 = sellerDao.findAll();
        list1.forEach(System.out::println);
        System.out.println("--------------------------------------------");
        System.out.println();

        System.out.println("----- Test #4: seller insert -----");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
        System.out.println("--------------------------------------------");
        System.out.println();

        System.out.println("----- Test #5: seller update -----");
        seller = sellerDao.findById(1);
        seller.setName("Marta Wayne");
        seller.setEmail("marta@gmail.com");
        sellerDao.update(seller);
        System.out.println("Update completed");
        System.out.println("--------------------------------------------");

    }
}

