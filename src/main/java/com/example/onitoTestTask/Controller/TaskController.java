package com.example.onitoTestTask.Controller;

import com.example.onitoTestTask.Dto.RequestDto.RequestNewMovieDto;
import com.example.onitoTestTask.Dto.ResponseDto.GenreMoviesWithSubTotalResponseDto;
import com.example.onitoTestTask.Dto.ResponseDto.GetAllMoviesWithLongestDurationResponseDto;
import com.example.onitoTestTask.Dto.ResponseDto.GetTopRatedMoviesResponseDto;
import com.example.onitoTestTask.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/new-movie")
    public String addNewMovie(@RequestBody RequestNewMovieDto requestNewMovieDto)
    {
        return taskService.addNewMovie(requestNewMovieDto);
    }

    @GetMapping("/longest-duration-movies")
    public List<GetAllMoviesWithLongestDurationResponseDto> getAllMoviesWithLongestDuration(){
        return taskService.getAllMoviesWithLongestDuration();
    }

    @GetMapping("/top-rated-movie")
    public List<GetTopRatedMoviesResponseDto> getTopRatedMovies(){
        return taskService.getTopRatedMovies();
    }

   @PostMapping("/update-runtime-minutes")
    public String updateRuntimeMinutesOfAllMovies(){
        return taskService.updateRuntimeMinutesOfAllMovies();
   }

   @GetMapping("/genre-movies-with-subtotals")
    public List<GenreMoviesWithSubTotalResponseDto> getGenreMoviesWithSubtotals(){
        return taskService.getGenreMoviesWithSubtotals();
   }
}
