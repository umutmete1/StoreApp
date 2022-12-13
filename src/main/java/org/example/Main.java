package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<User> users = new ArrayList<User>();
        products.add(new Product("test1", "01", 10));
        users.add(new User("umut", "123",products));
        users.add(new User("hasan", "123",products));
        users.add(new User("lütfi", "123",products));
        Admin admin = new Admin(products, users,"mete","123");
        System.out.println("1.Admin Login \n");
        System.out.println("2.User Login \n");
        Scanner scanner = new Scanner(System.in);
        int input1 = Integer.parseInt(scanner.nextLine());
        switch (input1) {
            case 1:
                System.out.println("Enter username \n");
                String adminName = scanner.nextLine();
                System.out.println("Enter password \n");
                String adminPass = scanner.nextLine();
                if(admin.checkLogin(adminName,adminPass)){
                    adminMenu(admin);
                }
                break;
            case 2:
                System.out.println("enter username \n");
                String username = scanner.nextLine();
                System.out.println("enter password \n");
                String userPass = scanner.nextLine();
                for (int i =0;i<users.size();i++){
                    if(Objects.equals(username, users.get(i).getUsername())){
                        if(Objects.equals(userPass, users.get(i).getPassword())){
                            userMenu(users.get(i));
                        }
                        else {
                            System.out.println("wrong password \n");
                            System.exit(0);
                        }
                    }
                }
                System.out.println("User is not found \n");
                System.exit(0);
        }
    }

    public static void adminMenu(Admin admin) {
        Scanner adminScanner = new Scanner(System.in);
        System.out.println("1.Manage products\n");
        System.out.println("2.Manage Users\n");
        System.out.println("3.exit \n");
        int adminInput = Integer.parseInt(adminScanner.nextLine());
        switch (adminInput) {
            case 1:
                admin.listProducts();
                System.out.println("1.Add Product\n");
                System.out.println("2.Remove Product\n");
                int productInput = Integer.parseInt(adminScanner.next());
                switch (productInput) {
                    case 1:
                        Scanner productScan = new Scanner(System.in);
                        System.out.println("Provide product name \n");
                        String productName = productScan.nextLine();
                        System.out.println("Provide product quantity \n");
                        int productQ = Integer.parseInt(productScan.nextLine());
                        System.out.println("Provide the id");
                        admin.addProduct(productName,productScan.nextLine(),productQ);
                        adminMenu(admin);
                        break;
                    case 2:
                        Scanner productScan2 = new Scanner(System.in);
                        System.out.println("provide product id \n");
                        String removeId = productScan2.nextLine();
                        admin.removeProduct(removeId);
                        adminMenu(admin);
                        break;
                }
                break;
            case 2:
                admin.listUsers();
                System.out.println("1.remove user \n");
                System.out.println("2.exit \n ");
                switch (Integer.parseInt(adminScanner.nextLine())){
                    case 1:
                        System.out.println("Enter user name \n");
                        admin.removeUser(adminScanner.nextLine());
                        adminMenu(admin);
                        break;
                    case 2:
                        System.exit(0);
                }
            case 3:
                System.exit(0);
        }
    }

    public static void userMenu(User user){
        user.listProducts();
        System.out.println("1.buy product\n");
        System.out.println("2.exit \n");
        Scanner scanner1 = new Scanner(System.in);
        switch (Integer.parseInt(scanner1.nextLine())){
            case 1:
                System.out.println("Enter the id \n");
                user.buy(scanner1.nextLine());
                userMenu(user);
                break;
            case 2:
                System.exit(0);
        }
    }
}