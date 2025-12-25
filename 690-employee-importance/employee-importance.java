/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer,Employee> mp = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e : employees){
            mp.put(e.id,e);
        }
        return dfs(id);
    }
    public int dfs(int id){
        Employee node = mp.get(id);
        int ans = node.importance;
        for(int nbrs : node.subordinates){
            ans += dfs(nbrs);
        }
        return ans;
    }
}