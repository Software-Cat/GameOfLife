package life;

import java.util.Random;

public class WorldGen {
    private WorldGen() { }

    public static World genWorld(int worldSize) {
        boolean[][] initialGrid = new boolean[worldSize][worldSize];

        Random rng = new Random();

        for (int i = 0; i < initialGrid.length; i++) {
            for (int j = 0; j < initialGrid[i].length; j++) {
                initialGrid[i][j] = rng.nextBoolean();
            }
        }

        return new World(initialGrid);
    }
}
