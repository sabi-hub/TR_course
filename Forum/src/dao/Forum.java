package dao;

import data.Post;
import data.User;
import data.UserAdmin;

import java.util.Scanner;

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
            if (posts[i].getPostID()==id) {
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


    public Post[] getPostByAuthor(String author, int numberOfPosts){
        Post[] authorsPost = new Post[numberOfPosts];
        int j=0;
        for(int i=0; i<size; i++){
            if(posts[i].getAuthor().getUserName()==author && j<numberOfPosts){
                authorsPost[j]=posts[i];
                i++;
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
        return 0;
    }
    public boolean checkPassword(){
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<size; i++){
            if (posts[i].getAuthor().getClass().getSimpleName().equalsIgnoreCase("UserAdmin")){ //указывается классю UserAdmin везде класс
                UserAdmin admin =  (UserAdmin)posts[i].getAuthor(); //(UserAdmin) - кастомизация. В явном виде указывается приводим к определенному классу
                System.out.println("Enter password, please");
                String password = scanner.nextLine();
                if(admin.getPassword().equalsIgnoreCase(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public void updatePostByAdmin(int postId){
        Scanner scanner = new Scanner(System.in);
        if(checkPassword()){
            for(int i=0; i<size; i++){
                if(posts[i].getPostID() == postId){
                    System.out.println("Enter new content, please");
                    String newContent = scanner.nextLine();
                    posts[i].setContent(newContent);
                    System.out.println(postId+" content changed to "+posts[i].getContent());
                }
            }

        }
        else{
            System.out.println("access is denied");
        }
    }


}
