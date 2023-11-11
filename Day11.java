
import java.util.HashMap;
public class Day11 {
    public static boolean areIsomorphic(String str1,String str2)
    {
        // Your code here
            if(str1.length() != str2.length())
            return false;
        
        HashMap<Character, Character> m = new HashMap<>();
        
        for(int i=0;i<str1.length();i++){
            if(m.containsKey(str1.charAt(i))){
                if(m.get(str1.charAt(i)) != str2.charAt(i)){
                    return false;
                }
            }else{
                if(m.containsValue(str2.charAt(i))){
                    return false;
                }
                m.put(str1.charAt(i), str2.charAt(i));
            }
        }
        return true;
    }
}
