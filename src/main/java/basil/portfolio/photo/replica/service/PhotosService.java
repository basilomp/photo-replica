package basil.portfolio.photo.replica.service;

import basil.portfolio.photo.replica.entity.Photo;
import basil.portfolio.photo.replica.repository.PhotosRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhotosService {

    @Autowired
    private final PhotosRepository photosRepository;

    public Iterable<Photo> getAllPhotos() {
        return photosRepository.findAll();
    }

    public Optional<Photo> getPhotoByID(Integer id) {
        return photosRepository.findById(id);
    }

    public void remove(Integer id) {
        photosRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photosRepository.save(photo);
        return photo;
    }
}
