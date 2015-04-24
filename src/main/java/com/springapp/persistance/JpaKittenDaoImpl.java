package com.springapp.persistance;

import com.springapp.model.FunnyCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Кирилл Кин
 * @created 24.04.2015
 */
@Repository
//@Transactional
public class JpaKittenDaoImpl implements KittensDao {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void saveKitten(final FunnyCat funnyCat) {
        transactionTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus transactionStatus) {
                try {
                    em.persist(funnyCat);
                } catch (RuntimeException e) {
                    transactionStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });

    }

    @Override
    public List<FunnyCat> listKittens() {
        Query query = em.createQuery("SELECT s FROM FunnyCat s");
        return (List<FunnyCat>)query.getResultList();
    }
}
