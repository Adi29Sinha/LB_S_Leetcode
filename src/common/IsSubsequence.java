package common;

public class IsSubsequence {
    /*
    Input: s = "abc", t = "ahbgdc"
    Output: true

    Input: s = "axc", t = "ahbgdc"
    Output: false
     */
    public boolean isSubsequence(String s, String t) {
        int i = s.length() , j = t.length();
        i--;
        j--;
        while(i >= 0 && j >= 0)
        {
            if(s.charAt(i) == t.charAt(j))
            {
                i--;
                j--;
            }
            else
                j--;
        }
        if(i >= 0)
            return false;
        return true;
    }
}
