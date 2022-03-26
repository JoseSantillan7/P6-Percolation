public class PercolationUF implements IPercolate{

    private IUnionFind myFinder;
    private boolean[][] myGrid;
    private int VTOP;
    private int VBOTTOM;
    private int myOpenCount;
    private int len;

    public PercolationUF(IUnionFind finder, int size){
        myGrid = new boolean[size][size];
        finder.initialize(size * size + 2);
        myFinder = finder;
        VTOP = size * size;
        VBOTTOM = size * size + 1;
        myOpenCount = 0;
        len = size;
    }
    @Override
    public void open(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        if (isOpen(row, col)){
            return;
        }
        myGrid[row][col] = true;
        myOpenCount++;
        if (row == 0){
            myFinder.union(num(row, col), VTOP);
        }
        if (row == myGrid[0].length - 1){
            myFinder.union(num(row, col), VBOTTOM);
        }
        if (inBounds(row, col + 1) && isOpen(row, col + 1)){
            myFinder.union(num(row, col), num(row, col + 1));
        }
        if (inBounds(row, col - 1) && isOpen(row, col - 1)){
            myFinder.union(num(row, col), num(row, col - 1));
            }
        if (inBounds(row + 1, col) && isOpen(row + 1, col)){
            myFinder.union(num(row, col), num(row + 1, col));
        }
        if (inBounds(row -1, col) && isOpen(row - 1, col)){
            myFinder.union(num(row, col), num(row - 1, col));
        }
        }
    @Override
    public boolean isOpen(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        if (myGrid[row][col] == true){
            return true;
        }
        return false;
    }
    @Override
    public boolean isFull(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        if (myFinder.connected(VTOP, num(row, col))){
            return true;
        }
        return false;
    }
    @Override
    public boolean percolates() {
        if (myFinder.connected(VTOP, VBOTTOM)){
            return true;
        }
        return false;
    }
    @Override
    public int numberOfOpenSites() {
        return myOpenCount;
    }
    private boolean inBounds(int row, int col){
        if (row < 0 || row >= myGrid.length){
            return false;
        }
        if (col < 0 || col >= myGrid[0].length){
            return false;
        }
        return true;
    }
    private int num(int row, int col){
        return row * myGrid.length + col;
    }
}
