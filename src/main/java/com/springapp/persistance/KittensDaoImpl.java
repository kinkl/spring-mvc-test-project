package com.springapp.persistance;

import com.springapp.model.FunnyCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Кирилл Кин
 * @created 22.04.2015
 */

public class KittensDaoImpl implements KittensDao {
    private static final String INSERT_SQL = "INSERT INTO cats(name, filename) VALUES (?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT name, filename FROM cats";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveKitten(FunnyCat funnyCat) {
        jdbcTemplate.update(INSERT_SQL, funnyCat.getName(), funnyCat.getFilename() != null ? funnyCat.getFilename() : "");
    }

    @Override
    public List<FunnyCat> listKittens() {
        List<FunnyCat> cats = jdbcTemplate.query(SELECT_ALL_SQL, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                //preparedStatement.set
            }
        }, new RowMapper<FunnyCat>() {
            @Override
            public FunnyCat mapRow(ResultSet resultSet, int i) throws SQLException {
                return new FunnyCat(resultSet.getString(1), resultSet.getString(2));
            }
        });
//        List<Map<String, Object>> fields = jdbcTemplate.queryForList("SELECT * FROM cats");
//        for (Map<String, Object> map : fields) {
//            //TODO - остановился здесь
//        }
        //List<FunnyCat> cats = jdbcTemplate.queryForList("SELECT * FROM cats", FunnyCat.class);
        return cats;
    }
}
