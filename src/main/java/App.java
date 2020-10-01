import dao.Sql2oDepartmentDao;
import dao.Sql2oDepartmentNewsDao;
import dao.Sql2oGeneralNewsDao;
import dao.Sql2oUserDao;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import models.DB;
import com.google.gson.Gson;



import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oDepartmentDao departmentDao;
        Sql2oUserDao userDao;
        Sql2oGeneralNewsDao generalNewsDao;
        Sql2oDepartmentNewsDao departmentNewsDao;
        Gson gson = new Gson();
        Connection conn;


        String connectionString = "jdbc:postgresql://localhost:5432/organisational_news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "ondicho", "1234");
        departmentDao=new Sql2oDepartmentDao(sql2o);
        userDao=new Sql2oUserDao(sql2o);
        generalNewsDao=new Sql2oGeneralNewsDao(sql2o);
        departmentNewsDao=new Sql2oDepartmentNewsDao(sql2o);
        conn = sql2o.open();
//
    //departments

        post("/departments/new", "application/json", (req, res) -> { //accept a request in format JSON from an app
            Department department = gson.fromJson(req.body(), Department.class);//make java from JSON with GSON
            departmentDao.add(department);//Do our thing with our DAO
            res.status(201);//A-OK! But why 201??
            return gson.toJson(department);//send it back to be displayed
        });
        get("/departments", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(departmentDao.getAll());//send it back to be displayed
        });

        get("/departments/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            int id= Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentDao.findById(id));
        });

    //users
        post("/users/new", "application/json", (req, res) -> { //accept a request in format JSON from an app
            User user= gson.fromJson(req.body(), User.class);//make java from JSON with GSON
            userDao.add(user);//Do our thing with our DAO
            res.status(201);//A-OK! But why 201??
            return gson.toJson(user);//send it back to be displayed
        });

        get("/users", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(userDao.getAll());//send it back to be displayed
        });

        get("/users/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            int id= Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(userDao.findById(id));
        });

        //General news
        post("/news/new", "application/json", (req, res) -> { //accept a request in format JSON from an app
            News news= gson.fromJson(req.body(), News.class);//make java from JSON with GSON
            generalNewsDao.add(news);//Do our thing with our DAO
            res.status(201);//A-OK! But why 201??
            return gson.toJson(news);//send it back to be displayed
        });

        get("/news", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(generalNewsDao.NewsDao());//send it back to be displayed
        });

        get("/news/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            int id= Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(generalNewsDao.findById(id));
        });

        //department news
        //General news
//        post("/news/new", "application/json", (req, res) -> { //accept a request in format JSON from an app
//            News news= gson.fromJson(req.body(), News.class);//make java from JSON with GSON
//            departmentNewsDao.add(news);//Do our thing with our DAO
//            res.status(201);//A-OK! But why 201??
//            return gson.toJson(news);//send it back to be displayed
//        });

        get("/news", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(departmentNewsDao.NewsDao());//send it back to be displayed
        });

        get("/news/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            int id= Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentNewsDao.findById(id));
        });
    }
}
