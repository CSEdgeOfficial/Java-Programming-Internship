import java.util.*;

class User {
    private String username;
    private String fullName;
    private String email;
    // Add more user profile information as needed

    public User(String username, String fullName, String email) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Username: " + username + ", Full Name: " + fullName + ", Email: " + email;
    }
}

class Post {
    private String content;
    private User author;
    private List<Comment> comments;

    public Post(String content, User author) {
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Author: ").append(author.getUsername()).append("\n");
        sb.append("Content: ").append(content).append("\n");
        sb.append("Comments:\n");
        for (Comment comment : comments) {
            sb.append(comment).append("\n");
        }
        return sb.toString();
    }
}

class Comment {
    private String content;
    private User author;

    public Comment(String content, User author) {
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Comment by " + author.getUsername() + ": " + content;
    }
}

public class SocialNetworkingDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        List<Post> posts = new ArrayList<>();

        // Dynamic input for creating users
        System.out.println("Create users (username, full name, email), type 'done' to finish:");
        while (true) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            if (username.equals("done")) break;
            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            User user = new User(username, fullName, email);
            users.add(user);
        }

        // Dynamic input for creating posts and comments
        for (User user : users) {
            System.out.println("User: " + user.getUsername());
            System.out.println("Create posts, type 'done' to finish:");
            while (true) {
                System.out.print("Post content: ");
                String content = scanner.nextLine();
                if (content.equals("done")) break;

                Post post = new Post(content, user);
                posts.add(post);

                // Allow commenting on the post
                System.out.println("Add comments to this post, type 'done' to finish:");
                while (true) {
                    System.out.print("Comment content: ");
                    String commentContent = scanner.nextLine();
                    if (commentContent.equals("done")) break;

                    Comment comment = new Comment(commentContent, user);
                    post.addComment(comment);
                }
            }
        }

        // Display all posts
        System.out.println("\nAll Posts:");
        for (Post post : posts) {
            System.out.println(post);
        }

        scanner.close();
    }
}
