import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void enumTest() {
        Assert.assertEquals("there should be two types of ingredients", IngredientType.values().length, 2);
    }

}
