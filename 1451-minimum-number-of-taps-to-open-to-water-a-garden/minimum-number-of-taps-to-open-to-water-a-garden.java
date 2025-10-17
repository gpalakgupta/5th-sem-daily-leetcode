class Solution {
    int N;
    public class  Pair{
        int st;
        int end;
        public Pair(int st, int end){
            this.st = st;
            this.end = end;
        }
    }
    HashMap<String, Integer> map = new HashMap<>();
    public int minTaps(int n, int[] ranges) {
        N = n;
        Pair[] arr = new Pair[n+1];
        for(int i = 0; i<=n; i++){
            int st = Math.max(i-ranges[i],0);
            int end = Math.min(i+ranges[i],n);
            arr[i] = new Pair(st,end);
        }
        
        // Arrays.sort(arr,(a,b)-> Integer.compare(a.st,b.st));
        Arrays.sort(arr,new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return o1.st - o2.st;
            }
        });

        int ans = helper(0,0,arr);
        return ans == (int)(1e9) ? -1 : ans;
    }

    public int helper(int i, int mx , Pair[] arr){
        if(i >= arr.length){
            if(mx >= N){
                return 0;
            }
            return (int)(1e9);
        };

        if(arr[i].st > mx){
            return (int)(1e9);
        }
        String key  = i+"-"+mx;
        if(map.containsKey(key)){
           return map.get(key); 
        }
        int no_open = helper(i+1,mx,arr);
        int open = 1+helper(i+1,Math.max(mx,arr[i].end),arr);
        map.put(key,Math.min(open,no_open));
        return Math.min(open,no_open);
    }
}

// class Solution {
//     public int minTaps(int n, int[] ranges) {
//         int[] arr = new int[n+1];
//         for(int i = 0; i<=n; i++){
//             int st = Math.max(i-ranges[i],0);
//             int end = Math.min(i+ranges[i],n);
//             arr[st] = Math.max(arr[st],end);
//         }

//         int curr = 0;
//         int mx = 0;
//         int taps = 0;
//         for(int i = 0; i<=n; i++){
//             if(i > mx){
//                 return -1;
//             }
//             if(i > curr){
//                 taps++;
//                 curr = mx;
//             }
//             mx = Math.max(mx,arr[i]);
//         }
//         return taps;
//     }
// }



