import java.util.ArrayList;
import java.util.*;

public class Group {

  private String groupId;
  private String groupName;
  private List<User> members;
  private List<Expense> expenses;


  // constructor
  public Group(String groupId, String groupName){
    this.groupId = groupId;
    this.groupName = groupName;
    this.members = new ArrayList<>();
    this.expenses = new ArrayList<>();
  }

  // adding a member
  public void addMember(User user){
    members.add(user);
  }

  //adding an expense
  public void addExpense(Expense expense){
    expenses.add(expense);
  }

  public List<User> getMembers(){
    return members;
  }

  public List<Expense> getExpenses(){
    return expenses;
  }
}