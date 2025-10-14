class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
       int N = flowerbed.length;
       if(n == 1 && N == 1 && flowerbed[0] == 0){
        return true;
       }
       for(int i = 0; i<N; i++){
            if(flowerbed[i] == 1){
                continue;
            }
            else{
                if(i > 0 && i+1 < N && (flowerbed[i-1] != 1) &&( flowerbed[i+1] != 1)){
                    n--;
                    flowerbed[i] = 1;
                }
                else if(i > 0 && i+1 == N &&  (flowerbed[i-1] != 1)){
                    n--;
                    flowerbed[i] = 1;
                }
                else if(i == 0 && i+1 < N && (flowerbed[i+1] != 1)){
                    n--;
                    flowerbed[i] = 1;
                }
               
            }
       }
    //    System.out.println(n);
       return n <= 0;
    }
}