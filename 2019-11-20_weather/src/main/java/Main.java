import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        City city = mapper.readValue(new URL("https://api.openweathermap.org/data/2.5/weather?q=Berlin,de&appid=1ad60fb49ce3abda1ffee4f0952eacb9"), City.class);

        System.out.println(city);
    }
}
