import dao.Sql2oDepartmentDao;
import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import models.DB;
import com.google.gson.Gson;



import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oDepartmentDao departmentDao;
        Gson gson = new Gson();
        Connection conn;

//        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/organisational_news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "ondicho", "1234");
        departmentDao=new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
//


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
    }
}
