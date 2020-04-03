package gutmann.cashier;

import java.text.DecimalFormat;

public class Cashier
{
    private Cash cashInRegister;
    private Cash change;
    private Cash cashToBeTakenFromCustomer = new Cash();
    private double changeInDouble;

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

    private void throwCashierException() throws IllegalArgumentException
    {
        throw new IllegalArgumentException("Cashier doesn't have correct change.");
    }

    private void throwCustomerException()
    {
        throw new IllegalArgumentException("Customer did not give enough cash.");
    }

    public Cash pay(double price, Cash cashIN) throws IllegalArgumentException
    {
        //determine if customer has enough cash
        if (cashIN.getTotal() < price)
        {
           throwCustomerException();
        }

        DecimalFormat df = new DecimalFormat(("#0.00"));

        //determine change as a double using df
        changeInDouble = Double.parseDouble(df.format(cashIN.getTotal() - price));

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
                    // will equal zero
                    deltaTwentyDollars = cashInRegister.getTwentyDollars();
                }
                //add amount to change object
                change.addTwentyDollars(deltaTwentyDollars);
                // subtract amount from cashInRegister object
                cashInRegister.subtractTwentyDollars(deltaTwentyDollars);
                //update changeInDouble variable
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (20 * deltaTwentyDollars)));
                //update cashToSubtract variable
                cashToBeTakenFromCustomer.addTwentyDollars(cashIN.getTwentyDollars() - deltaTwentyDollars);
            }
            if ((changeInDouble >= 10))
            {
                int deltaTenDollars = (int) changeInDouble / 10;

                if (cashInRegister.getTenDollars() < deltaTenDollars)
                {
                    deltaTenDollars = cashInRegister.getTenDollars();
                }
                change.addTenDollars(deltaTenDollars);
                cashInRegister.subtractTenDollars(deltaTenDollars);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (10 * deltaTenDollars)));
                cashToBeTakenFromCustomer.addTenDollars(cashIN.getTenDollars() - deltaTenDollars);
            }
            if (changeInDouble >= 5)
            {
                int deltaFiveDollars = (int) changeInDouble / 5;
                if (cashInRegister.getFiveDollars() < deltaFiveDollars)
                {
                  deltaFiveDollars = cashInRegister.getFiveDollars();
                }
                change.addFiveDollars(deltaFiveDollars);
                cashInRegister.subtractFiveDollars(deltaFiveDollars);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (5 * deltaFiveDollars)));
                cashToBeTakenFromCustomer.addFiveDollars(cashIN.getFiveDollars() - deltaFiveDollars);
            }
            if (changeInDouble >= 1)
            {
                int deltaOneDollars = (int) changeInDouble;
                if (cashInRegister.getOneDollars() < deltaOneDollars)
                {
                    deltaOneDollars = cashInRegister.getOneDollars();
                }
                change.addOneDollars(deltaOneDollars);
                cashInRegister.subtractOneDollars(deltaOneDollars);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - deltaOneDollars));
                cashToBeTakenFromCustomer.addOneDollars(cashIN.getOneDollars() - deltaOneDollars);
            }
            if (changeInDouble >= 0.25)
            {
                int deltaQuarters = (int) (changeInDouble / 0.25);
                if (cashInRegister.getQuarters() < deltaQuarters)
                {
                    deltaQuarters = cashInRegister.getQuarters();
                }
                change.addQuarters(deltaQuarters);
                cashInRegister.subtractQuarters(deltaQuarters);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (0.25 * deltaQuarters)));
                cashToBeTakenFromCustomer.addQuarters(cashIN.getQuarters() - deltaQuarters);
            }
            if (changeInDouble >= 0.1)
            {
                int deltaDimes = (int) (changeInDouble / 0.1);
                if (cashInRegister.getDimes() < deltaDimes)
                {
                    deltaDimes = cashInRegister.getDimes();
                }
                change.addDimes(deltaDimes);
                cashInRegister.subtractDimes(deltaDimes);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (0.1 * deltaDimes)));
                cashToBeTakenFromCustomer.addDimes(cashIN.getDimes() - deltaDimes);
            }
            if (changeInDouble >= 0.05)
            {
                int deltaNickels = (int) (changeInDouble / 0.05);
                if (cashInRegister.getNickels() < deltaNickels)
                {
                    deltaNickels = cashInRegister.getNickels();
                }
                change.addNickels(deltaNickels);
                cashInRegister.subtractDimes(deltaNickels);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (0.05 * deltaNickels)));
                cashToBeTakenFromCustomer.addNickels(cashIN.getNickels() - deltaNickels);
            }
            if (changeInDouble >= 0.01)
            {
                int deltaPennies = (int) (changeInDouble / 0.01);

                if (cashInRegister.getPennies() < deltaPennies)
                {
                  deltaPennies = cashInRegister.getPennies();
                }
                change.addPennies(deltaPennies);
                cashInRegister.subtractPennies(deltaPennies);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (deltaPennies * 0.01)));
                cashToBeTakenFromCustomer.addPennies(cashIN.getPennies() - deltaPennies);
            }

            if (changeInDouble > 0)
            {
                throwCashierException();
            }
        }
        addCustomerChangeToRegister(cashIN);
        takeCashFromCustomer(cashIN);

        return change;
    }

    private void addCustomerChangeToRegister(Cash cashIN)
    {

        //add cash to register if necessary
        if (cashToBeTakenFromCustomer.getPennies() > 0)
        {
            cashInRegister.addPennies(cashToBeTakenFromCustomer.getPennies());
        }
        if (cashToBeTakenFromCustomer.getNickels() > 0)
        {
            cashInRegister.addNickels(cashToBeTakenFromCustomer.getNickels());
        }
        if (cashToBeTakenFromCustomer.getDimes() > 0)
        {
            cashInRegister.addDimes(cashToBeTakenFromCustomer.getDimes());
        }
        if (cashToBeTakenFromCustomer.getQuarters() > 0)
        {
            cashInRegister.addQuarters(cashToBeTakenFromCustomer.getQuarters());
        }
        if (cashToBeTakenFromCustomer.getOneDollars() > 0)
        {
            cashInRegister.addOneDollars(cashToBeTakenFromCustomer.getOneDollars());
        }
        if (cashToBeTakenFromCustomer.getFiveDollars() > 0)
        {
            cashInRegister.addFiveDollars(cashToBeTakenFromCustomer.getFiveDollars());
        }
        if (cashToBeTakenFromCustomer.getTenDollars() > 0)
        {
            cashInRegister.addTenDollars(cashToBeTakenFromCustomer.getTenDollars());
        }
        if (cashToBeTakenFromCustomer.getTwentyDollars() > 0)
        {
            cashInRegister.addTwentyDollars(cashToBeTakenFromCustomer.getTwentyDollars());
        }
    }

    private void takeCashFromCustomer(Cash cashIN)
    {
        if (cashToBeTakenFromCustomer.getPennies() > 0)
        {
            cashIN.subtractPennies(cashToBeTakenFromCustomer.getPennies());
        }
        if (cashToBeTakenFromCustomer.getNickels() > 0)
        {
            cashIN.subtractNickels(cashToBeTakenFromCustomer.getNickels());
        }
        if (cashToBeTakenFromCustomer.getDimes() > 0)
        {
            cashIN.subtractDimes(cashToBeTakenFromCustomer.getDimes());
        }
       if (cashToBeTakenFromCustomer.getQuarters() > 0)
       {
           cashIN.subtractQuarters(cashToBeTakenFromCustomer.getQuarters());
       }
       if (cashToBeTakenFromCustomer.getOneDollars() > 0)
       {
           cashIN.subtractOneDollars(cashToBeTakenFromCustomer.getOneDollars());
       }
        if (cashToBeTakenFromCustomer.getFiveDollars() > 0)
        {
            cashIN.subtractFiveDollars(cashToBeTakenFromCustomer.getFiveDollars());
        }
        if (cashToBeTakenFromCustomer.getTenDollars() > 0)
        {
            cashIN.subtractTenDollars(cashToBeTakenFromCustomer.getTenDollars());
        }
        if (cashToBeTakenFromCustomer.getTwentyDollars() > 0)
        {
            cashIN.subtractTwentyDollars(cashToBeTakenFromCustomer.getTwentyDollars());
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
