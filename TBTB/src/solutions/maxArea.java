package solutions;

public class maxArea {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int lo = 0;
        int hi = height.length - 1;
        int area = 0;
        while (lo < hi){
        	area = Math.max(area, Math.min(height[lo], height[hi]) * (hi - lo));
        	if (height[lo] < height[hi]) lo ++;
        	else hi --;
        }
        return area;
    }
}
