package com.springapp.persistance;

import com.springapp.model.FunnyCat;

import java.util.List;

/**
 * @author Кирилл Кин
 * @created 22.04.2015
 */

public interface KittensDao {

    void saveKitten(FunnyCat funnyCat);
    List<FunnyCat> listKittens();
}
