import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{

  @Override
  public List<Split> split(double amount, List<User> users){
    List<Split> splits = new ArrayList<>();
    double splitAmount = amount / users.size();
    for(User user: users){
      splits.add(new Split(user, splitAmount));
    }
    return splits;
  }
}