package ru.samsung.gamestudio.cmoponents;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextButton {

    Texture texture;
    BitmapFont bitmapFont;

    String text;

    int x;
    int y;

    int textX;
    int textY;

    public TextButton(int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;

        texture = new Texture("button_bg.png");

        bitmapFont = new BitmapFont();
        bitmapFont.getData().scale(5f);
        bitmapFont.setColor(Color.WHITE);

        GlyphLayout glyphLayout = new GlyphLayout(bitmapFont, text);
        float textWidth = glyphLayout.width;
        float textHeight = glyphLayout.height;

        textX = (int) (x + (texture.getWidth() - textWidth) / 2);
        textY = (int) (y + (texture.getHeight() + textHeight) / 2);
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y);
        bitmapFont.draw(spriteBatch, text, textX, textY);
    }

    public void dispose() {
        texture.dispose();
        bitmapFont.dispose();
    }

}
