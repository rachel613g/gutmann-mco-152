package gutmann.projectile;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ProjectileTest
{
    @Test
    public void getX()
    {
        //given
        Projectile projectile = new Projectile(53.26, 82);
        projectile.increaseTime(5);
        //when
        //the specific part of the method you are testing
        double x = projectile.getX();

        //then
        assertEquals(245.2557, x, 0.0001);
    }

    @Test
    public void increaseTime()
    {
        //given
        Projectile projectile = new Projectile(53.26, 82);

        //when
        projectile.increaseTime(5);
        double time = projectile.getTime();

        //then
        assertEquals(5.0, time);
    }

}