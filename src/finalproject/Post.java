package finalproject;

public class Post {

    public static String postContent = "";

    private String title;
    private String author;
    private String body;
    private String tag;
    private String date;

    public Post(String title, String body, String author, String tag, String date) {
        this.title = title;
        this.author = author;
        this.body = body;
        this.tag = tag;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }  //create the getter method for the details of the post

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public String getTag() {
        return tag;
    }

    public String getDate() {
        return date;
    }
}
