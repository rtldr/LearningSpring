package hello;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class RelationModel {

    public static ResponseEntity<HashMap<Student, ArrayList<Item>>> getAllCheckedOut() {
        HashMap<Integer, Integer> checkedOut = Controller.checkedOut;
        HashMap<Integer, Item> items = Controller.items;
        HashMap<Integer, Student> students = Controller.students;

        HashMap<Student, ArrayList<Item>> result = new HashMap<>();
        Set<Integer> itemIds = checkedOut.keySet();
        for(int id: itemIds) {
            Student s = students.get(checkedOut.get(id));
            Item i = items.get(id);

            result.putIfAbsent(s, new ArrayList<>());
            result.get(s).add(i);
        }
        return ResponseEntity.ok(result);
    }

    public static ResponseEntity checkOut(int itemId, int studentId) {
        HashMap<Integer, Integer> checkedOut = Controller.checkedOut;
        HashMap<Integer, Item> items = Controller.items;
        HashMap<Integer, Student> students = Controller.students;

        if (!items.containsKey(itemId)
                || !students.containsKey(studentId)
                || checkedOut.containsKey(itemId)) {

            return ResponseEntity.status(404).body(null);
        }

        checkedOut.put(itemId, studentId);
        System.out.println("Student: " + studentId + " checked out: " + items.get(itemId));
        return ResponseEntity.ok(null);
    }

    public static ResponseEntity checkIn(int itemId) {
        HashMap<Integer, Integer> checkedOut = Controller.checkedOut;
        if (!Controller.items.containsKey(itemId) || !checkedOut.containsKey(itemId)) {
            return ResponseEntity.status(404).body(null);
        }

        checkedOut.remove(itemId);
        System.out.println(Controller.items.get(itemId) + " was/were returned");
        return ResponseEntity.ok(null);
    }
}