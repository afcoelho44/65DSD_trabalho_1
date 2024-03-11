package udesc.dsd.Dao;

import java.util.HashSet;

public interface ManagerAccessKeyRepository {
    HashSet<String> getAll();
    void add(String code);
}
