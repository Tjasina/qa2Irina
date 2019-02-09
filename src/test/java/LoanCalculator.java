import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoanCalculator {
    @Test
    public void LoanCalculator (){

        double loansum= 10000;
        int month;
        double monthLoan;
        double totalsum =0;
        for (month=1; month<360; month++) {
            if (month<=120)
                monthLoan = (loansum/(360 - month)+ loansum*0.1);
            else if (month<=240)
                monthLoan = (loansum/(360 - month)+ loansum*0.08);
            else
            monthLoan = (loansum/(360 - month)+ loansum*0.06);
            //System.out.println("monthLoan: " + monthLoan);

        totalsum = totalsum + monthLoan;
        }
        totalsum=Math.round(totalsum);
        System.out.println("total sum is:" + totalsum);
        Assertions.assertEquals(352019.0 , totalsum, "Sum is not correct!");
    }
}

