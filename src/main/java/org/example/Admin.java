package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Admin {
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    private String adminName;

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    private String adminPass;
    private ArrayList<Product> products;
    private ArrayList<User> users;
    public void listProducts(){
        for(int i = 0 ; i<products.size(); i++){
            System.out.println(products.get(i));
        }
    }
    public void listUsers(){
        for(int i = 0 ; i<users.size(); i++){
            System.out.println(users.get(i));
        }
    }
    public void removeProduct(String id){
        for(int i = 0 ; i<products.size(); i++){
            if(Objects.equals(products.get(i).getId(), id)){
                products.remove(i);
            }
        }
    }
    public boolean removeUser(String name){
        for(int i = 0 ; i<users.size(); i++){
            if(Objects.equals(users.get(i).getUsername(), name)){
                users.remove(i);
                return true;
            }
        }
        return false;
    }
    public void addProduct(String name,String id,int quantity){
        Product p = new Product(name,id,quantity);
        products.add(p);
    }

    public boolean checkLogin(String username,String password){
        if(username == adminName){
            if(password == adminPass){
                System.out.println("welcome " + adminName);
                return true;
            }
            else {
                System.out.println("wrong password");
                return false;
            }
        }
        System.out.println("invalid username");
        return false;
    }
    public Admin(ArrayList<Product> products,ArrayList<User> users,String adminName,String adminPass){
        this.products = products;
        this.users = users;
        this.adminName = adminName;
        this.adminPass = adminPass;
    }
}
