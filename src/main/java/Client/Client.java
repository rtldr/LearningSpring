package Client;

import okhttp3.*;

import java.io.IOException;

public class Client {

    private static final String URL = "http://localhost:8080";

    public static void main(String[] args) {
        addStudents();
        addItems();
    }

    public static void addStudents() {
        String[] emails = {"sachin@abc.com", "aman@abc.com", "random@random.com",
                "sid@abc.com", "riti@abc.com", "vini@abc.com"};

        for(String email: emails) {
            addStudent(email);
        }
    }

    public static void addItems() {
        String[] contents = {"marker", "marker, iPad", "mic, bottle, phone, mac",
                "monitor, HDMI cable, mouse, keyboard", "keyboard", "CTCI, monitor"};

        for(String content: contents) {
            addItem(content);
        }
    }

    public static void addStudent(String email) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL + "/student/?email=" + email)
                .post(RequestBody.create(new byte[]{}, null))
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addItem(String content) {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("contents", content)
                .build();

        Request request = new Request.Builder()
                .url(URL + "/item/")
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
