package hello;

public class Student {
    private int id;
    private String email;

    public Student(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "[id: " + id + ", email: " + email + "]";
    }
}
