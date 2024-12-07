package diplom1test;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    Ingredient ingredient;

    @Test
    public void checkGetNameIngredientTest() {
        ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Assert.assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void checkGetPriceIngredientTest() {
        ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Assert.assertEquals(100, ingredient.getPrice(),0);
    }
}
