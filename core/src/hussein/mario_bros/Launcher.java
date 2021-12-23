package hussein.mario_bros;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import hussein.mario_bros.screens.MenuScreen;
import hussein.mario_bros.screens.PlayScreen;

public class Launcher extends Game {
	private SpriteBatch batch;
	private MenuScreen menuScreen;
	private PlayScreen playScreen;
	private Screen activeScreen;

	public PlayScreen getPlayScreen() {
		return playScreen;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		menuScreen = new MenuScreen(this);
		playScreen = new PlayScreen(this);
		activeScreen = menuScreen;
		setScreen(menuScreen);
	}

	public void setActiveScreen(Screen activeScreen)
	{
		this.activeScreen = activeScreen;
		setScreen(activeScreen);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		activeScreen.render(Gdx.graphics.getDeltaTime());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}


	public SpriteBatch getBatch() {
		return batch;
	}
}
