import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class UnequalSplitStrategy implements SplitStrategy{
  private Map<User, Double>  userAmounts;

  public UnequalSplitStrategy(Map<User, Double> userAmounts){
    this.userAmounts = userAmounts;
  }

  @Override
  public List<Split> split(double amount, List<User> users){
    List<Split> splits = new ArrayList<>();

    for(User user: users){
      splits.add(new Split(user, userAmounts.get(user)));
    }
    return splits;
  }
}
