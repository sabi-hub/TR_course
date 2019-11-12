package controller;

import dao.Forum;
import data.Post;
import data.User;

public class ForumApp {

    public static void main(String[] args) {
        User user1 = new User("Faust", 45);
        User user2 = new User("Leon", 50);

        Post post1 = new Post (user1, 1123, "Hello", "Hello world = my first post");
        Post post2 = new Post (user2, 1124, "Hello", "It's sunshine today");
        Post post3 = new Post (user1, 1125, "New experience", "I really like this forum");

        Forum myForum =


    }
}
