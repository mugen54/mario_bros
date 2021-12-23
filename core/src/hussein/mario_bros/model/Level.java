package hussein.mario_bros.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Level {

    private char map[][];

    public char[][] getMap() {
        return map;
    }

    public Level(String filename)
    {
        FileHandle handle = Gdx.files.local(filename);
        String text = handle.readString();
        String lines[] = text.split("\\n");
        map = new char[lines.length][lines[0].length()];
        for(int y = 0; y < lines.length; y++)
        {
            for(int x = 0; x < lines[y].length(); x++)
            {
                map[lines.length-y-1][x] = lines[y].charAt(x);
            }
        }
    }
}
