package huit2017.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AccountDto {

   private Integer id;

   private String name;

   private Date createdAt;

   private Date updatedAt;

   private Byte deleteFlg;

   private String mail;

   private String password;
}
