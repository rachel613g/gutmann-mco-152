package gutmann.cashier;

import java.text.DecimalFormat;

public class Cashier
{
    private Cash cashInRegister;
    private Cash change;

    public Cashier(Cash cashInRegister) throws IllegalArgumentException
    {
        this.cashInRegister = cashInRegister;
        this.change = new Cash();
    }

    //copy constructor
    public Cashier (Cashier copyThis)
    {
        this.cashInRegister = copyThis.getCashInRegister();
        this.change = copyThis.getChange();
    }

    private void throwException() throws IllegalArgumentException
    {
        throw new IllegalArgumentException("Cashier doesn't have correct change.");
    }

    public Cash pay(double price, Cash cashIN) throws IllegalArgumentException
    {
        //determine if customer has enough cash
        if (cashIN.getTotal() < price)
        {
            throw new IllegalArgumentException("Customer did not give enough cash.");
        }

        DecimalFormat df = new DecimalFormat(("#0.00"));

        //determine change as a double using df
        double changeInDouble = Double.parseDouble(df.format(cashIN.getTotal() - price));

       //determine change to return
        while (changeInDouble > 0.00) //while the changeInDouble is larger than a penny
        {
            if (changeInDouble >= 20)
            {
                //calculate amount of twenty dollars needed for change
                int deltaTwentyDollars = (int) changeInDouble / 20;

                //check if cashier has twentys
                 if (cashInRegister.getTwentyDollars() < deltaTwentyDollars)
                {
                    //if not enough, change delta to what register does have. If there is zero, deltaTwentyDollars
                    // wil equal zero
                    deltaTwentyDollars = cashInRegister.getTwentyDollars();
                }
                //add amount to change object
                change.addTwentyDollars(deltaTwentyDollars);
                // subtract amount from cashInRegister object
                cashInRegister.subtractTwentyDollars(deltaTwentyDollars);
                //update changeInDouble variable
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (20 * deltaTwentyDollars)));
            }
            if ((changeInDouble >= 10) && (changeInDouble < 20))
            {
                int deltaTenDollars = (int) changeInDouble / 10;

                if (cashInRegister.getTenDollars() < deltaTenDollars)
                {
                    deltaTenDollars = cashInRegister.getTenDollars();
                }
                change.addTenDollars(deltaTenDollars);
                cashInRegister.subtractTenDollars(deltaTenDollars);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (10 * deltaTenDollars)));
            }
            if (changeInDouble >= 5 && changeInDouble < 10)
            {
                int deltaFiveDollars = (int) changeInDouble / 5;
                if (cashInRegister.getFiveDollars() < deltaFiveDollars)
                {
                  deltaFiveDollars = cashInRegister.getFiveDollars();
                }
                change.addFiveDollars(deltaFiveDollars);
                cashInRegister.subtractFiveDollars(deltaFiveDollars);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (5 * deltaFiveDollars)));
            }
            if (changeInDouble >= 1 && changeInDouble < 5)
            {
                int deltaOneDollars = (int) changeInDouble;
                if (cashInRegister.getOneDollars() < deltaOneDollars)
                {
                    deltaOneDollars = cashInRegister.getOneDollars();
                }
                change.addOneDollars(deltaOneDollars);
                cashInRegister.subtractOneDollars(deltaOneDollars);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - deltaOneDollars));
            }
            if (changeInDouble >= 0.25 && changeInDouble < 1)
            {
                int deltaQuarters = (int) (changeInDouble / 0.25);
                if (cashInRegister.getQuarters() < deltaQuarters)
                {
                    deltaQuarters = cashInRegister.getQuarters();
                }
                change.addQuarters(deltaQuarters);
                cashInRegister.subtractQuarters(deltaQuarters);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (0.25 * deltaQuarters)));
            }
            if (changeInDouble >= 0.1 && changeInDouble < 0.25)
            {
                int deltaDimes = (int) (changeInDouble / 0.1);
                if (cashInRegister.getDimes() < deltaDimes)
                {
                    deltaDimes = cashInRegister.getDimes();
                }
                change.addDimes(deltaDimes);
                cashInRegister.subtractDimes(deltaDimes);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (0.1 * deltaDimes)));
            }
            if (changeInDouble >= 0.05 && changeInDouble < 0.1)
            {
                int deltaNickels = (int) (changeInDouble / 0.05);
                if (cashInRegister.getNickels() < deltaNickels)
                {
                    deltaNickels = cashInRegister.getNickels();
                }
                change.addNickels(deltaNickels);
                cashInRegister.subtractDimes(deltaNickels);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (0.05 * deltaNickels)));
            }
            if (changeInDouble >= 0.01 && changeInDouble < 0.05)
            {
                int deltaPennies = (int) (changeInDouble / 0.01);

                if (cashInRegister.getPennies() < deltaPennies)
                {
                  deltaPennies = cashInRegister.getPennies();
                }
                change.addPennies(deltaPennies);
                cashInRegister.subtractPennies(deltaPennies);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (deltaPennies * 0.01)));
            }
        }
        addCustomerChangeToRegister(cashIN);

        return change;
    }

    private void addCustomerChangeToRegister(Cash cashIN)
    {

        //add cash to register if necessary
        if (cashIN.getPennies() > 0)
        {
            cashInRegister.addPennies(cashIN.getPennies());
        }
        if (cashIN.getNickels() > 0)
        {
            cashInRegister.addNickels(cashIN.getNickels());
        }
        if (cashIN.getDimes() > 0)
        {
            cashInRegister.addDimes(cashIN.getDimes());
        }
        if (cashIN.getQuarters() > 0)
        {
            cashInRegister.addQuarters(cashIN.getQuarters());
        }
        if (cashIN.getOneDollars() > 0)
        {
            cashInRegister.addOneDollars(cashIN.getOneDollars());
        }
        if (cashIN.getFiveDollars() > 0)
        {
            cashInRegister.addFiveDollars(cashIN.getFiveDollars());
        }
        if (cashIN.getTenDollars() > 0)
        {
            cashInRegister.addTenDollars(cashIN.getTenDollars());
        }
        if (cashIN.getTwentyDollars() > 0)
        {
            cashInRegister.addTwentyDollars(cashIN.getTwentyDollars());
        }
    }

    public Cash getCashInRegister()
    {
        return cashInRegister;
    }

    public Cash getChange()
    {
        return change;
    }
}
