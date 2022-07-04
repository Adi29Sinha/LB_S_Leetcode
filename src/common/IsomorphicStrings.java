package common;

import java.util.HashMap;

public class IsomorphicStrings {
    /*
    Input: s = "egg", t = "add"
    Output: true

    Input: s = "foo", t = "bar"
    Output: false
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<String,String> map = new HashMap<>();
        HashMap<String,String> tmap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(String.valueOf(s.charAt(i)),String.valueOf(t.charAt(i)));
        }
        for(int i=0;i<t.length();i++){
            tmap.put(String.valueOf(t.charAt(i)),String.valueOf(s.charAt(i)));
        }
        String str="";
        for(int i=0;i<s.length();i++){
            String character = String.valueOf(s.charAt(i));
            str+=map.get(character);
        }
        if(map.size()==tmap.size() && t.equals(str)){
            return true;
        }
        return false;
    }
}
