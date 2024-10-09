package com.bikkadIT.repository;

import com.bikkadIT.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo  extends JpaRepository<Category,Integer> {
}
