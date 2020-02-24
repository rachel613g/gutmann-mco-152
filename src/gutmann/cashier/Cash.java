package gutmann.cashier;

public class Cash
{
    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;
    private int oneDollars;
    private int fiveDollars;
    private int tenDollars;
    private int twentyDollars;
    private double total;


    public Cash(int pennies, int nickels, int dimes, int quarters, int oneDollars, int fiveDollars, int tenDollars,
                int twentyDollars)
    {
        this.pennies = pennies;
        this.nickels = nickels;
        this.dimes = dimes;
        this.quarters = quarters;
        this.oneDollars = oneDollars;
        this.fiveDollars = fiveDollars;
        this.tenDollars = tenDollars;
        this.twentyDollars = twentyDollars;
        setTotal();
    }

    public Cash()
    {
        this(0, 0, 0, 0, 0, 0, 0, 0);
    }

    private void setTotal()
    {
        double pennies = this.pennies * 0.01;
        double nickels = this.nickels * 0.05;
        double dimes = this.dimes * 0.10;
        double quarters = this.quarters * 0.25;
        double oneDollars = this.oneDollars;
        double fiveDollars = this.fiveDollars * 5;
        double tenDollars = this.tenDollars * 10;
        double twentyDollars = this.twentyDollars * 20;

        total = pennies + nickels + dimes + quarters + oneDollars + fiveDollars + tenDollars + twentyDollars;
    }

    public void subtractPennies(int delta)
    {
        pennies -= delta;
        setTotal();
    }

    public void subtractNickels(int delta)
    {
        nickels =- delta;
        setTotal();
    }

    public void subtractDimes(int delta)
    {
        dimes =- delta;
        setTotal();
    }

    public void subtractQuarters(int delta)
    {
        quarters -= delta;
        setTotal();
    }

    public void subtractOneDollars(int delta)
    {
        oneDollars =- delta;
        setTotal();
    }

    public void subtractFiveDollars(int delta)
    {
        fiveDollars =- delta;
        setTotal();
    }

    public void subtractTenDollars(int delta)
    {
        tenDollars =- delta;
        setTotal();
    }

    public void subtractTwentyDollars(int delta)
    {
        twentyDollars =- delta;
        setTotal();
    }

    public void addPennies(int delta)
    {
        pennies =+ delta;
        setTotal();
    }

    public void addNickels(int delta)
    {
        nickels =+ delta;
        setTotal();
    }

    public void addDimes(int delta)
    {
        dimes =+ delta;
        setTotal();
    }

    public void addQuarters(int delta)
    {
        quarters =+ delta;
        setTotal();
    }

    public void addOneDollars(int delta)
    {
        oneDollars =+ delta;
        setTotal();
    }

    public void addFiveDollars(int delta)
    {
        fiveDollars =+ delta;
        setTotal();
    }

    public void addTenDollars(int delta)
    {
        tenDollars =+ delta;
        setTotal();
    }

    public void addTwentyDollars(int delta)
    {
        twentyDollars =+ delta;
        setTotal();
    }

    public int getPennies()
    {
        return pennies;
    }

    public int getNickels()
    {
        return nickels;
    }

    public int getDimes()
    {
        return dimes;
    }

    public int getQuarters()
    {
        return quarters;
    }

    public int getOneDollars()
    {
        return oneDollars;
    }

    public int getFiveDollars()
    {
        return fiveDollars;
    }

    public int getTenDollars()
    {
        return tenDollars;
    }

    public int getTwentyDollars()
    {
        return twentyDollars;
    }

    public double getTotal()
    {
        return total;
    }

    @Override
    public String toString()
    {
        return "Cash{" +
                "pennies=" + pennies +
                ", nickels=" + nickels +
                ", dimes=" + dimes +
                ", quarters=" + quarters +
                ", oneDollars=" + oneDollars +
                ", fiveDollars=" + fiveDollars +
                ", tenDollars=" + tenDollars +
                ", twentyDollars=" + twentyDollars +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cash cash = (Cash) o;
        return pennies == cash.pennies &&
                nickels == cash.nickels &&
                dimes == cash.dimes &&
                quarters == cash.quarters &&
                oneDollars == cash.oneDollars &&
                fiveDollars == cash.fiveDollars &&
                tenDollars == cash.tenDollars &&
                twentyDollars == cash.twentyDollars;
    }


}
