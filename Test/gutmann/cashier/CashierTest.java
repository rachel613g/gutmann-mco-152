package gutmann.cashier;
import org.junit.Test;
import static org.junit.Assert.*;
import static junit.framework.Assert.assertEquals;
public class CashierTest
{
    @Test
    public void pay()
    {
        //given
        Cash customerCash = new Cash(0,0,0,0,3,
                0,0,0);
        Cash register = new Cash(100, 0, 0, 100, 0,
                0, 0, 0);
        Cashier cashier = new Cashier(register);

        //when
        Cash change = cashier.pay(2.49, customerCash);


        //then
        Cash customerAssert = new Cash(1, 0, 0, 2, 0,
                0, 0, 0);
        Cash registerAssert = new Cash(99, 0, 0, 98, 3,
                0,0,0);
        assertEquals(customerAssert, change);
        assertEquals(registerAssert, cashier.getCashInRegister());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void brokeCashier() throws IllegalArgumentException
    {
        //given
        Cash customerCash = new Cash(0,0,0,0,3,
                0,0,0);
        Cashier cashier = new Cashier(new Cash(0, 0, 0, 0, 0,
                0, 0, 0));

        //when
        Cash change = cashier.pay(2.49, customerCash);

    }
    @Test(expected = IllegalArgumentException)
    public void notEnoughChange()
    {
        //given
        Cash customerCash = new Cash(0,0,0,0,3,
                0,0,0);
        Cashier cashier = new Cashier(new Cash(1, 0, 0, 0, 0,
                0, 0, 0));

        //when
        Cash change = cashier.pay(2.49, customerCash);

    }

}
