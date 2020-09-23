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

        System.out.println("\n==== Test 1: Seller FindById ====\n");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("\n==== Test 2: Seller FindByDepartment ====\n");

        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n==== Test 3: Seller FindAll ====\n");

        list = sellerDao.finAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n==== Test 4: Seller Insert ====\n");

        Seller newSeller = new Seller(null,"Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
    }
}
