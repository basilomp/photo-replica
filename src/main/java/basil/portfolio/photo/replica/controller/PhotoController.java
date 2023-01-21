package basil.portfolio.photo.replica.controller;

import basil.portfolio.photo.replica.entity.Photo;
import basil.portfolio.photo.replica.service.PhotosService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
@RequiredArgsConstructor
@AllArgsConstructor
public class PhotoController {

    @Autowired
    private PhotosService photosService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photos")
    public Iterable<Photo> getAllPhotos() {
        return photosService.getAllPhotos();
    }

    @GetMapping("/photos/{id}")
    public Optional<Photo> getPhotos(@PathVariable Integer id) {
        Optional<Photo> photo = photosService.getPhotoByID(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id) {
        photosService.remove(id);
    }

    @PostMapping("/photos")
    public Photo addPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        return photosService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
