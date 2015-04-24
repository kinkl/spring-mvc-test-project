package com.springapp.persistance;

import com.springapp.model.FunnyCat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Кирилл Кин
 * @created 24.04.2015
 */
public interface JpaRepositoryKittenDao extends JpaRepository<FunnyCat, Long> {
}
