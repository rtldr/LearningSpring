package Server;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class DbController {


    @RequestMapping(value = "/user/{name}", method = GET)
    public String getUser(@PathVariable(value = "name") String name) throws ExecutionException, InterruptedException {
        System.out.println("CONTROLLER SIDE: get USER called with name = " + name);
        return FirebaseClass.getUserDetails(name);
    }

    @RequestMapping(value = "/user", method = POST)
    public String addUser(@RequestParam(value = "name") String name) throws ExecutionException, InterruptedException {
        System.out.println("CONTROLLER SIDE: add USER called with name = " + name);
        return FirebaseClass.addUser(name);
    }

    @RequestMapping(value = "/user", method = PUT)
    public String update() throws ExecutionException, InterruptedException {
        System.out.println("CONTROLLER SIDE: UPDATE USER called");
        return FirebaseClass.update();
    }

    @RequestMapping(value = "/user/{id}", method = DELETE)
    public String deleteUser(@PathVariable(value = "id") String id) throws ExecutionException, InterruptedException {
        System.out.println("CONTROLLER SIDE: DELETE USER called with id = " + id);
        return FirebaseClass.delete(id);
    }
}

