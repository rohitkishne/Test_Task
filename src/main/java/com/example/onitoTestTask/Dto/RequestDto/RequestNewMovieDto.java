package com.example.onitoTestTask.Dto.RequestDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestNewMovieDto {

    String tconst;
    String titleType;
    String primaryTitle;
    int runtimeMinutes;
    String genres;
}
