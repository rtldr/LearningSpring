package Server;

public class Item {
    private int id;
    private String contents;

    public Item(int id, String contents) {
        this.id = id;
        this.contents = contents;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return contents;
    }

    public void addContent(String addition) {
        contents = contents + ", " + addition;
    }

    public String toString() {
        return "[id: " + id + ", contents: " + contents + "]";
    }

//    public void removeContent(String content) {
//        int pos = -1;
//        for(int i = 0; i < contents.size(); i++) {
//            if(contents.get(i).equals(content)) {
//                pos = i;
//                break;
//            }
//        }
//
//        if(pos != -1) {
//            contents.remove(pos);
//        }
//    }
}
