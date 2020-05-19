package Server;

import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class StorageController {

    @RequestMapping(value = "/store/", method = GET)
    public String getStuff() throws IOException {
        System.out.println("CONTROLLER SIDE: get STUFF called");
        StorageClass.createBucket();

        return null;
//        return FirebaseClass.getUserDetails(name);
    }

    @RequestMapping(value = "/store/1/", method = GET)
    public String addStuff() throws IOException {
        System.out.println("CONTROLLER SIDE: add stuff called");
        return StorageClass.addStuff();

//        return FirebaseClass.getUserDetails(name);
    }




//    @RequestMapping(value = "/store", method = POST)
//    public String addUser(@RequestParam(value = "name") String name) throws ExecutionException, InterruptedException {
//        System.out.println("CONTROLLER SIDE: add USER called with name = " + name);
//        return FirebaseClass.addUser(name);
//    }
//
//    @RequestMapping(value = "/user", method = PUT)
//    public String update() throws ExecutionException, InterruptedException {
//        System.out.println("CONTROLLER SIDE: UPDATE USER called");
//        return FirebaseClass.update();
//    }
//
//    @RequestMapping(value = "/user/{id}", method = DELETE)
//    public String deleteUser(@PathVariable(value = "id") String id) throws ExecutionException, InterruptedException {
//        System.out.println("CONTROLLER SIDE: DELETE USER called with id = " + id);
//        return FirebaseClass.delete(id);
//    }
}

