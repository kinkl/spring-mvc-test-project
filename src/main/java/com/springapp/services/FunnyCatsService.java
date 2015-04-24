package com.springapp.services;

import com.springapp.model.FunnyCat;
import com.springapp.persistance.JpaRepositoryKittenDao;
import com.springapp.persistance.KittensDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Кирилл Кин
 * @created 21.04.2015
 */
@Service
public class FunnyCatsService {
    @Autowired
    private String defaultKittenName;

    @Autowired
    private KittensDao kittensDao;

    @Autowired
    private JpaRepositoryKittenDao jpaRepositoryKittenDao;

    @Autowired
    private DataSource dataSource;

//    private List<FunnyCat> funnyCats = new ArrayList<FunnyCat>();

    public FunnyCat getFunnyCatByName(String name) {
        List<FunnyCat> cats = jpaRepositoryKittenDao.findAll();//kittensDao.listKittens();
        for (FunnyCat cat : cats) {
            if (cat.getName().trim().toLowerCase().equals(name.toLowerCase())) {
                return cat;
            }
        }
        return new FunnyCat(null, "", null);
    }

    public void addNewFunnyCat(FunnyCat cat) {
//        cat.setName(defaultKittenName);
        //funnyCats.add(cat);
        jpaRepositoryKittenDao.save(cat); //kittensDao.saveKitten(cat);
//        Connection connection = null;
//        Statement statement = null;
//        try {
//            connection = dataSource.getConnection();
//            statement = connection.createStatement();
//            statement.execute("INSERT INTO cats (name) VALUES ('"+ cat.getName() +"')");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (statement != null) {
//                    statement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//
//            } catch (Exception e) {
//
//            }
//        }
    }

//    public int getFunnyCatCount() {
//        return funnyCats.size();
//    }

    public FunnyCat[] getAllCatsAsArray() {
        List<FunnyCat> cats = jpaRepositoryKittenDao.findAll();/*kittensDao.listKittens();*/
        return cats.toArray(new FunnyCat[cats.size()]);
    }
}
