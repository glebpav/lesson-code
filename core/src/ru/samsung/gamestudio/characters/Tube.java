package ru.samsung.gamestudio.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import ru.samsung.gamestudio.GameSettings;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.characters.Bird;

import java.util.Random;

public class Tube {

    int x;
    int gapY;
    int gapHeight = 400;
    int padding = 100;
    int distanceBetweenTubes;

    int width = 200;
    int height = 700;
    int speed = 10;

    Random random;

    Texture textureUpperTube;
    Texture textureDownTube;

    boolean isActive;

    public Tube(int tubeCount, int tubeIdx) {
        random = new Random();

        gapY = gapHeight / 2 + padding + random.nextInt(GameSettings.SCR_HEIGHT - 2 * (gapHeight / 2 + padding));
        distanceBetweenTubes = (GameSettings.SCR_WIDTH + width) / (tubeCount - 1);
        x = distanceBetweenTubes * tubeIdx + GameSettings.SCR_WIDTH;

        textureDownTube = new Texture("tubes/tube.png");
        textureUpperTube = new Texture("tubes/tube_flipped.png");

        isActive = true;
    }

    public void draw(Batch batch) {
        batch.draw(textureDownTube, x, gapY - gapHeight / 2 - height, width, height);
        batch.draw(textureUpperTube, x, gapY + gapHeight / 2, width, height);
    }

    public void move() {
        x -= speed;
        if (x < -width) {
            isActive = true;
            x = 1280 + distanceBetweenTubes;
            gapY = gapHeight / 2 + padding + random.nextInt(720 - 2 * (gapHeight / 2 + padding));
        }
    }

    public void dispose() {
        textureDownTube.dispose();
        textureUpperTube.dispose();
    }

    public boolean isHit(Bird bird) {
        if (bird.x + bird.width > x && bird.x < x && bird.y < gapY - gapHeight  / 2) {
            // System.out.println("touched down tube");
            return true;
        }
        if (bird.x + bird.width > x && bird.x < x && bird.y + bird.height > gapY + gapHeight / 2) {
            // System.out.println("touched upper tube");
            return true;
        }
        return false;
    }

    public boolean isPassed(Bird bird) {
        if (bird.x > x + width && isActive) {
            isActive = false;
            return true;
        }
        return false;
    }

}
