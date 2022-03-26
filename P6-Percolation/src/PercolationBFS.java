import java.util.*;

public class PercolationBFS extends PercolationDFSFast{
    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationBFS(int n) {
        super(n);
    }
    @Override
    protected void dfs(int row, int col){
        Queue<int[]> q = new LinkedList<>();
        myGrid[row][col] = FULL;
        q.add(new int[]{row, col});
        while (q.size() != 0){
            int[] p = q.remove();
            int[] r = {p[0] + 1, p[1]};
            int[] s = {p[0] - 1, p[1]};
            int[] t = {p[0], p[1] + 1};
            int[] u = {p[0], p[1] - 1};
            if (inBounds(r[0], r[1]) && isOpen(r[0], r[1]) && !isFull(r[0], r[1])){
                myGrid[r[0]][r[1]] = FULL;
                q.add(r);
            }
            if (inBounds(s[0], s[1]) && isOpen(s[0], s[1]) && !isFull(s[0], s[1])){
                myGrid[s[0]][s[1]] = FULL;
                q.add(s);
            }
            if (inBounds(t[0], t[1]) && isOpen(t[0], t[1]) && !isFull(t[0], t[1])){
                myGrid[t[0]][t[1]] = FULL;
                q.add(t);
            }
            if (inBounds(u[0], u[1]) && isOpen(u[0], u[1]) && !isFull(u[0], u[1])){
                myGrid[u[0]][u[1]] = FULL;
                q.add(u);
            }
        }
    }
}
