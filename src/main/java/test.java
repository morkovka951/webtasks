import dao.StudentsDao;
import dao.impl.StudentDaoImpl;
import database.DataService;
import services.StudentService;
import services.impl.StudentServiceImpl;

/**
 * Created by Morkovka on 24.05.2015.
 */
public class test {
    public static void main (String [] args){

        //DataService service = new DataService();
        StudentService studentService = new StudentServiceImpl();

        System.out.println(studentService.getStudents());


    }
}
