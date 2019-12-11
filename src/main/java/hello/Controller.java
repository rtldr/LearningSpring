package hello;

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
        return StudentController.getStudent();
    }

    @RequestMapping(value = "/student/{id}", method = GET)
    public ResponseEntity<Student> getStudent(@PathVariable(value = "id") int id) {
        return StudentController.getStudent(id);
    }

    @RequestMapping(value = "/student", method = POST)
    public ResponseEntity<Student> addStudent(@RequestParam(value = "email") String email) {
        return StudentController.addStudent(email);
    }

    @RequestMapping(value = "/student/{id}", method = DELETE)
    public ResponseEntity<Student> removeStudent(@PathVariable(value = "id") int id) {
        return StudentController.removeStudent(id);
    }


    // ITEM API
    @RequestMapping(value = "/item/", method = GET)
    public ResponseEntity<Collection<Item>> getItem() {
        return ItemController.getItem();
    }

    @RequestMapping(value = "/item/{id}", method = GET)
    public ResponseEntity<Item> getItem(@PathVariable(value = "id") int id) {
        return ItemController.getItem(id);
    }

    @RequestMapping(value = "/item", method = POST)
    public ResponseEntity<Item> addItem(@RequestParam(value = "contents") String contents) {
        return ItemController.addItem(contents);
    }

    @RequestMapping(value = "/item/{id}", method = DELETE)
    public ResponseEntity<Item> removeItem(@PathVariable(value = "id") int id) {
        return ItemController.removeItem(id);
    }


    // RELATION API
    @RequestMapping(value = "/associate", method = GET)
    public ResponseEntity<HashMap<Student, ArrayList<Item>>> getAllCheckedOut() {
        return RelationController.getAllCheckedOut();
    }

    @RequestMapping(value = "/associate", method = POST)
    public ResponseEntity checkOut(@RequestParam(value = "itemId") int itemId, @RequestParam(value = "studentId") int studentId) {
        return RelationController.checkOut(itemId, studentId);
    }

    @RequestMapping(value = "/associate", method = DELETE)
    public ResponseEntity checkIn(@RequestParam(value = "itemId") int itemId) {
        return RelationController.checkIn(itemId);
    }


}
