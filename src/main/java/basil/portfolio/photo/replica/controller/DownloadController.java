package basil.portfolio.photo.replica.controller;

import basil.portfolio.photo.replica.entity.Photo;
import basil.portfolio.photo.replica.service.PhotosService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DownloadController {

    @Autowired
    private PhotosService photosService;

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id) {
        Optional<Photo> photo = photosService.getPhotoByID(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        byte[] data = photo.get().getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.get().getContentType()));
        ContentDisposition contentDisposition = ContentDisposition
                .builder("inline")
                .filename(photo.get().getFileName())
                .build();
        headers.setContentDisposition(contentDisposition);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
