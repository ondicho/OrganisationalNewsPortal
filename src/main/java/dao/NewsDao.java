package dao;

import models.News;


import java.util.List;

public interface NewsDao {

    //create
    void add(News news);

    News findById(int id);

    //read
    List<News> NewsDao();

    //delete
    void deleteById(int id);
    void clearAll();
}
