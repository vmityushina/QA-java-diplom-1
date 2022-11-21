import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private float price = 400f;
    private String name = "Pain au chocolat";
    private Bun bun = new Bun(name, price);

    @Test
    public void getPriceTest() {
        Assert.assertEquals( "price should be the same", price, bun.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals( "name should be the same", name, bun.getName());
    }
}
