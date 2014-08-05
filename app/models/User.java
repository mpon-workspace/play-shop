package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import org.mindrot.jbcrypt.BCrypt;

@Entity 
public class User extends Model {

  @Id
  @Constraints.Min(10)
  public Long id;
  
  @Constraints.Required
  public String name;
  
  public String password;
    
  public static Finder<Long, User> find = new Finder<Long,User>(
    Long.class, User.class
  ); 

  public String validate() {
    if (authenticate(name, password)) {
      return null;
    }
    return "Invalid user and password";
  }

  private Boolean authenticate(String name, String password) {
    User user = find.where().eq("name", name).findUnique();
    return (user != null && BCrypt.checkpw(password, user.password));
  }

  public static void create(String name, String password) {
    User user = new User();
    user.name = name;
    user.password = BCrypt.hashpw(password, BCrypt.gensalt());
    user.save();
  }

}