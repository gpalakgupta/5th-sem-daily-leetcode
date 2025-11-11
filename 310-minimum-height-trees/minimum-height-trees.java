class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(0);
            return ans;
        }
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] arr : edges){
            int a = arr[0];
            int b = arr[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int[] indeg = new int[n];
        for(int i = 0; i<n; i++){
            indeg[i] = map.get(i).size();
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(indeg[i] == 1){
                q.add(i);
            }
        }
        while(n > 2){
            int size = q.size();
            n-=size;
            for(int i = 0; i<size; i++){
                int el = q.poll();
                for(int nbrs : map.get(el)){
                    indeg[nbrs]--;
                    if(indeg[nbrs] == 1){
                        q.add(nbrs);
                    }
                }
            }
        }
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;
    }
}