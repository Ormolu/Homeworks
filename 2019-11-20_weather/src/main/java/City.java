import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    private String name;
    private int id;
    private float temp;

    public City(String name, int id, float temp) {
        this.name = name;
        this.id = id;
        this.temp = temp;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", temp=" + temp +
                '}';
    }
}
