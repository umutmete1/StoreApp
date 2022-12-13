package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public boolean buy(String id){
        for(int i = 0 ; i<products.size(); i++){
            if(Objects.equals(products.get(i).getId(), id)){
                products.get(i).setQuantity(products.get(i).getQuantity()-1);
                return true;
            }
        }
        System.out.println("no item found from the id");
        return false;
    }

    public void listProducts(){
        for(int i = 0 ; i<products.size(); i++){
            System.out.println(products.get(i));
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    private ArrayList<Product> products = new ArrayList<Product>();

    public User(String username, String password,ArrayList<Product> products) {
        this.password = password;
        this.username = username;
        this.products = products;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
