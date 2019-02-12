package com.things.main;

public class Spawn {

  private Handler handler;
  private HUD hud;

  private int scoreKeep = 0;

  public Spawn(Handler handler, HUD hud){
    this.handler = handler;
    this.hud = hud;
  }

  public void tick(){
    scoreKeep++;

    if(scoreKeep >= 1000){
      scoreKeep = 0;
      hud.setLevel(hud.getLevel() + 1);
    }
  }

}
