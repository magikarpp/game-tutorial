package com.things.main;

import java.util.Random;

public class Spawn {

  private Handler handler;
  private HUD hud;
  private Random r = new Random();

  private int scoreKeep = 0;

  public Spawn(Handler handler, HUD hud){
    this.handler = handler;
    this.hud = hud;
  }

  public void tick(){
    scoreKeep++;
    if(scoreKeep == 0){
      if(hud.getLevel() == 0){
        handler.addObject(new BasicEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.BasicEnemy, handler));
      }
    }

    if(scoreKeep >= 250){

      scoreKeep = 0;
      hud.setLevel(hud.getLevel() + 1);
      if(hud.getLevel() == 2){
        handler.addObject(new BasicEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.BasicEnemy, handler));
        handler.addObject(new BasicEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.BasicEnemy, handler));
      } else if(hud.getLevel() == 3){
        handler.addObject(new FastEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.FastEnemy, handler));
      } else if(hud.getLevel() == 4){
        handler.addObject(new SmartEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.SmartEnemy, handler));
      } else if(hud.getLevel() == 6){
        handler.clearEnemies();
        handler.addObject(new Boss1(Game.width/2-48, -125, ID.Boss1, handler));
      }

    }
  }

}
