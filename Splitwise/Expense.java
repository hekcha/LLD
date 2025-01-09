import java.util.List;

public class Expense {
  private String expenseId;
  private String description;
  private double amount;
  private User paidBy;
  private SplitStrategy splitStrategy;
  private List<Split> splitInfo;


  public Expense(String expenseId, String description, double amount, User paidBy, SplitStrategy splitStrategy, Group group){
    this.expenseId = expenseId;
    this.description = description;
    this.amount = amount;
    this.paidBy = paidBy;
    this.splitStrategy = splitStrategy;
    this.splitInfo = splitStrategy.split(amount, group.getMembers());
    updateBalances();
  }

  private void updateBalances(){
    for(Split split: splitInfo){
      if(!split.getUser().getUserId().equals(paidBy.getUserId())){
        paidBy.updateBalance(split.getUser(), split.getAmount());

        split.getUser().updateBalance(paidBy, -split.getAmount());
      }
    }
  }

}