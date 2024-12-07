package diplom1test;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

     Bun bun;

    @Test
    public void checkGetNameBunTest() {
        bun = new Bun("black bun", 100);
        Assert.assertEquals("black bun", bun.getName());
    }

    @Test
    public void checkGetPriceBunTest() {
        bun = new Bun("white bun", 200);
        Assert.assertEquals(200, bun.getPrice(), 0);
    }
}
