import java.util.*;



public class LoanService {

  private Map<String, User> users = new HashMap<>();
  private Map<Integer, Loan> loans = new HashMap<>();

  public void createUser(String username, String type)throws Exception{
    if(users.containsKey(username)){
      throw new Exception("User already exists");
    }

    if(type.equals("admin")){
      users.put(username, new Admin(username));
    }
    else if(type.equals("customer")){
      users.put(username, new Customer(username));
    }
    else{
      throw new Exception("Invalid user type");
    }  
  }

  public Loan createLoan(String adminUsername, String customerUsername, double principal, double rate, int tenure) throws Exception{
    if(!(users.get(adminUsername) instanceof Admin)){
      throw new Exception("Only admin can create loans");
    }

    // checking customer validation
    if(!(users.get(customerUsername) instanceof Customer)){
      throw new Exception("Customer not found");
    }

    Loan loan = new Loan(customerUsername, principal, rate, tenure);
    loans.put(loan.getLoanId(), loan);  

    return loan;

  }


  public Loan getLoanDetails(String customerUsername, int loanId)throws Exception{
    Loan loan = loans.get(loanId);

    if(loan == null){
      throw new Exception("Loan not found");
    }
    // that loan is taken by that customer or not
    if(!loan.getCustomerUsername().equals(customerUsername) && !(users.get(customerUsername) instanceof Admin)){
      throw new Exception("Unauthorize Access");
    }


    return loan;

  }


  public void makePayment(String customerUserName, int loanId)throws Exception{
    Loan loan = getLoanDetails(customerUserName, loanId);

    if(!loan.getCustomerUsername().equals(customerUserName)){
      throw new Exception("Payment only allowed for loan owner");
    }


    loan.makePayment();
  }

  public List<Loan> getAllLoans(String adminUsername)throws Exception{

    if(!(users.get(adminUsername) instanceof Admin)){
      throw new Exception("Only admin can view all loans.");
    }

    return new ArrayList<>(loans.values());

  }
  
}