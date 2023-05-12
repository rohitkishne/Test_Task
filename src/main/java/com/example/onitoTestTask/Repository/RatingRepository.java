package com.example.onitoTestTask.Repository;

import com.example.onitoTestTask.Entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Ratings, Integer> {
}
