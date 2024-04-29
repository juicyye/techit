package network.netProject.psign.refac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private static Map<Long, Users> store = new HashMap<>();
    private static Long sequence = 0L;

    public Long save(Users users) {
        users.setId(++sequence);
        store.put(users.getId(), users);
        return users.getId();
    }

    public List<Users> findAll() {
        return new ArrayList<>(store.values());
    }

    public Users findById(Long id) {
        return store.get(id);
    }

    public Users findByName(String name) {
        return store.values().stream().filter(u -> u.getName().equals(name)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

}
