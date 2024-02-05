package ru.samsung.gamestudio.characters;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bird {

    int x;
    public int y;

    int lastY;
    int jumpHeight = 100;
    boolean isJumping = true;

    int width;
    int height;

    int speed;

    Texture[] textures;
    int textureCounter = 0;

    public Bird(int x, int y, int width, int height, int speed) {
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        textures = new Texture[]{
                new Texture("bird/bird0.png"),
                new Texture("bird/bird1.png"),
                new Texture("bird/bird2.png"),
                new Texture("bird/bird1.png")
        };

    }

    public void move() {

        if (y - lastY > jumpHeight) isJumping = false;

        if (isJumping) y += speed;
        else y -= speed;
    }

    public void clicked() {
        lastY = y;
        isJumping = true;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(textures[(textureCounter / 10) % textures.length], x, y, width, height);
        textureCounter += 1;
    }

    public void dispose() {
        for (Texture texture : textures) {
            texture.dispose();
        }
    }

}
