package HostelDAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO< T extends Serializable>   {
    T create();
    T read(int K);
    void  delete( T param);
    void  update( T param);
    List<T> getAll();
}
