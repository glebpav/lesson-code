package ru.samsung.gamestudio.cmoponents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.samsung.gamestudio.GameSettings;
import ru.samsung.gamestudio.MyGdxGame;

public class MovingBackground {

    Texture texture;
    Texture texture2;

    int speed = -2;
    int x;
    int x2;

    public MovingBackground(String pathToTexture) {
        x = 0;
        x2 = GameSettings.SCR_WIDTH;
        texture = new Texture(pathToTexture);
        texture2 = new Texture(pathToTexture);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, 0, GameSettings.SCR_WIDTH,GameSettings.SCR_HEIGHT);
        batch.draw(texture2, x2, 0, GameSettings.SCR_WIDTH,GameSettings.SCR_HEIGHT);
    }

    public void dispose() {
        texture.dispose();
    }

    public void move() {
        x += speed;
        x2 += speed;
        if (x <= -GameSettings.SCR_WIDTH) x = GameSettings.SCR_WIDTH;
        if (x2 <= -GameSettings.SCR_WIDTH) x2 = GameSettings.SCR_WIDTH;
    }

}
