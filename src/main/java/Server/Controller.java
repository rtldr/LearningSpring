package Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class Controller {

    static HashMap<Integer, Student> students;
    static HashMap<Integer, Item> items;
    static HashMap<Integer, Integer> checkedOut;  // Item ID - Student ID

    public Controller() {
        students = new HashMap<>();
        items = new HashMap<>();
        checkedOut = new HashMap<>();
    }

    // STUDENT API
    @RequestMapping(value = "/student", method = GET)
    public ResponseEntity<Collection<Student>> getStudent() {
        return StudentModel.getStudent();
    }

    @RequestMapping(value = "/student/{id}", method = DELETE)
    public ResponseEntity<Student> removeStudent(@PathVariable(value = "id") int id) {
        return StudentModel.removeStudent(id);
    }


    // ITEM API
    @RequestMapping(value = "/item/", method = GET)
    public ResponseEntity<Collection<Item>> getItem() {
        return ItemModel.getItem();
    }

    @RequestMapping(value = "/item/{id}", method = GET)
    public ResponseEntity<Item> getItem(@PathVariable(value = "id") int id) {
        return ItemModel.getItem(id);
    }

    @RequestMapping(value = "/item", method = POST)
    public ResponseEntity<Item> addItem(@RequestParam(value = "contents") String contents) {
        return ItemModel.addItem(contents);
    }

    @RequestMapping(value = "/item/{id}", method = DELETE)
    public ResponseEntity<Item> removeItem(@PathVariable(value = "id") int id) {
        return ItemModel.removeItem(id);
    }


    // RELATION API
    @RequestMapping(value = "/associate", method = GET)
    public ResponseEntity<HashMap<Student, ArrayList<Item>>> getAllCheckedOut() {
        return RelationModel.getAllCheckedOut();
    }

    @RequestMapping(value = "/associate", method = POST)
    public ResponseEntity checkOut(@RequestParam(value = "itemId") int itemId, @RequestParam(value = "studentId") int studentId) {
        return RelationModel.checkOut(itemId, studentId);
    }

    @RequestMapping(value = "/associate", method = DELETE)
    public ResponseEntity checkIn(@RequestParam(value = "itemId") int itemId) {
        return RelationModel.checkIn(itemId);
    }


}
