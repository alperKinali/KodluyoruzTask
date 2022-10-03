import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartTest {
    // 3. Sorunun Test kısmı için

    private ShoppingCart shoppingCart;

    @BeforeMethod
    public  void  setUp(){
        shoppingCart=new ShoppingCart();
    }
    @Test
     public void whenSizeOfArrayIsIncorrect(){
        // kısıt olduğu durumda
        Assert.assertThrows(IllegalArgumentException.class,
                ()->{
                    shoppingCart.shoppingCart(new int[200000]);
                    // burada kıstlardan aykırı bir değer tespi girildi.
                });
    }

    @Test
    public void whenArrayElementsDontMeetTheConstraint(){
        // kısıt olduğu durumda
        Assert.assertThrows(IllegalArgumentException.class,
                ()->{
                    shoppingCart.shoppingCart(new int[] {3000});
                    // 3000 kısıtların dışında bir değer.
                    // burada kıstlardan aykırı bir değer tespi girildi.
                });
    }



    @Test
    public void whenConstraintsAreMet(){
        // kısıt yoksa
        Assert.assertEquals("Toplam Tutar : 15,İndirim Yapılmayan Kalemler : 3, 4, 5",shoppingCart.shoppingCart(new int[]{5, 6, 4, 3, 4}),"test failed");
    }
}
