package com.company.dao.inter;

import com.company.entity.User;
import java.util.List;
public interface UserDaoInter {
   
  public List<User> getAllUser();
    public User getUserById(int id);
    public boolean addUser(User s);
    public boolean updateUser(User s);
    public boolean removeUser(int id);

}
