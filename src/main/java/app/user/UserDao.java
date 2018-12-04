package app.user;

import com.google.common.collect.*;
import java.util.*;
import java.util.stream.*;

public class UserDao {

    private final List<User> users = ImmutableList.of(
            new User(1L, "teste", "senha123")
    );

    public User getUserByUsername(String username) {
        return users.stream().filter(b -> b.getUsername().equals(username)).findFirst().orElse(null);
    }

    public Iterable<String> getAllUserNames() {
        return users.stream().map(User::getUsername).collect(Collectors.toList());
    }

}
