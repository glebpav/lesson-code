package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.*;
import ru.samsung.gamestudio.cmoponents.PointCounter;
import ru.samsung.gamestudio.characters.Bird;
import ru.samsung.gamestudio.characters.Tube;
import ru.samsung.gamestudio.cmoponents.MovingBackground;

public class ScreenGame implements Screen {

    MyGdxGame myGdxGame;
    Bird bird;

    PointCounter pointCounter;
    MovingBackground movingBackground;
    int tubeCount = 3;
    Tube[] tubes;

    boolean isGameOver;
    int score;

    public ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        bird = new Bird(300, myGdxGame.SCR_HEIGHT / 2, 100, 100, 5);
        pointCounter = new PointCounter(700, 600);
        movingBackground = new MovingBackground("backgrounds/game_bg.png");
        // initTubes();
        resetGame();
    }


    @Override
    public void show() {
        isGameOver = false;
    }

    @Override
    public void render(float delta) {

        if (Gdx.input.justTouched()) {
            bird.clicked();
        }

        bird.move();
        movingBackground.move();

        for(Tube tube : tubes) {
            tube.move();
            if (tube.isHit(bird)) {
                System.out.println("loose");
                isGameOver = true;
                // resetGame();
                myGdxGame.screenRestart.score = score;
                myGdxGame.setScreen(myGdxGame.screenRestart);

            }
            if (tube.isPassed(bird)) {
                score += 1; // score++;
            }
        }

        ScreenUtils.clear(0, 0, 0.5f, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        movingBackground.draw(myGdxGame.batch);
        bird.draw(myGdxGame.batch);
        for(Tube tube : tubes) tube.draw(myGdxGame.batch);
        pointCounter.draw(myGdxGame.batch, "Score: " + score);

        myGdxGame.batch.end();
    }

    void resetGame() {
        initTubes();
        bird.y = MyGdxGame.SCR_HEIGHT / 2;
        isGameOver = false;
        score = 0;
    }

    void initTubes() {
        tubes = new Tube[tubeCount];
        for (int i = 0; i < tubeCount; i++) {
            tubes[i] = new Tube(tubeCount, i);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bird.dispose();
        for(Tube tube : tubes) tube.dispose();
    }
}
