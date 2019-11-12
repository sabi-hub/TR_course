package dao;

import data.Post;

public class Forum {

    private Post[] posts;
    private int size;

    public Forum(int capacity) {
        posts = new Post[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean addPost(Post post){ //post в качестве агрумента-параметра
        if (size < posts.length) {
            posts[size] = post;
            size++;
            return true;
        }
        return false;
    }

    public  boolean deletePost (int id){
        for (int i = 0; i < size; i++) {
            if (posts[i].getPostID()==id {
                posts[i] = posts[size - 1];
                size--;
                return true;
            }
        }
        return false;
    }

    public void displayPost() {
        for (int i = 0; i < size; i++) {
            System.out.println(posts[i]);
        }
    }

    public boolean updatePost(int postID, String newContent){
        for(int i=0; i<size; i++){
            if(posts[i].getPostID()==postID && posts[i].getContent().equalsIgnoreCase(newContent){
                posts[i].setContent(newContent);
                return true;
            }
        }
        return false;
    }

    public Post[] getPostByAuthor(String author, int numberOfPosts){
        Post[] authorsPost = new Post[numberOfPosts];
        int j=0;
        for(int i=0; i<size; i++){
            if(posts[i].getAuthor().getUserName()==author && j<numberOfPosts){
                authorsPost[j]=posts[i];
                i++
            }
        }
        return authorsPost;
    }
    public int getCountOfLikes(String title){
        for(int i=0; i<size; i++){
            if(posts[i].getTitle().equalsIgnoreCase(title)){
                System.out.println("User "+posts[i].getAuthor().getUserName()+ " has number of Likes: "
                        +posts[i].getLikes() +" for post "+ posts[i].getTitle());
                return posts[i].getLikes();
            }
        }
    }


}
