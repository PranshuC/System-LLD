package systems.parkinglot.models;

import java.sql.Date;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
