package com.example.onitoTestTask.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="ratings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ratingId;
    double averageRating;
    int numVotes;

    @OneToOne
    @JoinColumn
    Movies movies;
}
