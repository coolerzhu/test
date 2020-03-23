import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        String str = "{¡®A¡¯: 1, ¡®B.A¡¯: 2, ¡®B.B¡¯: 3, ¡®CC.D.E¡¯: 4, ¡®CC.D.F¡¯: 5}";
        Json
        str = str.substring(1, str.length() - 1);
        String[] split = str.split(",");
        Map strMap1 = new HashMap();//×îÍâÒ»²ã
        String[] splits = null;
        String[] keys = null;
        Map temp = new HashMap<List,String>();
        int keysLength= 0;
        for (int i = 0; i <split.length ; i++) {
            splits =split[i].split(":");
            keysLength++;
            keys = splits[0].split(".");




            String mapcount ="mapcount";
            for (int j = 0; j < keys.length; j++) {

                keysLength=keys.length-1;
                if (keysLength ==0){

                }
            }





            strMap1.put(splits[0].split(".")[0],splits[1]);
        }


        System.out.println("aabc".indexOf("a"));
    }


}
