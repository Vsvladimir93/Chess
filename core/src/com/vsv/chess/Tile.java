package com.vsv.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

/**
 * Created by Vova on 07.01.2018.
 */
public class Tile extends Pixmap {
    private int x;
    private int y;
    static final int SIZE = 64;
    private Color color;

    public Tile(int x, int y, Color color) {
        super(SIZE, SIZE, Pixmap.Format.RGB888);
        this.x = x*SIZE;
        this.y = y*SIZE;
        this.color = color;
        super.setColor(this.color);
        super.fill();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPosition() {
        return x*100 + y;
    }

    public void changeColor(Color color){
        super.setColor(color);
        super.fill();

    }

    public static int getSIZE() {
        return SIZE;
    }

}
