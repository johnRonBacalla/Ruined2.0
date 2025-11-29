package game;

public class GameLoop implements Runnable{

    public static final int UPDATES_PER_SECOND = 60;

    private Game game;

    private boolean running;
    private final double updateRate = 1.0/ UPDATES_PER_SECOND;

    private long nextStartTime;
    private int fps, ups;

    public GameLoop(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long now, then = System.currentTimeMillis();
        nextStartTime = System.currentTimeMillis() + 1000;


        while(running) {
            now = System.currentTimeMillis();
            double lastRenderTime = (now - then) / 1000d;
            accumulator += lastRenderTime;
            then = now;

            if(accumulator >= updateRate) {
                while(accumulator >= updateRate) {
                    update();
                    accumulator -= updateRate;
                }
            }
            render();
            printStats();
        }
    }

    private void printStats() {
        if(System.currentTimeMillis() > nextStartTime) {
            System.out.println(String.format("FPS: %d, UPS: %d", fps, ups));
            fps = 0;
            ups = 0;
            nextStartTime = System.currentTimeMillis() + 1000;
        }
    }

    private void update() {
        game.update();
        ups++;
    }

    private void render() {
        game.render();
        fps++;
    }

}
