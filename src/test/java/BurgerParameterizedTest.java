import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Spy
    private Database database;

    private String expected;
    private int numberOfIngredients;

    public BurgerParameterizedTest (int numberOfIngredients, String expected) {
        this.numberOfIngredients = numberOfIngredients;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                        {0, "(==== black bun ====)" + System.lineSeparator() +
                                "(==== black bun ====)" +
                                System.lineSeparator() + System.lineSeparator() +
                                "Price: 200,000000" + System.lineSeparator()},
                        {1, "(==== black bun ====)" + System.lineSeparator() +
                                "= sauce hot sauce =" + System.lineSeparator() +
                                "(==== black bun ====)" +
                                System.lineSeparator() + System.lineSeparator() +
                                "Price: 300,000000" + System.lineSeparator()},
                        {2, "(==== black bun ====)" + System.lineSeparator() +
                                "= sauce hot sauce =" + System.lineSeparator() +
                                "= sauce hot sauce =" + System.lineSeparator() +
                                "(==== black bun ====)" + System.lineSeparator() +
                                System.lineSeparator() +
                                "Price: 400,000000" + System.lineSeparator()},
                });
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        String bunName = database.availableBuns().get(0).getName();
        Mockito.when(bun.getName()).thenReturn(bunName);
        burger.setBuns(bun);

        for (int i = 0; i < numberOfIngredients; i++) {
            burger.addIngredient(database.availableIngredients().get(0));
        }
        Mockito.when(ingredient.getName()).thenCallRealMethod();
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
