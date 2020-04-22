package gutmann.projectile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectileMath
{

    public static final int NUM_PROJECTILES = 5;

    public static void main(String [] args)
    {
        //instantiate random generator for angle and velocity
        Random random = new Random();


        //generate 5 projectiles with randomly generated doubles as arguments

        ArrayList<Projectile> projectileList = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            projectileList.add(new Projectile(random.nextDouble() * 180 , random.nextDouble() * 100) );
        }

            //increase time by increments of 1 and print projectile name and toString
        for (Projectile projectile : projectileList)
        {
            for (int i = 0; i < 11; i++)
            {
                System.out.println(projectile.toString());
                projectile.increaseTime(1);
            }
        }


    }
}
