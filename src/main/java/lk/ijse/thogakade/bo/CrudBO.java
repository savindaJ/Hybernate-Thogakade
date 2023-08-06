package lk.ijse.thogakade.bo;

import java.util.List;

public interface CrudBO <T,J> extends SuperBO{
    boolean save(T dto);
    boolean update(T dto);
    boolean delete(J id);
    List<T> getAll();
    T getItem(J id);

}
