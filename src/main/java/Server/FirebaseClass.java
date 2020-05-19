package Server;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseClass {

//    @PostConstruct
//    public void init() throws IOException {
//        FileInputStream serviceAccount =
//                new FileInputStream("abc.json");
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .setDatabaseUrl("https://test-q-firebase.firebaseio.com")
//                .build();
//
//        FirebaseApp.initializeApp(options);
//    }

    public static String addUser(String user) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        HashMap<String, String> map = new HashMap<>();
        map.put("name", user);
        map.put("temp", "yelo");
        ApiFuture<DocumentReference> collectionsApiFuture = dbFirestore.collection("users").add(map);
        DocumentReference result = collectionsApiFuture.get();

        return result.toString();
    }

    public static String getUserDetails(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentSnapshot documentSnapshot = dbFirestore.collection("users")
                .document("kuZsE2l2YsOeyCMiddaO")
                .get()
                .get();

        if(documentSnapshot.exists()) {
            return documentSnapshot.getData().toString();
        } else {
            return null;
        }
    }

    public static String update() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        WriteResult writeResult = dbFirestore.collection("users")
                .document("kuZsE2l2YsOeyCMiddaO")
                .update(FieldPath.of("name"), "newPqr", FieldPath.of("temp"), "newTemp")
                .get();
        return writeResult.toString();
    }

    public static String delete(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        WriteResult writeResult = dbFirestore.collection("users")
                .document(id)
                .delete()
                .get();
        return writeResult.toString();
    }
}
