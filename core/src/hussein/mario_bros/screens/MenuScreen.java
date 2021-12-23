package hussein.mario_bros.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hussein.mario_bros.Launcher;

import java.util.Timer;
import java.util.TimerTask;

public class MenuScreen implements Screen {

    private Launcher launcher;
    private Texture texture;
    private SpriteBatch spriteBatch;
    private Sound intro_sound;
    private long startTime;
    public MenuScreen(final Launcher launcher)
    {
        this.launcher = launcher;
        this.spriteBatch = launcher.getBatch();
    }

    @Override
    public void show()
    {
        texture = new Texture(Gdx.files.internal("menuscreen_background.jpg"));
        intro_sound = Gdx.audio.newSound(Gdx.files.internal("super-mario-bros-theme-song.mp3"));
        intro_sound.play();
        startTime = System.currentTimeMillis()/1000;
    }

    @Override
    public void render(float delta) {

        spriteBatch.draw(texture, 0, 0);
        if(System.currentTimeMillis()/1000-startTime > 6)
        {
            launcher.setActiveScreen(launcher.getPlayScreen());
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

    }
}
