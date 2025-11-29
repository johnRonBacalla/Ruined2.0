package core;

public enum Direction {
    RIGHT(0),
    LEFT(1);

    private int animationRow;
    private static int prevDirection;

    Direction(int animationRow) {
        this.animationRow = animationRow;
    }

    public static Direction fromMotion(Motion motion) {
        double x = motion.getVector().getX();
        double y = motion.getVector().getY();
        // 0 left
        // 1 right


        if (x == 0 && y > 0) {
            if (prevDirection == 0) {
                return RIGHT;
            } else {
                return LEFT;
            }
        }
        if (x < 0 && y == 0) {
            prevDirection = 1;
            return LEFT; //W
        }
        if (x == 0 && y < 0) {
            if (prevDirection == 0) {
                return RIGHT;
            } else {
                return LEFT;
            }
        }
        if (x > 0 && y == 0) {
            prevDirection = 0;
            return RIGHT; //E
        }
        if (x < 0 && y > 0) {
            prevDirection = 1;
            return LEFT; //SW
        }
        if (x < 0 && y < 0) {
            prevDirection = 1;
            return LEFT; //NW
        }
        if (x > 0 && y < 0) {
            prevDirection = 0;
            return RIGHT; //NE
        }
        if (x > 0 && y > 0) {
            prevDirection = 0;
            return RIGHT; //SE
        }

        return RIGHT;
    }

    public int getAnimationRow() {
        return animationRow;
    }
}
