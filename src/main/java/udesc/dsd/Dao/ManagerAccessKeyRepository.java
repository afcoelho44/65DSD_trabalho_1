package udesc.dsd.Dao;

import java.util.HashSet;
import java.util.List;

public interface ManagerAccessKeyRepository {
    HashSet<String> getAll();
    void add(String code);
}
