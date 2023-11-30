import java.util.*;
public class Day14 {
    boolean areRotations(String s1,String s2)
    {  
         if (s1.length() == s2.length() && s1.length() > 0) {
        // Concatenate s1 with itself
        String concat = s1 + s1;
       
        return concat.contains(s2);
    }
    return false;
      
    }


}
