package udesc.dsd.Dao;

import java.util.HashSet;
import java.util.Set;

public class ManagerAccessKeyDao implements ManagerAccessKeyRepository{

    private final static Set<String> accessKeys = new HashSet<>();

    @Override
    public HashSet<String> getAll() {
        return (HashSet<String>) accessKeys;
    }

    @Override
    public void add(String code){
        accessKeys.add(code);
    }
}
