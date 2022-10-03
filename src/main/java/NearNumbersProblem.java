import java.net.PortUnreachableException;
import java.util.*;

// 2.Soru
public class NearNumbersProblem {
    public  String[] nearNumbers(Integer[] array){
        if (array.length<1 || array.length>1000){
            throw  new IllegalArgumentException("The size of the array is incorrect");
        }
        else {
            Set<Integer> targetSet= new HashSet<Integer>();
            Collections.addAll(targetSet,array);
            // burada tekrar eden değerleri kaldırmak için
            // dizimizi set veri yapısına çevirdim.

            Integer[] sortedArray=new Integer[targetSet.size()];
            targetSet.toArray(sortedArray);
            // ardından tekrar dizi veri yapısına çevirdim.

            Arrays.sort(sortedArray);


            // en kucuk farkı bulmak için en küçük iki sayı bulunur
            int smallestA=sortedArray[0];
            int smallestB=sortedArray[1];
            // en büyük elemanı almak için;
            int largest=sortedArray[sortedArray.length-1];
            // kısıt için :
            if (smallestA<=-20000 || largest>=20000){
                throw new IllegalArgumentException("value range is not correct");
            }

            int extract=Math.abs(smallestA-smallestB);

            List<String> strings = new ArrayList<>();
            for (int i : sortedArray){
                for (int j : sortedArray){
                    if (i==j)
                        continue;
                    if (Math.abs(i-j)==extract && i-j<0){
                        // istenildiği gibi ilk küçük değer sonra büyük
                        // değer yazılıyor.
                        strings.add(i + " " + j);
                    }
                }
            }
            String[] result = new String[strings.size()];
            strings.toArray(result);

            for (String s: result){
                System.out.println(s);
            }

            return result;

        }



    }


}
