package basil.portfolio.photo.replica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PHOTOS")
public class Photo {

    @Id
    @Column("ID")
    private String id;

    @NotEmpty
    @Column("FILE_NAME")
    private String fileName;

    @Column("CONTENT_TYPE")
    private String contentType;

    @JsonIgnore
    @Column("DATA")
    private byte[] data;

}
