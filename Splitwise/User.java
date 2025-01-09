import java.util.*;
import java.util.HashMap;

public class User{
  private String userId;
  private String name;
  private String email;
  private Map<String, Double> balanceSheet;

  public User(String userId, String name, String email){
    this.userId = userId;
    this.name = name;
    this.email = email;
    this.balanceSheet = new HashMap<>();
  }

  public String getUserId(){
    return userId;
  }

  public String getName(){
    return name;
  }

  public String getEmail(){
    return email;
  }

  public Map<String, Double> getBalanceSheet(){
    return balanceSheet;
  }

  public void updateBalance(User other, double amount){
    // will update later after writing balance sheet method
    balanceSheet.put(other.getUserId(), balanceSheet.getOrDefault(other.getUserId(), 0.0) + amount );
  }
}