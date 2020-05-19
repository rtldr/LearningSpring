package Server;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class StorageClass {

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

    public static void createBucket() throws IOException {
        Credentials credentials = GoogleCredentials
                .fromStream(new FileInputStream("abc.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials)
                .setProjectId("test-q-firebase").build().getService();
        storage.create(BucketInfo.of("first-bucket-sssssdddd"));
    }

    public static String addStuff() throws IOException {
        String value = "Hello, World!";
        byte[] bytes = value.getBytes(UTF_8);
        Credentials credentials = GoogleCredentials
                .fromStream(new FileInputStream("abc.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials)
                .setProjectId("test-q-firebase").build().getService();
        Bucket bucket = storage.get("first-bucket-sssssdddd");
        Blob blob = bucket.create("my-first-blob", bytes);
        Blob gotBlob = storage.get(blob.getBlobId());
        String ret = new String(gotBlob.getContent());
        return ret;
    }

}
