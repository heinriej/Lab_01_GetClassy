import java.util.Objects;

public class Product {
    private String ID;
    private String name;
    private String description;
    private double cost;

    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        this.cost = cost;
    }

    public String toCSV() {
        return ID + ", " + name + ", " + description + ", " + cost;
    }

    public String toJSON() {
        return String.format("{\"name\":\"%s\",\"description\":\"%s\",\"ID\":\"%s\",\"cost\":%.2f}",
                name, description, ID, cost);
    }

    public String toXML() {
        return String.format("<Product><Name>%s</Name><Description>%s</Description><ID>%s</ID><Cost>%.2f</Cost></Product>",
                name, description, ID, cost);
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.cost, cost) == 0 && Objects.equals(ID, product.ID) && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, description, cost);
    }
}
