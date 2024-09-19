package uz.itpu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public abstract class AbstractRepository<T, ID> implements JpaRepository<T, ID> {
    public boolean existsById(ID id) {
        return findById(id).isPresent();
    }

    public void deleteById(ID id) {
        if (existsById(id)) {
            findById(id).ifPresent(this::delete);
        }
    }
}
