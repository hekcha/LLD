import java.util.List;

public interface SplitStrategy {
  List<Split> split(double amount, List<User> user);
}