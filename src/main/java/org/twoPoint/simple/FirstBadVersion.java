package org.twoPoint.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/2/5 下午10:48
 */
/*双指针解法*/
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l=0,r=n;
        while (l <= r) {
            int middle=l+(r-l)/2;
            if (isBadVersion(middle)) {
                r=middle-1;
            }else {
                l=middle+1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int i) {

        return false;
    }
}
