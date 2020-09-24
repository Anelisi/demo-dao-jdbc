package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n==== Test 1: Department FindById ====\n");

        Department department = departmentDao.findById(4);
        System.out.println(department);

        System.out.println("\n==== Test 2: Department FindAll ====\n");

        List<Department> list = departmentDao.finAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

//        System.out.println("\n==== Test 3: Department Insert ====\n");
//
//        Department newDepartment = new Department(null,"Games");
//        departmentDao.insert(newDepartment);
//
//        System.out.println("Inserted! New id = " + newDepartment.getId());
//
        System.out.println("\n==== Test 4: Department Update ====\n");
        department = departmentDao.findById(6);

        department.setName("Foods");
        departmentDao.update(department);

        System.out.println("Update completed!");


        System.out.println("\n==== Test 5: Department Delete ====\n");
        System.out.println("Enter Id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);

        System.out.println("Id deleted successfully!");
    }
}
