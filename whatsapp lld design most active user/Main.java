import java.util.*;

// user class will have id and name

class User{
  int id;
  String name;
  int totalPoints = 0;

  User(int id, String name){
    this.id = id;
    this.name = name;
  }

  public int getId(){
    return id;
  }

  public String getName(){
    return name;
  }

  public void sendMessage(Group group, String content){
    OriginalMessage message = new OriginalMessage(this, content);
    group.addMessage(message);
    this.addPoints(message.messagePoints);
  }

  public void replyMessage(Group group, String content){
    ReplyMessage message = new ReplyMessage(this, content);
    group.addMessage(message);
    this.addPoints(message.messagePoints);
  }

  public void addReactions(){
    this.totalPoints += 1;
  }

  public void addPoints(int points){
    this.totalPoints += points;
  }
}


class Message{
  String messageId;
  User sender;
  String content;
  int messagePoints = 10;
  int maxActivePoints = 0;
  // timestamp
  
  Message(User sender, String content){
    this.sender = sender;
    this.content = content;
    this.messageId = String.valueOf(Math.random());
  }
}

class OriginalMessage extends Message{
  OriginalMessage(User sender, String content){
    super(sender, content);
  }
}

class ReplyMessage extends Message{
  ReplyMessage(User sender, String content){
    super(sender, content);
    this.messagePoints = 5;
  }
}

class Group {
  List<User> members = new ArrayList<>(); // Initialize the list to avoid NullPointerException
  List<Message> messages = new ArrayList<>(); // Initialize the list to avoid NullPointerException
  int maxActivePoints = 0;

  public void addMember(User user) {
    members.add(user);
  }

  public void addMessage(Message message) {
    messages.add(message);
  }

  public User getActiveMember() {
    User mostActiveUser = null;
    for (User user : members) {
      if (user.totalPoints > this.maxActivePoints) {
        this.maxActivePoints = user.totalPoints;
        mostActiveUser = user;
      }
    }
    return mostActiveUser;
  }
}



class Main{

  public static void main(String[] args) {
    Group group = new Group();

    User John = new User(1, "John");
    User Jane = new User(2, "Jane");

    group.addMember(John);
    group.addMember(Jane);

    John.sendMessage(group, "Hi I am John");

    Jane.replyMessage(group, "Hi John, I am Jane");
    Jane.addReactions();
    Jane.replyMessage(group, "Now i am on top");


    User mostActiveUser = group.getActiveMember();

    System.out.println("Most active user name is " + mostActiveUser.getName() + " with total points of " + mostActiveUser.totalPoints);

  }
}
