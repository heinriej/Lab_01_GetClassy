import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person("John", "Doe", "12345", "Mr.", 1980);
    }

    @Test
    void testConstructor() {
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("12345", person.getID());
        assertEquals("Mr.", person.getTitle());
        assertEquals(1980, person.getYOB());
    }

    @Test
    void testFirstName() {
        person.setFirstName("Jane");
        assertEquals("Jane", person.getFirstName());
    }

    @Test
    void testLastName() {
        person.setLastName("Smith");
        assertEquals("Smith", person.getLastName());
    }

    @Test
    void testID() {
        person.setID("12345");
        assertEquals("12345", person.getID());
    }

    @Test
    void testTitle() {
        person.setTitle("Dr.");
        assertEquals("Dr.", person.getTitle());
    }

    @Test
    void testSetYOBValid() {
        person.setYOB(1975);
        assertEquals(1975, person.getYOB());
    }

    @Test
    void testSetYOBInvalid() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> person.setYOB(1939)
        );
        assertEquals("Year of birth must be between 1940 and 2000", exception.getMessage());
    }

    @Test
    void testFullName() {
        assertEquals("John Doe", person.getFullName());
    }

    @Test
    void testFormalName() {
        assertEquals("Mr.John Doe", person.getFormalName());
    }

    @Test
    void testGetAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        assertEquals(currentYear - 1980, person.getAge());
    }

    @Test
    void testGetAgeForSpecificYear() {
        assertEquals(40, person.getAge(2020));
    }

    @Test
    void testToCSVDataRecord() {
        assertEquals("12345, John, Doe, Mr., 1980", person.toCSVDataRecord());
    }

    @Test
    void testToJSON() {
        Person person = new Person("Sam", "Taylor", "77777", "Mr.", 1970);
        assertEquals("{\"firstName\":\"Sam\",\"lastName\":\"Taylor\",\"ID\":\"77777\",\"title\":\"Mr.\",\"YOB\":1970}",
                person.toJSON());
    }

    @Test
    void testToXML() {
        Person person = new Person("Laura", "Black", "33333", "Ms.", 2000);
        assertEquals("<Person><FirstName>Laura</FirstName><LastName>Black</LastName><ID>33333</ID><Title>Ms.</Title><YOB>2000</YOB></Person>",
                person.toXML());
    }
}
