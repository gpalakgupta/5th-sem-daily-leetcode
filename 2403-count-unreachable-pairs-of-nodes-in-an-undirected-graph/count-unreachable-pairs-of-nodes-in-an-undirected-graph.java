class Solution {
    public long countPairs(int n, int[][] edges) {
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

        int[] visited = new int[n];
        List<Integer> ll = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(visited[i] == 0){
                int size = dfs(map,i,visited);
                ll.add(size);
            }
        }

        long ans = 0;
        for(int i = 0; i<ll.size(); i++){
            ans += (long)(ll.get(i))*(n-ll.get(i));
        }
        return ans/2;
    }
    public int dfs(HashMap<Integer,List<Integer>> map, int node, int[] visited){
        visited[node] = 1;
        int count = 1;
        for(int nbrs : map.get(node)){
            if(visited[nbrs] != 1){
                count += dfs(map,nbrs,visited);
            }
        }
        return count;
    } 

    //   public long bfs(HashMap<Integer,List<Integer>> map){
    //     List<Integer> ans = new ArrayList<>();
    //     Queue<Integer> q = new LinkedList<>();
    //     HashSet<Integer> st = new HashSet<>();
    //     int c = 0;
    //     for(int src : map.keySet()){
    //         if(st.contains(src)){
    //             continue;
    //         }
    //         q.add(src);
    //         int size = 0;
    //         while(!q.isEmpty()){
    //             int el = q.poll();
    //             if(st.contains(el)){
    //                 continue;
    //             }
    //             st.add(el);
    //             size++;
    //             for(int nbrs : map.get(el)){
    //                 if(!st.contains(nbrs)){
    //                     q.add(nbrs);
    //                 }
    //             }
    //         }
            
    //             ans.add(size);
                
            
    //     }
    //     if(ans.size() == 1){
    //         return 0;
    //     }
    //     long res = 0;
    //     for(int i = 0; i<ans.size(); i++){
    //         res += ((long)ans.get(i))*(st.size()-ans.get(i));
    //     }
    //     return res/2;

    // }
}