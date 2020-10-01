package dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

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
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
