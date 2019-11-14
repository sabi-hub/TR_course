package controller;

import dao.Forum;
import data.Post;
import data.User;
import data.UserAdmin;

public class ForumApp {

    public static void main(String[] args) {


        User user1 = new User("Alex",19);
        User user2 = new User("Vanya", 20);

        User user3= new UserAdmin("Max", 30, "star");


        Post post1 = new Post(user1, 123, "Hallo", "what a beautiful day!");
        Post post2 = new Post(user2, 223, "Hallo", "what a beautiful world!");
        Post post3 = new Post(user1, 133, "One day", "nice to see you!");
        //Post post4 = new Post(new User(), 323, "Hallo", "Never say me tomorrow!");
        Post post5 = new Post(user2, 233, "One day later", "see you tomorrow!");
       // Post post6 = new Post(new User(), 423, "Champions", "We are the champions, my friends");
        Post post7 = new Post(user1, 143, "Good by", "see you leter");


        Forum myForum = new Forum(20);

        myForum.addPost(post1);
        myForum.addPost(post2);
        myForum.addPost(post3);
        //myForum.addPost(post4);
        myForum.addPost(post5);
       // myForum.addPost(post6);
        myForum.addPost(post7);

        post1.addLike();
        post1.addLike();

        //myForum.displayPost();

        Post[] postByLeon = myForum.getPostByAuthor("Leon", 5);
        display(postByLeon);

    }

    public static void display(Object[] objects){
        for (int i=0; i<objects.length; i++){
            if(objects[i]!=null){
                System.out.println(objects[i]);
            }
        }
    }



}
