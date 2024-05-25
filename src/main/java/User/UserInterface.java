package User;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserInterface<K,V> {
    V create(V dto);
    V update(K id, V dto);
    V delete(K id);
    V get(K id);
    List<V> getAll();
}
