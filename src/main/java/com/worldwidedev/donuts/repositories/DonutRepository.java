package com.worldwidedev.donuts.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worldwidedev.donuts.models.Donut;

@Repository
public interface DonutRepository extends JpaRepository<Donut, Long>{
}
