package com.example.provinceservice.repository;

import com.example.provinceservice.model.Province;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProvinceRepository extends MongoRepository<Province,String> {
}
