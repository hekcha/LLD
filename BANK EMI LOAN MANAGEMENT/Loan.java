import java.util.*;

class Loan{
  private static int idCounter = 1;
  private int loanId;
  private String customerUsername;
  private double principal;
  private double rate;
  private double tenure;

  private double totalAmount;
  private double emi;

  private int emiPaidCount = 0;


  public Loan(String customerUsername, double principal, double rate, double tenure){
    this.loanId = idCounter++;
    this.customerUsername = customerUsername;
    this.principal = principal;
    this.rate = rate;
    this.tenure = tenure;

    this.totalAmount = principal + (principal * rate * tenure) / 100;

    this.emi = this.totalAmount / (tenure * 12);
  }

  // writing getter setter for the above class

  public int getLoanId(){
    return loanId;
  }


  public String getCustomerUsername(){
    return customerUsername;
  }

  public double getEmi(){
    return emi;
  }


  public void makePayment()throws Exception{
    if(emiPaidCount >= tenure * 12){
      throw new Exception("Loan fully paid");
    }

    emiPaidCount++;
  }


  public double getRemainingEMICount(){
    return ((tenure * 12) - emiPaidCount);
  }


  // public getRemaining


  @Override
  public String toString(){
    return "Loan Id: " + loanId + ", Customer: " + customerUsername + ", Principal: " + principal + ", Rate: " + rate + ", Tenure : " + tenure + " years , EMI: "
    + emi +  " ,  EMIs Paid: " +  emiPaidCount + " , Remaining EMIs: " + getRemainingEMICount();
  }

}
