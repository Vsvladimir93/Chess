package com.vsv.chess;


import com.badlogic.gdx.Game;

public class Main extends Game {
    GameScreen gameScreen;

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void create() {
        gameScreen = new GameScreen();
        setScreen(gameScreen);
    }
}