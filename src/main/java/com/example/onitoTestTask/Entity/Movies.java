package com.example.onitoTestTask.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Movies {

    @Id
    String tconst;
    String titleType;
    String primaryTitle;
    int runtimeMinutes;
    String genres;

    @OneToOne(mappedBy = "movies", cascade = CascadeType.ALL)
    Ratings ratings;
}
