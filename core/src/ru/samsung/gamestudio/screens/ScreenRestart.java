package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.cmoponents.MovingBackground;
import ru.samsung.gamestudio.cmoponents.PointCounter;
import ru.samsung.gamestudio.cmoponents.TextButton;

public class ScreenRestart implements Screen {

    MyGdxGame myGdxGame;
    MovingBackground background;
    PointCounter pointCounter;
    TextButton buttonRestart;
    TextButton buttonReturn;

    int score;

    public ScreenRestart(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        pointCounter = new PointCounter(650, 600);
        buttonRestart = new TextButton(150, 450, "restart");
        buttonReturn = new TextButton(150, 200, "return");
        background = new MovingBackground("backgrounds/restart_bg.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if (Gdx.input.justTouched()) {
            Vector3 projectVector = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (buttonRestart.isHit(projectVector.x, projectVector.y)) {
                myGdxGame.setScreen(myGdxGame.screenGame);
            }
            if (buttonReturn.isHit(projectVector.x, projectVector.y)) {
                // myGdxGame.setScreen(myGdxGame.screenGame);
                // 1 - play
                // 2 - exit
                Gdx.app.exit();
            }
        }

        ScreenUtils.clear(0, 0, 0.5f, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        background.draw(myGdxGame.batch);
        pointCounter.draw(myGdxGame.batch, "Score: " + score);
        buttonRestart.draw(myGdxGame.batch);
        buttonReturn.draw(myGdxGame.batch);

        myGdxGame.batch.end();

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
        background.dispose();
        pointCounter.dispose();
        buttonRestart.dispose();
    }
}
