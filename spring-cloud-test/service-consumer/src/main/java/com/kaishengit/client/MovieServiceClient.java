package com.kaishengit.client;

import com.kaishengit.entity.Movie;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jinjianghao
 * @date 2018/9/3
 */
@FeignClient("MOVIE-SERVICE-PROVIDER")
public interface MovieServiceClient {

    // 必须使用@PathVariable(name = "id") 实现param和url中id的绑定
    @GetMapping("/movie/{id}")
    String buyMovie(@PathVariable(name = "id") Integer id);

    @PostMapping("/movie/new")
    String newMovie(@RequestParam(name = "movieName") String movieName,
                     @RequestParam(name = "year") String year);


    @PostMapping("/movie/save")
    String saveMovie(Movie movie);
}
