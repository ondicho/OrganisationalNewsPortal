package models;
import org.sql2o.*;

public class DB {
        public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/organisational_news_portal", "ondicho", "1234");
}
