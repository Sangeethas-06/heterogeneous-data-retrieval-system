package dataretrieval.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@Document
@AllArgsConstructor
@Builder
public class UserTable {
    @Id
    private String deviceId;
    private String status;

}
