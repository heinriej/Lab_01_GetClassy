import java.util.Calendar;
import java.util.Objects;

public class Person
{
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getYOB()
    {
        return YOB;
    }

    public void setYOB(int yob) {
        if (yob < 1940 || yob > 2000) {
            throw new IllegalArgumentException("Year of birth must be between 1940 and 2000");
        }
        this.YOB = yob;
    }

    public String getFullName()
    {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getFormalName()
    {
        return title + getFullName();
    }

    public int getAge()
    {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - YOB;
    }

    public int getAge(int year)
    {
        return year - YOB;
    }

    public String toCSVDataRecord()
    {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    public String toJSON() {
        return String.format("{\"firstName\":\"%s\",\"lastName\":\"%s\",\"ID\":\"%s\",\"title\":\"%s\",\"YOB\":%d}",
                firstName, lastName, ID, title, YOB);
    }

    public String toXML() {
        return String.format("<Person><FirstName>%s</FirstName><LastName>%s</LastName><ID>%s</ID><Title>%s</Title><YOB>%d</YOB></Person>",
                firstName, lastName, ID, title, YOB);
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", yearOfBirth=" + YOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB && Objects.equals(ID, person.ID) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(ID, firstName, lastName, title, YOB);
    }
}
