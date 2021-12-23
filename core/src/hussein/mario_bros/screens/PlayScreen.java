package hussein.mario_bros.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import hussein.mario_bros.Launcher;
import hussein.mario_bros.model.Level;

public class PlayScreen implements Screen {

    private Launcher launcher;
    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;
    private Box2DDebugRenderer box2D;
    private World world;
    private Level level;
    private char map[][];
    public PlayScreen(Launcher launcher)
    {
        this.launcher = launcher;
        this.spriteBatch = launcher.getBatch();
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.box2D = new Box2DDebugRenderer();
        this.world = new World(new Vector2(0, -1), true);
        this.level = new Level("maps/map1.txt");
        this.map = level.getMap();
        for(int y = 0; y < map.length; y++ )
        {
            for(int x = 0; x < map[y].length; x++)
            {
                if(map[y][x] == 'b')
                {
                    System.out.println("y : "+y+" x : "+x);
                    BodyDef bodyDef = new BodyDef();
                    bodyDef.type = BodyDef.BodyType.StaticBody;
                    bodyDef.position.set((x*20-Gdx.graphics.getWidth()/2f), (y*20-Gdx.graphics.getHeight()/2f));
                    Body body = world.createBody(bodyDef);
                    PolygonShape shape = new PolygonShape();
                    shape.setAsBox(10, 10);
                    FixtureDef fixtureDef = new FixtureDef();
                    fixtureDef.shape = shape;
                    fixtureDef.density = 1f;
                    Fixture fixture = body.createFixture(fixtureDef);
                }
            }
        }
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0,0);
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(50, 50);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        Fixture fixture = body.createFixture(fixtureDef);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        world.step(1/(60f), 6, 2);
        box2D.render(world, camera.combined);
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
