package com.example.onitoTestTask.Repository;

import com.example.onitoTestTask.Dto.ResponseDto.GenreMoviesWithSubTotalResponseDto;
import com.example.onitoTestTask.Entity.Movies;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, String> {

    @Query(value = "select m from Movies m order by m.runtimeMinutes desc limit 10")
    List<Movies> findAllMoviesWithLongestDurationTime();
    @Query(value = "select m from Movies m Join Ratings r On m.tconst = r.movies.tconst where r.averageRating > 6.0 order by r.averageRating")
    List<Movies> findTopRatedMovies();

    @Transactional
    @Modifying
    @Query("UPDATE Movies m SET m.runtimeMinutes = CASE WHEN m.genres = 'Documentary' THEN m.runtimeMinutes + 15 WHEN m.genres = 'Animation' THEN m.runtimeMinutes + 30 ELSE m.runtimeMinutes + 45 END")
    void updateRuntimeMinutesOfAllMovies();

    @Query(value = "select m.genres, m.primary_title, sum(r.num_votes) from movies m Join ratings r On m.tconst = r.movies_tconst Group by m.genres, m.primary_title with RollUp", nativeQuery = true)
    List<Object[]> findGenreMoviesWithSubTotal();

}
