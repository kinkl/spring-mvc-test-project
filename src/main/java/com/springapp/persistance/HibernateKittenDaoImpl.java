package com.springapp.persistance;

import com.springapp.model.FunnyCat;

import java.util.List;

/**
 * Created by Kin on 23.04.2015.
 */
//@Repository
public class HibernateKittenDaoImpl implements KittensDao {
//    @Autowired
//    private SessionFactory sessionFactory;

    @Override
    public void saveKitten(FunnyCat funnyCat) {
//        sessionFactory.getCurrentSession().save(funnyCat);
    }

    @Override
    public List<FunnyCat> listKittens() {
//        Session currentSession = sessionFactory.getCurrentSession();
//        List<FunnyCat> cats = currentSession.createQuery("from FunnyCat").list();
        return null;//cats;
    }
}
