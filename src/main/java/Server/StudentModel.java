package Server;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class StudentModel {

    private static final AtomicInteger studentCount = new AtomicInteger();

    public static ResponseEntity<Collection<Student>> getStudent() {
        Collection<Student> result = Controller.students.values();
        return ResponseEntity.ok(result);
    }

    public static ResponseEntity<Student> getStudent(int id) {
        if(Controller.students.containsKey(id)) {
            return ResponseEntity.ok(Controller.students.get(id));
        }
        return ResponseEntity.status(404).body(null);
    }

    public static ResponseEntity<Student> addStudent(String email) {
        HashMap<Integer, Student> students = Controller.students;
        Set<Integer> keys = students.keySet();
        for(int key: keys) {
            if (students.get(key).getEmail().equals(email)) {
                return ResponseEntity.status(409).body(null);
            }
        }

        Student result = new Student(studentCount.getAndIncrement(), email);
        students.put(result.getId(), result);

        print(students.values());
        return ResponseEntity.ok(result);
    }

    public static ResponseEntity<Student> removeStudent(int id) {
        HashMap<Integer, Student> students = Controller.students;
        if(!students.containsKey(id)) {
            return ResponseEntity.status(404).body(null);
        }

        Student toRemove = students.get(id);
        students.remove(id);

        print(students.values());
        return ResponseEntity.ok(toRemove);
    }

    private static void print(Collection<Student> coll) {
        System.out.println("Students: " + coll.toString());
    }
}
