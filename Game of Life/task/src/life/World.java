package life;

public class World {
    private final int[][] LIVING_CHECK_DIRECTIONS = {
            {0, -1},
            {1, -1},
            {1, 0},
            {1, 1},
            {0, 1},
            {-1, 1},
            {-1, 0},
            {-1, -1},
    };

    private final int worldSize;
    private boolean[][] grid;

    public World(boolean[][] initialGrid) {
        grid = initialGrid;
        worldSize = initialGrid.length;
    }

    public void printWorld() {
        for (boolean[] row : grid) {
            for (boolean state : row) {
                if (state) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public boolean isLiving(int x, int y) {
        x = Math.floorMod(x, worldSize);
        y = Math.floorMod(y, worldSize);
        return grid[y][x];
    }

    public void setState(int x, int y, boolean state) {
        x = Math.floorMod(x, worldSize);
        y = Math.floorMod(y, worldSize);
        grid[y][x] = state;
    }

    public void tick() {
        World nextTick = new World(new boolean[worldSize][worldSize]);

        for (int x = 0; x < worldSize; x++) {
            for (int y = 0; y < worldSize; y++) {
                if (isLiving(x, y)) {
                    switch (getLivingNeighbours(x, y)) {
                        case 2:
                        case 3:
                            nextTick.setState(x, y, true);
                            break;
                        default:
                            nextTick.setState(x, y, false);
                            break;
                    }
                } else {
                    if (getLivingNeighbours(x, y) == 3) {
                        nextTick.setState(x, y, true);
                    }
                }
            }
        }

        this.grid = nextTick.grid;
    }

    public int countLiving() {
        int livingCount = 0;
        for (int x = 0; x < worldSize; x++) {
            for (int y = 0; y < worldSize; y++) {
                if (isLiving(x, y)) {
                    livingCount++;
                }
            }
        }
        return livingCount;
    }

    private int getLivingNeighbours(int x, int y) {
        int livingCount = 0;

        for (int[] direction : LIVING_CHECK_DIRECTIONS) {
            if (isLiving(x + direction[0], y + direction[1])) {
                livingCount++;
            }
        }

        return livingCount;
    }
}
