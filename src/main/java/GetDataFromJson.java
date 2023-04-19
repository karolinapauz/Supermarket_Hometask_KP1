import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import enitity.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GetDataFromJson {
    public List<User> getDataFromJsonToList() throws IOException {
        String file = "src/main/resources/users.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));

        ObjectMapper mapper = new ObjectMapper();

        List<User> users = mapper.readValue(json, new TypeReference<>() {
        });

        return users;
    }
}
