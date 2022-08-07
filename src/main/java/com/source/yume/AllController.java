package com.source.yume;

import com.source.yume.modele.Groups;
import com.source.yume.modele.Students;
import com.source.yume.repository.StudentRepositoryImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class AllController {

    @GetMapping("/students")
    public List<Students> GetStudents(){
        StudentRepositoryImpl select = new StudentRepositoryImpl();
        return select.findAll();
    }

    @GetMapping("/student")
    public List<Students> Query(@RequestBody String queryParams){
        StudentRepositoryImpl query = new StudentRepositoryImpl();
        return query.findWhereNameLike(queryParams);
    }

    @PostMapping("/students")
    public Students PostStudent(@RequestBody int id, String name, int group_id, String group_name, Date creation_date){
        StudentRepositoryImpl insert = new StudentRepositoryImpl();
        return insert.save(new Students(id, name, new Groups(group_id, group_name, creation_date)));
    }

    @DeleteMapping("/students")
    public List<Students> DeleteStudent(@RequestBody int id){
        StudentRepositoryImpl delete = new StudentRepositoryImpl();
        delete.deleteById(id);
        return delete.findAll();
    }
}
