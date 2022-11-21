import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    private float price = 400f;
    private String name = "Cutlet";
    private IngredientType ingredientType = IngredientType.SAUCE;
    Ingredient ingredient = new Ingredient(ingredientType, name, price);

    @Test
    public void getPriceTest() {
        Assert.assertEquals( "price should be the same", price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals( "name should be the same", name, ingredient.getName());
    }

    @Test
    public void getIngredientTypeTest() {
        Assert.assertEquals( "ingredient type should be the same", ingredientType, ingredient.getType());
    }
}
