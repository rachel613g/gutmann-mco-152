package gutmann.projectile;

import java.text.DecimalFormat;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Projectile
{
    private final double angle;
    private final double velocity;
    private double time = 0;
    public static final double EARTH_GRAVITY = 9.8;

    public Projectile(double angle, double velocity)
    {
        this.angle = Math.toRadians(angle);
        this.velocity = velocity;
    }

    public double getX()
    {
        return velocity * cos(angle) * time;
    }

    public double getY()
    {
        return velocity * sin(angle) * time  - EARTH_GRAVITY * time * time;
    }

    //I don't know if increase time or just a new time
    public void increaseTime(double delta)
    {
        time += delta;
    }

    public double getTime()
    {
        return time;
    }
    @Override
    public String toString()
    {
        //Instantiate decimal format object so x and y values can be rounded to the hundredths place. Long numbers are scary.
        DecimalFormat df = new DecimalFormat("0.00");
        return  time + ": (" + df.format(getX()) + ", " + df.format(getY()) +")";
    }
}

