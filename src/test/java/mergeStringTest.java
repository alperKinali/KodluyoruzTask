import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mergeStringTest {

    private  MergeString mergeString;

    @BeforeMethod
    public void setUp(){
        mergeString=new MergeString();
    }
    @Test
    public  void whenUnconstrainedValuesThenReturnIllegalArgumentException(){
        Assert.assertThrows(IllegalArgumentException.class,
                ()->{
                mergeString.merge("","");
                    // burada kısıtlara uymayan bir değer verdim
                    // Örneğin 2500'den büyük bir str değer de verilebilirdi.
                });

    }
    @Test
    public void whenConstraintsAreMet(){
        // kısıt yoksa
        Assert.assertEquals("haratres",mergeString.merge("hrte","aars"),"test failed");
    }



}


