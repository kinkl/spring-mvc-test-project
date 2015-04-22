package com.springapp.persistance;

import com.springapp.model.FunnyCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Кирилл Кин
 * @created 22.04.2015
 */
@Component
public class KittensDaoImpl implements KittensDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveKitten(FunnyCat funnyCat) {
        jdbcTemplate.execute(String.format("INSERT INTO cats(name, filename) VALUES ('%s', '%s')", funnyCat.getName(), funnyCat.getFilename() != null ? funnyCat.getFilename() : ""));
    }

    @Override
    public List<FunnyCat> listKittens() {
        List<Map<String, Object>> fields = jdbcTemplate.queryForList("SELECT * FROM cats");
        for (Map<String, Object> map : fields) {
            //TODO - остановился здесь
        }
        List<FunnyCat> cats = jdbcTemplate.queryForList("SELECT * FROM cats", FunnyCat.class);
        return cats;
    }
}
