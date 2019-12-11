package hello;

import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ItemModel {

    private static final AtomicInteger itemCount = new AtomicInteger();

    public static ResponseEntity<Collection<Item>> getItem() {
        return ResponseEntity.ok(Controller.items.values());
    }

    public static ResponseEntity<Item> getItem(int id) {
        HashMap<Integer, Item> items = Controller.items;
        if(items.containsKey(id)) {
            return ResponseEntity.ok(items.get(id));
        }
        return ResponseEntity.status(404).body(null);
    }

    public static ResponseEntity<Item> addItem(String contents) {
        HashMap<Integer, Item> items = Controller.items;
        Item result = new Item(itemCount.getAndIncrement(), contents);
        items.put(result.getId(), result);

        print(items.values());
        return ResponseEntity.ok(result);
    }

    public static ResponseEntity<Item> removeItem(int id) {
        HashMap<Integer, Item> items = Controller.items;
        if(!items.containsKey(id)) {
            return ResponseEntity.status(404).body(null);
        }
        Item toRemove = items.get(id);
        items.remove(id);

        print(items.values());
        return ResponseEntity.ok(toRemove);
    }

    private static void print(Collection<Item> coll) {
        System.out.println("Items: " + coll.toString());
    }
}
