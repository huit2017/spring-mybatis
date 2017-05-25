package huit2017.dto.top;

import java.util.Date;

import lombok.Data;

@Data
public class FinishOutDto {

    private Integer bbsId;

    private Integer userId;

    private String comment;

    private Date createdAt;

    private Date updatedAt;
}
