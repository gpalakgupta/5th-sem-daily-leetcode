class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people,(a,b)->{
            if(a[0] == b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(b[0],a[0]);
        });

       List<int[]> ll = new ArrayList<>();
       for(int[] a : people){
        ll.add(a[1],a);
       }
       return ll.toArray(new int[n][2]);
    }
}