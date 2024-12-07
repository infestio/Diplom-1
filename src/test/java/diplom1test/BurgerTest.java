package diplom1test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;


import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();
    private static final String ACTUAL_RECEIPT = String.format("(==== red bun ====)%n= sauce sweet sauce =%n= filling chicken =%n(==== red bun ====)%n%nPrice: 300,000000%n");

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    @Test
    public void checkSetBunBurgerTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientBurgerTest() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientBurgerTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientBurgerTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        Assert.assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceBurgerBunTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(100));
        Assert.assertEquals(200, burger.getPrice(), 0);
    }

    @Test
    public void getPriceBurgerIngredientTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(50));
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Mockito.when(ingredient.getPrice()).thenReturn(Float.valueOf(100));
        Mockito.when(ingredient2.getPrice()).thenReturn(Float.valueOf(100));
        Assert.assertEquals(300, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptBurgerTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sweet sauce");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("chicken");
        Mockito.when(burger.getPrice()).thenReturn(Float.valueOf(300));
        Assert.assertEquals(ACTUAL_RECEIPT, burger.getReceipt());
    }
}
