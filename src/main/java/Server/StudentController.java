package Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class StudentController {

    @Autowired
    private StudentRedis studentRedis;
    private static final AtomicInteger studentCount = new AtomicInteger();

    @RequestMapping(value = "/student/{id}", method = GET)
    public Student getStudent(@PathVariable(value = "id") int id) {
        System.out.println("CONTROLLER SIDE: get student called with id = " + id);
        return studentRedis.getStudent(id);

    }

    @RequestMapping(value = "/student", method = POST)
    public void addStudent(@RequestParam(value = "email") String email) {
        System.out.println("CONTROLLER SIDE: add student called with email = " + email);
        studentRedis.addStudent(studentCount.getAndIncrement(), email);
    }
}
