package huit2017.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class AccountDto implements Serializable {

   private Integer id;

   private String name;

   private Date createdAt;

   private Date updatedAt;

   private Byte deleteFlg;

   private String mail;

   private String password;
}
