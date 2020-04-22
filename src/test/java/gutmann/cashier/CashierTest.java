package gutmann.cashier;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static junit.framework.Assert.assertEquals;

public class CashierTest
{
    @Test
    public void pay()
    {
        //given
        Cash customerCash = new Cash(0, 0, 0, 0, 3,
                0, 0, 0);
        Cashier cashier = new Cashier(new Cash(100, 0, 0, 100, 0,
                0, 0, 0));

        //when
        Cash change = cashier.pay(2.49, customerCash);


        //then
        Cash changeAssert = new Cash(1, 0, 0, 2, 0,
                0, 0, 0);
        Cash registerAssert = new Cash(99, 0, 0, 98, 3,
                0, 0, 0);
        assertEquals(changeAssert, change);
        assertEquals(registerAssert, cashier.getCashInRegister());
    }

    @Test(expected = IllegalArgumentException.class)
    public void brokeCashier() throws IllegalArgumentException
    {
        //given
        Cash customerCash = new Cash(0, 0, 0, 0, 3,
                0, 0, 0);
        Cashier cashier = new Cashier(new Cash(0, 0, 0, 0, 0,
                0, 0, 0));

        //when
        cashier.pay(2.49, customerCash);

        //then it should throw exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEnoughChange() throws IllegalArgumentException
    {
        //given
        Cash customerCash = new Cash(0, 0, 0, 0, 3,
                0, 0, 0);
        Cashier cashier = new Cashier(new Cash(1, 0, 0, 0, 0,
                0, 0, 0));

        //when
        cashier.pay(2.49, customerCash);

        //then it should throw exception
    }

    @Test
    public void payException()
    {
        //given
        Cash customerCash = new Cash(0, 0, 0, 0, 3,
                0, 0, 0);
        Cashier cashier = new Cashier(new Cash(1, 0, 0, 0, 0,
                0, 0, 0));
        Cashier assertCashier = new Cashier(cashier);
      try
      {
          //when
          cashier.pay(2.49, customerCash);

          //then
          // exception will be thrown, but cashier object's change should not be changed.
      } catch (IllegalArgumentException e)
      {
          assertEquals(assertCashier.getCashInRegister(), cashier.getCashInRegister());
      }


    }
    //below test needs some serious work
@Test
    public void payWithNotOptimalChange()
    {
        //given
        Cash customerCash = new Cash(0, 0, 0, 0, 1,
                0, 0,1 );
        Cashier cashier = new Cashier(new Cash(100, 0, 0, 0, 0,
                0, 0, 0));

        //when
        Cash change = cashier.pay(20.50, customerCash);


        //then
        Cash customerAssert = new Cash(50, 0, 0, 0, 0,
                0, 0, 0);
        Cash registerAssert = new Cash(50, 0, 0, 0, 1, 0, 0, 1);
        assertEquals(customerAssert, change);
        assertEquals(registerAssert, cashier.getCashInRegister());
    }

}
