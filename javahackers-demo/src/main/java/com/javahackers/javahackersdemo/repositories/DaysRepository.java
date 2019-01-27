package com.javahackers.javahackersdemo.repositories;

import com.javahackers.javahackersdemo.entities.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;

public interface DaysRepository extends JpaRepository<Day, String> {

    Collection<Day> findByDateBetweenAndId(Date low, Date high, String id);

//    @Modifying
//    @Query(value = "insert into day(redirect,user_id) VALUES (:insertLink,:id)", nativeQuery = true)
//    @Transactional
//    void logURI(@Param("insertLink") String insertLink, @Param("id") Long id);
}
