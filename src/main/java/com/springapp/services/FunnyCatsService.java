package com.springapp.services;

import com.springapp.model.FunnyCat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Кирилл Кин
 * @created 21.04.2015
 */
@Service
public class FunnyCatsService {

    private List<FunnyCat> funnyCats = new ArrayList<FunnyCat>()/* {{
        add(new FunnyCat("simon", "one.gif", null));
        add(new FunnyCat("lucky", "two.gif", null));
        add(new FunnyCat("tom", "three.gif", null));
    }}*/;

    public FunnyCat getFunnyCatByName(String name) {
        for (FunnyCat cat : funnyCats) {
            if (cat.getName().trim().toLowerCase().equals(name.toLowerCase())) {
                return cat;
            }
        }
        return new FunnyCat("", null);
    }

    public void addNewFunnyCat(FunnyCat cat) {
        funnyCats.add(cat);
    }

    public int getFunnyCatCount() {
        return funnyCats.size();
    }

    public FunnyCat[] getAllCatsAsArray() {
        return funnyCats.toArray(new FunnyCat[funnyCats.size()]);
    }
}
