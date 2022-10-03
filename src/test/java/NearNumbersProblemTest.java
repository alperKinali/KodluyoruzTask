import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// 2. Soru Unit Test kısmı.
public class NearNumbersProblemTest {
    private NearNumbersProblem nearNumbersProblem;

    @BeforeMethod
    public  void  setUp(){
        nearNumbersProblem=new NearNumbersProblem();
    }
    @Test
    public  void whenRestrictionsAreNotFollowed(){
        Assert.assertThrows(IllegalArgumentException.class,
                ()->{
            nearNumbersProblem.nearNumbers(new Integer[200000]);
            // burada kıstlardan aykırı bir değer tespi girildi.
                });
    }
    @Test
    public  void whenArrayElementsDontMeetTheConstraint(){
        Integer[] a= new Integer[]{3, 1, 5, 23, 2, 4, 9, 10, 15, 31,250000};
        Assert.assertThrows(IllegalArgumentException.class,
                ()->{
                    nearNumbersProblem.nearNumbers(a);
                    // burada kıstlardan aykırı bir değer tespi girildi.
                });
    }
    @Test
    public void test1(){
        Assert.assertEquals(new String[]{"1 2", "2 3", "3 4", "4 5", "9 10",}
                , nearNumbersProblem.nearNumbers(new Integer[]{5, 3, 1, 9, 11, 22, 33, 44, 47, 31})
                , "Test failed");
    }




}
