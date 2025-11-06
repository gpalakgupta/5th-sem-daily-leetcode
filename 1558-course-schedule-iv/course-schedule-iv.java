class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i<numCourses; i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] arr : prerequisites){
            int a = arr[0];
            int b = arr[1];
            map.get(a).add(b);
        }

        List<Boolean> ans = new ArrayList<>();
        for(int[] arr : queries){
            int a = arr[0];
            int b = arr[1];
            boolean res = bfs(a,b,map);
            ans.add(res);
        }
        return ans;
    }
    public boolean bfs(int src, int des, HashMap<Integer,List<Integer>> map){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> st = new HashSet<>();
        q.add(src);
        while(!q.isEmpty()){
            int el = q.poll();
            if(st.contains(el)){
                continue;
            }
            if(el == des){
                return true;
            }
            st.add(el);
            for(int nbrs : map.get(el)){
                if(!st.contains(nbrs)){
                    q.add(nbrs);
                }
            }
        }
        return false;
    }
}