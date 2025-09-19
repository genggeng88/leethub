class Spreadsheet {
    private int[][] cells;

    public Spreadsheet(int rows) {
        cells = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        Node node = decodeCell(cell);
        cells[node.row-1][node.col] = value;
    }

    public void resetCell(String cell) {
        Node node = decodeCell(cell);
        cells[node.row-1][node.col] = 0;
    }

    public int getValue(String formula) {
        String[] params = formula.substring(1).split("\\+");
        int num1, num2;
        if (isRef(params[0])) {
            Node node = decodeCell(params[0]);
            num1 = cells[node.row-1][node.col];
        } else {
            num1 = Integer.parseInt(params[0]);
        }
        if (isRef(params[1])) {
            Node node = decodeCell(params[1]);
            num2 = cells[node.row-1][node.col];
        } else {
            num2 = Integer.parseInt(params[1]);
        }
        return num1 + num2;
    }

    static class Node {
        int col;
        int row;
        public Node(int c, int r) {
            col = c;
            row = r;
        }
    }

    private Node decodeCell(String cell) {
        String num = cell.substring(1);
        return new Node(cell.charAt(0)-'A', Integer.parseInt(num));
    }

    private boolean isRef(String cell) {
        if (cell.charAt(0) <= 'Z' && cell.charAt(0) >= 'A') return true;
        return false;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */