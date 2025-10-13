class Solution {
    public class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    int[] r = { 0, -1, 0, 1 };
    int[] c = { -1, 0, 1, 0 };

    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(entrance[0], entrance[1]));
        boolean[][] visited = new boolean[n][m];
        maze[entrance[0]][entrance[1]] = '+';
        visited[entrance[0]][entrance[1]] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int n1 = q.size();
            for (int i = 0; i < n1; i++) {
                Pair rv = q.poll();
                int row = rv.first;
                int col = rv.second;
                if ((row == 0 || col == 0 || row == n - 1 || col == m - 1) &&
                        !(row == entrance[0] && col == entrance[1])) {
                    return steps;
                }

                for (int k = 0; k < 4; k++) {
                    int cr = row + r[k];
                    int cc = col + c[k];
                    if (cr >= 0 && cc >= 0 && cr < n && cc < m && maze[cr][cc] == '.' && visited[cr][cc] == false) {
                        q.add(new Pair(cr, cc));
                        visited[cr][cc] = true;
                    }
                }
            }
            steps++;

        }
        return -1;
    }
}