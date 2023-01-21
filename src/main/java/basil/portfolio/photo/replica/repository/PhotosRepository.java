package basil.portfolio.photo.replica.repository;

import basil.portfolio.photo.replica.entity.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhotosRepository extends CrudRepository<Photo, Integer> {
}
