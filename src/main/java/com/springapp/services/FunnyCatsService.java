package com.springapp.services;

import com.springapp.model.FunnyCat;
import com.springapp.persistance.KittensDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
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
    private DataSource dataSource;

    private List<FunnyCat> funnyCats = new ArrayList<FunnyCat>()/* {{
        add(new FunnyCat("simon", "one.gif", null));
        add(new FunnyCat("lucky", "two.gif", null));
        add(new FunnyCat("tom", "three.gif", null));
    }}*/;

    public FunnyCat getFunnyCatByName(String name) {
        List<FunnyCat> cats = kittensDao.listKittens();
        for (FunnyCat cat : funnyCats) {
            if (cat.getName().trim().toLowerCase().equals(name.toLowerCase())) {
                return cat;
            }
        }
        return new FunnyCat("", null);
    }

    public void addNewFunnyCat(FunnyCat cat) {
//        cat.setName(defaultKittenName);
        funnyCats.add(cat);
        kittensDao.saveKitten(cat);
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

    public int getFunnyCatCount() {
        return funnyCats.size();
    }

    public FunnyCat[] getAllCatsAsArray() {
        return funnyCats.toArray(new FunnyCat[funnyCats.size()]);
    }
}
