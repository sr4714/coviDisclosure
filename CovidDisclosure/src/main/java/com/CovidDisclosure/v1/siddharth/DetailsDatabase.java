package com.CovidDisclosure.v1.siddharth;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DetailsDatabase extends JpaRepository<Details, Integer> {

}
