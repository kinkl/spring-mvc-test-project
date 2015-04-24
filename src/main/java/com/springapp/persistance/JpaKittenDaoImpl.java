package com.springapp.persistance;

import com.springapp.model.FunnyCat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Кирилл Кин
 * @created 24.04.2015
 */
@Repository
@Transactional
public class JpaKittenDaoImpl implements KittensDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveKitten(FunnyCat funnyCat) {
        em.persist(funnyCat);
    }

    @Override
    public List<FunnyCat> listKittens() {
        Query query = em.createQuery("SELECT s FROM FunnyCat s");
        return (List<FunnyCat>)query.getResultList();
    }
}
