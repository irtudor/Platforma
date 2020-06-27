package services;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.apache.commons.io.FileUtils;
import javax.swing.*;


public class UsersService {
    private static List<User> users;
    private static final Path USERS_PATH=FileSystemService.getPathToFile("config","users.json");

    public static void loadUsersFromFile()throws IOException{
        if (!Files.exists(USERS_PATH)) {
            FileUtils.copyURLToFile(UsersService.class.getClassLoader().getResource("users.json"), USERS_PATH.toFile());
        }
    }
    ObjectMapper objectMapper = new ObjectMapper();
        /*objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);*/
    users = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<User>>() {
    })
}
