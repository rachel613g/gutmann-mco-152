package gutmann.cashier;

public class Cashier
{
    private Cash cashInRegister;
    private Cash change;

    public Cashier(Cash cashInRegister)
    {
        this.cashInRegister = cashInRegister;
    }

    public Cash pay(double price, Cash cashIN)
    {
        //determine if customer has enough cash
        if (cashIN.getTotal() < price)
        {
            throw new IllegalArgumentException("customer did not give enough cash.");
        }

        //add cash to register using setters
        cashInRegister.addPennies(cashIN.getPennies());
        cashInRegister.addNickels(cashIN.getNickels());
        cashInRegister.addDimes(cashIN.getDimes());
        cashInRegister.addQuarters(cashIN.getQuarters());
        cashInRegister.addOneDollars(cashIN.getOneDollars());
        cashInRegister.addFiveDollars(cashIN.getFiveDollars());
        cashInRegister.addTenDollars(cashIN.getTenDollars());
        cashInRegister.addTwentyDollars(cashIN.getTwentyDollars());

        //determine change as a double
        double changeInDouble = cashIN.getTotal() - price;

        //determine optimal change to return
        while (changeInDouble > 0.001) //while the changeInDouble is larger than a penny
        {
            if (changeInDouble >= 20)
            {
                //calculate amount of twenty dollars
                //I hope it rounds down
                int deltaTwentyDollars = (int) changeInDouble / 20;
                //add amount to change object
                change.addTwentyDollars(deltaTwentyDollars);
                //update changeInDouble variable
                changeInDouble -= deltaTwentyDollars * 20;
            }
            if ((changeInDouble >= 10) && (changeInDouble < 20))
            {
                int deltaTenDollars = (int) changeInDouble / 10;
                change.addTenDollars(deltaTenDollars);
                changeInDouble = -deltaTenDollars * 10;
            }
            if (changeInDouble >= 5 && changeInDouble < 10)
            {
                int deltaFiveDollars = (int) changeInDouble / 5;
                change.addFiveDollars(deltaFiveDollars);
                changeInDouble = -deltaFiveDollars * 5;
            }
            if (changeInDouble >= 1 && changeInDouble < 5)
            {
                int deltaOneDollars = (int) changeInDouble;
                change.addOneDollars(deltaOneDollars);
                changeInDouble =- deltaOneDollars;
            }
            if (changeInDouble >= 0.25 && changeInDouble < 1)
            {
                int deltaQuarters = (int) (changeInDouble / 0.25);
                change.addQuarters(deltaQuarters);
                changeInDouble =- deltaQuarters * 0.25;
            }
            if (changeInDouble >= 0.1 && changeInDouble < 0.25)
            {
                int deltaDimes = (int) (changeInDouble/0.1);
                change.addDimes(deltaDimes);
                changeInDouble =- deltaDimes * 0.1;
            }
            if (changeInDouble >= 0.05 && changeInDouble < 0.1)
            {
                int deltaNickels = (int) (changeInDouble/0.05);
                change.addNickels(deltaNickels);
                changeInDouble =- deltaNickels * 0.05;
            }
            if (changeInDouble >= 0.01 && changeInDouble < 0.05)
            {
                int deltaPennies = (int) (changeInDouble/0.01);
                change.addOneDollars(deltaPennies);
                changeInDouble =- deltaPennies * 0.01;
            }
        }

        return change;
    }


}
