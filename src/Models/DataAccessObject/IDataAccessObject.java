package Models.DataAccessObject;

import java.util.List;
import java.util.Optional;

public interface IDataAccessObject<T> {
     List<T> getAll();

     Optional<T> get(int ID);

     void create(T t);

     void update(T t);

     void delete(T t);

     void save();

     void load();
}
