package data;

public class Post extends User {
    private User author;
    private int postID;
    private String title;
    private String content;
    public int likes =0;

    public Post(User author, int postID, String postTitle, String content) {
        this.author = author;
        this.postID = postID;
        this.title = postTitle;
        this.content = content;
    }

    public int getPostID() {
        return postID;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getLikes() {
        return likes;
    }

    @Override
    public String toString() {
        return "Post{" +
                "author=" + author +
                ", postID=" + postID +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                '}';
    }

    public int addLike (){
        return likes++;
    }

    public int disLike(){
        return likes--;
    }


}
