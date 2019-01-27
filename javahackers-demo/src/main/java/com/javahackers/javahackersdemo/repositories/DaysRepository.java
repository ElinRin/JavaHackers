package com.javahackers.javahackersdemo.repositories;

import com.javahackers.javahackersdemo.entities.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;

public interface DaysRepository extends JpaRepository<Day, String> {
    Collection<Day> findByDate(Date date);

    @Modifying
    @Query(value = "insert into day(redirect,user_id) VALUES (:insertLink,:id)", nativeQuery = true)
    @Transactional
    void logURI(@Param("insertLink") String insertLink, @Param("id") Long id);
}
