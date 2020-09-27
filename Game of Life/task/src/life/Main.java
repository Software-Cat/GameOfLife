package life;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        World world = WorldGen.genWorld(SCANNER.nextInt());

        int ticks = 10;
        for (int i = 0; i < ticks; i++) {
            clearScreen();

            System.out.println("Generation #" + (i + 1));
            System.out.println("Alive: " + world.countLiving());
            world.printWorld();

            world.tick();
            Thread.sleep(1000);
        }
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {

        }
    }
}
