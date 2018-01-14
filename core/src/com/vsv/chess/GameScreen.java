package com.vsv.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vova on 07.01.2018.
 */
public class GameScreen implements Screen {

    SpriteBatch batch;
    OrthographicCamera camera;
    Texture texture;
    Map<String, Tile> tileList;
    Integer counterX = 0;
    Integer counterY = 0;
    long time;
    boolean bool = false;

    public GameScreen() {
        camera = new OrthographicCamera();
        batch = new SpriteBatch();

        tileList = new HashMap();
        createTiles();

    }

    void createTiles() {
        for (int vert = 0; vert < 8; vert++) {
            for (int hor = 0; hor < 8; hor++) {
                if (vert % 2 == 0 && hor % 2 == 0) {
                    String s = Integer.toString(hor) + Integer.toString(vert);
                    tileList.put(s, new Tile(hor, vert, Color.DARK_GRAY));
                } else if (vert % 2 != 0 && hor % 2 != 0) {
                    String s = Integer.toString(hor) + Integer.toString(vert);
                    tileList.put(s, new Tile(hor, vert, Color.DARK_GRAY));
                } else {
                    String s = Integer.toString(hor) + Integer.toString(vert);
                    tileList.put(s, new Tile(hor, vert, Color.BROWN));
                }

            }
        }
    }

    public void drawTiles() {
        for (int vert = 0; vert < 8; vert++) {
            for (int hor = 0; hor < 8; hor++) {
                if (vert % 2 == 0 && hor % 2 == 0) {
                    String s = Integer.toString(hor) + Integer.toString(vert);
                    texture = new Texture(tileList.get(s));
                    batch.draw(texture, tileList.get(s).getX(), tileList.get(s).getY());
                } else if (vert % 2 != 0 && hor % 2 != 0) {
                    String s = Integer.toString(hor) + Integer.toString(vert);
                    texture = new Texture(tileList.get(s));
                    batch.draw(texture, tileList.get(s).getX(), tileList.get(s).getY());
                } else {
                    String s = Integer.toString(hor) + Integer.toString(vert);
                    texture = new Texture(tileList.get(s));
                    batch.draw(texture, tileList.get(s).getX(), tileList.get(s).getY());
                }

            }
        }
    }

    public int getPositionX() {
        Double x = 0.0;

        if (Gdx.input.justTouched()) x = Gdx.input.getX() + 0.0;

        x = x / 64;

        x = Math.floor(x);

        return x.intValue();
    }

    public int getPositionY() {

        Double y = 0.0;

        if (Gdx.input.justTouched()) y = Gdx.input.getY() + 0.0;

        //инвертирую число Y потому что координаты нулевые координаты Y мыши начинаются с верхнего левого угла.
        y = y / 64;
        y = Math.floor(y);
        y = y - 7;
        y = Math.abs(y);

        return y.intValue();
    }


    @Override
    public void show() {
        time = System.currentTimeMillis();
    }

    public void painter(boolean bool) {
        if (bool) {
            if (System.currentTimeMillis() - time > 700) {
                String s = counterX.toString() + counterY.toString();
                tileList.get(s).changeColor(Color.BLUE);
                counterX += 1;
                time = System.currentTimeMillis();
                if (counterX == 8) {
                    counterX = 0;
                    counterY += 1;
                }
                if (counterY == 8) {
                    Gdx.app.exit();
                }

            }
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.begin();

        drawTiles();

if(Gdx.input.justTouched()){bool = true;}
        painter(bool);





/*
            System.out.println(getPositionX());
            System.out.println(getPositionY());
*/


        batch.end();


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
        batch.dispose();

    }
}
