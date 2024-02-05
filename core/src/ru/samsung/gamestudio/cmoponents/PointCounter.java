package ru.samsung.gamestudio.cmoponents;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PointCounter {

    int x;
    int y;
    BitmapFont bitmapFont;

    public PointCounter(int x, int y) {
        this.x = x;
        this.y = y;

        bitmapFont = new BitmapFont();
        bitmapFont.getData().scale(5f);
        bitmapFont.setColor(Color.WHITE);
    }

    public void draw(SpriteBatch spriteBatch, String text) {
        bitmapFont.draw(spriteBatch, text, x, y);
    }

    public void dispose() {
        bitmapFont.dispose();
    }

}
