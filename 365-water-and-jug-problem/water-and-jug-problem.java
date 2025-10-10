class Solution {
    public int gcd(int n1, int n2){
        return n2 == 0 ? n1 : gcd(n2, n1%n2);
    }
    public boolean canMeasureWater(int x, int y, int target) {
        if(target == 0){
            return true;
        }
        if(x + y < target){
            return false;
        }

        int gcd = gcd(x,y);
        return target % gcd == 0;
    }
}