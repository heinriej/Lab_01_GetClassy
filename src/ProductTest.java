import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Laptop", "High-end gaming laptop", "A12345", 1499.99);
    }

    @Test
    void testConstructor() {
        assertEquals("Laptop", product.getName());
        assertEquals("High-end gaming laptop", product.getDescription());
        assertEquals("A12345", product.getID());
        assertEquals(1499.99, product.getCost());
    }

    @Test
    void testSetName() {
        product.setName("Smartphone");
        assertEquals("Smartphone", product.getName());
    }

    @Test
    void testSetDescription() {
        product.setDescription("Latest model smartphone with 5G");
        assertEquals("Latest model smartphone with 5G", product.getDescription());
    }

    @Test
    void testSetID() {
        product.setID("B67890");
        assertEquals("B67890", product.getID());
    }

    @Test
    void testSetCostValid() {
        product.setCost(999.99);
        assertEquals(999.99, product.getCost());
    }

    @Test
    void testSetCostInvalid() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> product.setCost(-100)
        );
        assertEquals("Cost cannot be negative", exception.getMessage());
    }

    @Test
    void testToCSVDataRecord() {
        assertEquals("A12345, Laptop, High-end gaming laptop, 1499.99", product.toCSV());
    }

    @Test
    void testToJSON() {
        Product product = new Product("Tablet", "Lightweight tablet", "C98765", 299.99);
        assertEquals("{\"name\":\"Tablet\",\"description\":\"Lightweight tablet\",\"ID\":\"C98765\",\"cost\":299.99}",
                product.toJSON());
    }

    @Test
    void testToXML() {
        Product product = new Product("Monitor", "4K Ultra HD Monitor", "D54321", 499.99);
        assertEquals("<Product><Name>Monitor</Name><Description>4K Ultra HD Monitor</Description><ID>D54321</ID><Cost>499.99</Cost></Product>",
                product.toXML());
    }
}
