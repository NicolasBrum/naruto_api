package com.naruto_api.naruto_api.model.repositories;

import com.naruto_api.naruto_api.model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel,Integer> {
}
