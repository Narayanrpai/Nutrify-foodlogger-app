package com.narayan.foodlogger.repositories;

import com.narayan.foodlogger.model.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, String> {
}
