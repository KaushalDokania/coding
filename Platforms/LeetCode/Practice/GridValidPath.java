import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/

public class GridValidPath {

    static class Direction {
        public static final String LEFT     = "left";
        public static final String RIGHT    = "right";
        public static final String UP       = "up";
        public static final String DOWN     = "down";
    }

    static class Street {
        List<String> inOutDirections;

        public Street(String in, String out) {
            this.inOutDirections = new ArrayList<>();
            this.inOutDirections.add(in);
            this.inOutDirections.add(out);
        }
    }

    static class Solution {
        Street streets[] = new Street[7];
        
        public void initializeStreets() {
            streets[1] = new Street(Direction.LEFT, Direction.RIGHT);
            streets[2] = new Street(Direction.UP, Direction.DOWN);
            streets[3] = new Street(Direction.LEFT, Direction.DOWN);
            streets[4] = new Street(Direction.RIGHT, Direction.DOWN);
            streets[5] = new Street(Direction.LEFT, Direction.UP);
            streets[6] = new Street(Direction.UP, Direction.RIGHT);
        }

        public String getNextDirection(String currDir, Street st) {
            String dir = "";
            dir = st.inOutDirections.get(0);
            if (dir.equals(getOppositeDirection(currDir)))
                dir = st.inOutDirections.get(1);
            return dir;
        }

        public String getOppositeDirection(String dir) {
            String opp = "";
            switch (dir) {
                case Direction.LEFT: opp = Direction.RIGHT;break;
                case Direction.RIGHT: opp = Direction.LEFT;break;
                case Direction.UP: opp = Direction.DOWN;break;
                case Direction.DOWN: opp = Direction.UP;break;
            }
            return opp;
        }

        public boolean hasValidPath(int[][] grid) {
            initializeStreets();
            int i=0, j=0, stNum=0;
            String currDirection = "", nextDirection = "";
            // if (grid[0][0] == 4 || grid[0][0] == 5)
            //     return false;
            while (i < grid.length && j < grid[0].length) {           // unless we are at last node
                stNum = grid[i][j];
                
                if (i==0 && j==0) {
                    if (streets[stNum].inOutDirections.contains(Direction.LEFT))
                        currDirection = Direction.RIGHT;
                    else
                        currDirection = Direction.DOWN;
                }
                
                // current direction is known, check if current street is valid based on current direction
                if (!streets[stNum].inOutDirections
                        .contains(getOppositeDirection(currDirection)))
                    return false;               // stuck in current street
                
                if (i==grid.length-1 && j==grid[0].length-1)
                    break;
                currDirection = getNextDirection(currDirection, streets[stNum]);

                // Move to next cell
                switch (currDirection) {
                    case Direction.LEFT : j--;break;
                    case Direction.RIGHT: j++;break;
                    case Direction.UP   : i--;break;
                    case Direction.DOWN : i++;break;
                }
            }
            if (i==grid.length-1 && j==grid[0].length-1)            // we are at last cell
                return true;
            return false;
        }
    }

    public static void main(String[] args) {
        // int grid[][] = {{2,4,3},{6,5,2}};
        // int grid[][] = {{1,1,2}};
        int grid[][] = {{4,1},{6,1}};
        System.out.println("Answer : " + new Solution().hasValidPath(grid));
    }
}
