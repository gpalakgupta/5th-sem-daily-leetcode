class Solution {
    public class Pair{
        int first;
        int second;
        public Pair(int first,  int second){
            this.first = first;
            this.second = second;
        }
    }
    public double gain(Pair rv){
        return (rv.first+1.0)/(rv.second+1) - (rv.first*1.0)/(rv.second);
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Double.compare(gain(b),gain(a)));
        for(int i = 0; i<classes.length; i++){
            int a = classes[i][0];
            int b = classes[i][1];
            pq.add(new Pair(a,b));
        }
        for(int i = 0; i<extraStudents; i++){
            Pair rv = pq.poll();
            pq.add(new Pair(rv.first+1,rv.second+1));
        }

        double ans = 0;
        while(!pq.isEmpty()){
            Pair rv = pq.poll();
            ans+=(rv.first*1.0/rv.second);
        }
        return ans/classes.length;

    }
}