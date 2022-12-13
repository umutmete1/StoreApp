import org.example.Admin;
import org.example.Product;
import org.example.User;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AdminTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

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
        ArrayList<User> users = new ArrayList<User>();
        users.add(user0);
        users.add(user1);
        assertEquals("User{username='umut'}",outputStreamCaptor.toString()
                .trim());
    }

}
