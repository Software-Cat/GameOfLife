package life;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        World world = WorldGen.genWorld(scanner.nextInt(), scanner.nextLong());

        int ticks = scanner.nextInt();
        for (int i = 0; i < ticks; i++) {
            world.tick();
        }

        world.printWorld();
    }
}
