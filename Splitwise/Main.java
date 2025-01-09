import java.util.HashMap;
import java.util.Map;

public class Main {

  
  public static void main(String[] args) {
  
    // Creating the users
  
    User user1 = new User("1", "Archit", "archit@kiwi.in");
    User user2 = new User("2", "Aditya", "aditya@kiwi.in");
    User user3 = new User("3", "Rahul", "rahul@kiwi.in");
    
  
    // creating the group and adding members
  
    Group group = new Group("g1", "Trip");
  
    group.addMember(user1);
    group.addMember(user2);
    group.addMember(user3);
  
    Expense expense1 = new Expense("e1", "Dinner", 300, user1, new EqualSplitStrategy(), group);
  
  
    group.addExpense(expense1);
  
    System.out.println(user1.getName() + "  owes" + user1.getBalanceSheet());
    System.out.println(user2.getName() + "  owes" + user2.getBalanceSheet());
    System.out.println(user3.getName() + "  owes" + user3.getBalanceSheet()); 

    Map<User, Double> unequalAmounts = new HashMap<>();
    unequalAmounts.put(user1, 100.0);
    unequalAmounts.put(user2, 150.0);
    unequalAmounts.put(user3, 50.0);

  
    Expense expense2 = new Expense("e2", "Bar", 300, user2, new UnequalSplitStrategy(unequalAmounts), group);
    group.addExpense(expense2);

    System.out.println(user1.getName() + "  owes" + user1.getBalanceSheet());
    System.out.println(user2.getName() + "  owes" + user2.getBalanceSheet());
    System.out.println(user3.getName() + "  owes" + user3.getBalanceSheet()); 
  }
}

