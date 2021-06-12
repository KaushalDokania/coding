class DiagonalTraverse {

    public static int getFirstElementsIndex(int[][] matrix, int count) {
        int i, j;
        if (count%2 == 0) {
            if (count < matrix.length) {
                i = count;
                j = 0;
            } else {
                i = matrix.length - 1;
                j = count - i;
            }
            
        }
        else {
            if (count < matrix[0].length) {
                j = count;
                i = 0;
            } else {
                j = matrix[0].length - 1;
                i = count - j;
            }
        }
        return i;
    }

    // Print the elements in one directino based on the first element matrix[i][j]
    public static int traverseElements(int[][] matrix, int count, int i, int j, int[] result, int k) {
        if (i>=0 && i<matrix.length && j>=0 && j<matrix[0].length) { // indexes should be in matrix range
            if (i==0 || j==matrix[0].length-1) {    // moving downwards
                while (i<matrix.length && j>=0) {
                    // System.out.print(matrix[i][j] + " ");
                    result[k++] = matrix[i][j];
                    i++;
                    j = count - i;
                }
            }
            else if (j==0 || i==matrix.length-1) {
                while (i>=0 && j<matrix[0].length) {    // moving upwards
                    // System.out.print(matrix[i][j] + " ");
                    result[k++] = matrix[i][j];
                    i--;
                    j = count - i;
                }
            }
        }
        return k;
    }
    public static int[] findDiagonalOrder(int[][] matrix) {
        int i=0, j=0, count=0, k=0;
        int[] result = new int[matrix.length * matrix[0].length];

        while (count < matrix.length + matrix[0].length - 1) {
            i = getFirstElementsIndex(matrix, count);
            j = count - i;
            k = traverseElements(matrix, count, i, j, result, k);
            count ++;
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.print("Diagonal Traversal: ");
        int[][] matrix = { 
                { 1,  2,  3 }, 
                { 4,  5,  6 },
                { 7,  8,  9 },
                { 10, 11, 12 }
                // { 1,  2,  3, 21 }, 
                // { 4,  5,  6, 22 },
                // { 7,  8,  9, 23 }
            };
        int res[] = findDiagonalOrder(matrix);
        for (Integer x: res) {
            System.out.print(x + " ");
        }
        System.out.println();
        
    }
}