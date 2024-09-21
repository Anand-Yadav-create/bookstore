package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.entity.Mybooklist;

@Repository

public interface MybookRepository extends JpaRepository<Mybooklist,Integer> {

}
