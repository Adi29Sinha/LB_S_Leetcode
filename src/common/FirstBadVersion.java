package common;

public class FirstBadVersion {
    static boolean arr[] = {false, false, false, false, true, true, true};

    public int firstBadVersion(int n) {
        if(n==1)
            return 1;
        int low = 1;
        int high = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isBadVersion(mid)){
                // move towards good version
                high = mid-1;
            }else{
                // if good version
                // move towards more recent good version
                low = mid+1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int mid) {
        return arr[mid];
    }

    public static void main(String[] args) {
        FirstBadVersion badVersion = new FirstBadVersion();
        System.out.println(badVersion.firstBadVersion(arr.length));
    }
}
