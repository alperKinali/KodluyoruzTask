import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    // 3. Soru için
    public  String shoppingCart(int[] array){
        List<Integer> noDiscountsValues = new ArrayList<>();
        int sum=0;
        String result ="";

        // sonuncu kaleme hiçbir zaman indirim uygulanmıyor bu nedenle
        // o değer her halükarda bulunmalı
        int lastElemntArr=array[array.length-1];
        noDiscountsValues.add(lastElemntArr);

        // içinde ki değerleri kont etmek için
        int[] tempArray = new int[array.length];
        tempArray = Arrays.copyOf(array, array.length);
        Arrays.sort(tempArray);
        int smallest=tempArray[0];
        int bigest = tempArray[tempArray.length-1];
        if (smallest<=0 || bigest>=2000){
            throw new IllegalArgumentException("value range is not correct");
        }

        if ((array.length<=1 || array.length>=100)){
            throw  new IllegalArgumentException("The size of the array is incorrect");
        }
        else {
            for (int i = 0; i <array.length-1 ; i++) {
                if (array[i+1]>array[i]){
                    //continue;
                    noDiscountsValues.add(array[i]);
                }else if (array[i+1]<array[i]){
                    array[i]=array[i]-array[i+1];
                }
            }
            // sıralı olması için
            Collections.sort(noDiscountsValues);
            // array stringe çevirildi
            String listOfNoDiscountValues = noDiscountsValues.stream().map(Object::toString)
                    .collect(Collectors.joining(", "));
            // toplam için
            for (int j : array) {
                sum += j;
            }

            result="Toplam Tutar : "+ sum + ","+ "İndirim Yapılmayan Kalemler : "+ listOfNoDiscountValues;
            System.out.println(result);
            return  result;

        }

    }

}
