import org.example.Admin;
import org.example.Product;
import org.example.User;
import org.junit.jupiter.api.*;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    @Test
    @DisplayName("Remove User Test")
    void adminShouldRemoveUser(){
        var product0 = new Product("p0","00",10);
        var product1 = new Product("p1","01",10);
        var product2 = new Product("p2","02",10);
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(product0);
        products.add(product1);
        products.add(product2);
        var user0 = new User("umut","123",products);
        var user1 = new User("hasan","456",products);
        var user2 = new User("doğa","789",products);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user0);
        users.add(user1);
        users.add(user2);
        var admin = new Admin(products,users,"doğa","3131");
        ArrayList<String> usersToBeRemoved = new ArrayList<>();
        usersToBeRemoved.add("hasan");
        usersToBeRemoved.add("doğa");
        int count=usersToBeRemoved.size();
        for (String s : usersToBeRemoved){
            if (count!=0){
                if(admin.removeUser(s)){
                    count--;
                }
            }

        }

        if(count == 0){
            return;
        }
        else {
            fail();
        }
    }

}
