import java.util.*;



public class Main {

  public static void main(String[] args){
    LoanService loanService = new  LoanService();

    try{
      loanService.createUser("admin1", "admin");
      loanService.createUser("customer1", "customer");

      loanService.createUser("customer2", "customer");

      // admin create loan for customers

      Loan loan1 = loanService.createLoan("admin1", "customer1", 100000, 10, 2);
      Loan loan2 = loanService.createLoan("admin1", "customer2", 50000, 8, 1);

      loanService.makePayment("customer1", loan1.getLoanId());

      System.out.println("After payment loan details: " + loanService.getLoanDetails("customer1", loan1.getLoanId()));


      System.out.println("All loans : (ADMIN ACCESS)" );
      List<Loan> allLoans  = loanService.getAllLoans("admin1");

      for(Loan loan: allLoans){
        System.out.println(loan);
      }


      System.out.println("Customer 2  making loan payments");

      for(int i = 0; i < 13; i++){
        loanService.makePayment("customer2", loan2.getLoanId());
      }


      System.out.println("After all payments for customer 2 - loan details: " + loanService.getLoanDetails("customer2", loan2.getLoanId()));

    }
    catch(Exception e){
      System.out.println("Error : " + e.getMessage());  
    }
  }
}



