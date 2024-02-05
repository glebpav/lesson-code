package ru.samsung.gamestudio.cmoponents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.samsung.gamestudio.MyGdxGame;

public class MovingBackground {

    Texture texture;
    Texture texture2;

    int speed = -2;
    int x;
    int x2;

    public MovingBackground(String pathToTexture) {
        x = 0;
        x2 = MyGdxGame.SCR_WIDTH;
        texture = new Texture(pathToTexture);
        texture2 = new Texture(pathToTexture);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, 0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
        batch.draw(texture2, x2, 0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
    }

    public void dispose() {
        texture.dispose();
    }

    public void move() {
        x += speed;
        x2 += speed;
        if (x <= -MyGdxGame.SCR_WIDTH) x = MyGdxGame.SCR_WIDTH;
        if (x2 <= -MyGdxGame.SCR_WIDTH) x2 = MyGdxGame.SCR_WIDTH;
    }

}
