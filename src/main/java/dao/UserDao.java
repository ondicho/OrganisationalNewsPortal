package dao;

import models.User;

import java.util.List;

public interface UserDao {

    //create
    void add(User user);

    User findById(int id);
    //read
    List<User> getAll();
    List<User> getAllUsersByDepartmentId(int departmentId);

    //delete
    void deleteById(int id);
    void clearAll();
}
