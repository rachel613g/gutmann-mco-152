package gutmann.cashier;

import java.text.DecimalFormat;

public class Cashier
{
    private Cash cashInRegister;
    private Cash change;

    public Cashier(Cash cashInRegister)
    {
        this.cashInRegister = cashInRegister;
        this.change = new Cash();
    }

    public Cash pay(double price, Cash cashIN)
    {
        //determine if customer has enough cash
        if (cashIN.getTotal() < price)
        {
            throw new IllegalArgumentException("customer did not give enough cash.");
        }

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


        DecimalFormat df = new DecimalFormat(("#0.00"));

        //determine change as a double using df
        double changeInDouble = Double.parseDouble(df.format(cashIN.getTotal() - price));

       //determine optimal change to return
        while (changeInDouble > 0.00) //while the changeInDouble is larger than a penny
        {
            if (changeInDouble >= 20)
            {
                //calculate amount of twenty dollars
                int deltaTwentyDollars = (int) changeInDouble / 20;
                //check if cashier has correct change
                if (cashInRegister.getTwentyDollars() < deltaTwentyDollars)
                {
                    throwException();
                }
                //add amount to change object
                change.addTwentyDollars(deltaTwentyDollars);
                // subtract amount from change cashInRegister object
                cashInRegister.subtractTwentyDollars(deltaTwentyDollars);
                //update changeInDouble variable
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (20 * deltaTwentyDollars)));
            }
            if ((changeInDouble >= 10) && (changeInDouble < 20))
            {
                int deltaTenDollars = (int) changeInDouble / 10;
                change.addTenDollars(deltaTenDollars);
                if (cashInRegister.getTenDollars() < deltaTenDollars)
                {
                    throwException();
                }
                cashInRegister.subtractTenDollars(deltaTenDollars);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (10 * deltaTenDollars)));
            }
            if (changeInDouble >= 5 && changeInDouble < 10)
            {
                int deltaFiveDollars = (int) changeInDouble / 5;
                change.addFiveDollars(deltaFiveDollars);
                if (cashInRegister.getFiveDollars() < deltaFiveDollars)
                {
                    throwException();
                }
                cashInRegister.subtractFiveDollars(deltaFiveDollars);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (5 * deltaFiveDollars)));
            }
            if (changeInDouble >= 1 && changeInDouble < 5)
            {
                int deltaOneDollars = (int) changeInDouble;
                change.addOneDollars(deltaOneDollars);
                if (cashInRegister.getOneDollars() < deltaOneDollars)
                {
                    throwException();
                }
                cashInRegister.subtractOneDollars(deltaOneDollars);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - deltaOneDollars));
            }
            if (changeInDouble >= 0.25 && changeInDouble < 1)
            {
                int deltaQuarters = (int) (changeInDouble / 0.25);
                change.addQuarters(deltaQuarters);
                if (cashInRegister.getQuarters() < deltaQuarters)
                {
                    throwException();
                }
                cashInRegister.subtractQuarters(deltaQuarters);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (0.25 * deltaQuarters)));
            }
            if (changeInDouble >= 0.1 && changeInDouble < 0.25)
            {
                int deltaDimes = (int) (changeInDouble / 0.1);
                change.addDimes(deltaDimes);
                if (cashInRegister.getDimes() < deltaDimes)
                {
                    throwException();
                }
                cashInRegister.subtractDimes(deltaDimes);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (0.1 * deltaDimes)));
            }
            if (changeInDouble >= 0.05 && changeInDouble < 0.1)
            {
                int deltaNickels = (int) (changeInDouble / 0.05);
                change.addNickels(deltaNickels);
                if (cashInRegister.getNickels() < deltaNickels)
                {
                    throwException();
                }
                cashInRegister.subtractDimes(deltaNickels);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (0.05 * deltaNickels)));
            }
            if (changeInDouble >= 0.01 && changeInDouble < 0.05)
            {
                int deltaPennies = (int) (changeInDouble / 0.01);
                change.addPennies(deltaPennies);
                if (cashInRegister.getPennies() < deltaPennies)
                {
                    throwException();
                }
                cashInRegister.subtractPennies(deltaPennies);
                changeInDouble = Double.parseDouble(df.format(changeInDouble - (deltaPennies * 0.01)));
            }
        }

        return change;
    }

    public Cash getCashInRegister()
    {
        return cashInRegister;
    }
}
