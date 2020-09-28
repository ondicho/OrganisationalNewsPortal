package dao;

import models.User;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oUserDao implements UserDao{

    private final Sql2o sql2o;
    public Sql2oUserDao(Sql2o sql2o){this.sql2o=sql2o;}

    @Override
    public void add(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getAllUsersByDepartmentId(int departmentId) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
