package dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentNewsDao implements NewsDao{

    private final Sql2o sql2o;
    public Sql2oDepartmentNewsDao(Sql2o sql2o){this.sql2o=sql2o;}

    @Override
    public void add(News news) {
        String sql="INSERT INTO news (articleTitle,articleContent,articleAuthor,articleScope) VALUES (:articleTitle,:articleContent,:articleAuthor,:articleScope)";
        try(Connection con=sql2o.open()){
            int id=(int) con.createQuery(sql,true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setArticleId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public News findById(int id) {
        try (Connection con=sql2o.open()) {
            return con.createQuery("SELECT FROM news WHERE id=:id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(News.class);
        }
    }

    @Override
    public List<News> NewsDao() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from users WHERE id=:id"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from users";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
