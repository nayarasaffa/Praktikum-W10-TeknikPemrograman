package com.example.Kelompok8.apicrud.repositories;

import com.example.Kelompok8.apicrud.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {
}
