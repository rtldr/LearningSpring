package Server;


import com.google.firebase.FirebaseApp;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentRedis {

    private RedisTemplate<String, Student> template;
    private FirebaseApp fbapp;

    public StudentRedis(RedisTemplate<String, Student> template) {
        this.template = template;
    }

    public Student getStudent(int id) {
        System.out.println("Called GET with id = " + id);
        Student s = (Student) template.opsForHash().get("cache1", id + "");
        System.out.println("Received student object: " + s.toString());
        return s;
    }

    public void addStudent(int id, String email) {
        Student s = new Student(id, email);
        template.opsForHash().put("cache1", id + "", s);
        System.out.println("Added student with id = " + id + " and email = " + email);

        System.out.println("Adding to database...");

    }

}
