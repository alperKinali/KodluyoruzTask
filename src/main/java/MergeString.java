public class MergeString {

    // 1. Soru
    public String merge(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int i =0,j =0;
        if ((a.length()<=1 ||a.length()>=2500) &&  (b.length()<=1 ||b.length()>=2500) ){
            // kısıtlara uyulmadığı zaman.
            throw  new IllegalArgumentException("a and b did not comply with the constraints");
        }
        else {
            // kısıtlara uyulursa
            while (i<a.length() || j<b.length()){
                if (i<a.length()){
                    stringBuilder.append(a.charAt(i++));
                }
                if (j<b.length()){
                    stringBuilder.append(b.charAt(j++));
                }
            }
            return stringBuilder.toString();
        }
    }
}
