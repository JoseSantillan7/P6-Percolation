public class PercolationDFSFast extends PercolationDFS{
    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationDFSFast(int n) {
        super(n);
    }
    @Override
    protected void updateOnOpen(int row, int column){
        if (!inBounds(row, column)) return;
        if (row == 0) {
            dfs(row, column);
        } else if (inBounds(row + 1, column) && isFull(row + 1, column)) {
            dfs(row, column);
        } else if (inBounds(row - 1, column) && isFull(row - 1, column)) {
            dfs(row, column);
        }else if (inBounds(row, column + 1) && isFull(row, column + 1)){
            dfs(row, column);
        } else if ( inBounds(row, column - 1) && isFull(row, column - 1)) {
            dfs(row, column);
        }
    }
}