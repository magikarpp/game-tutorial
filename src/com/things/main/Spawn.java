package com.things.main;

import java.util.Random;

public class Spawn {

  private Handler handler;
  private HUD hud;
  private Game game;
  private Random r = new Random();

  private int scoreKeep = 0;
  private boolean bossAlive = false;

  public Spawn(Handler handler, HUD hud, Game game){
    this.handler = handler;
    this.hud = hud;
    this.game = game;
  }

  public void tick(){
    scoreKeep++;
    if(scoreKeep == 0){
      if(hud.getLevel() == 0){
        handler.addObject(new BasicEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.BasicEnemy, handler));
      }
    }

    if(bossAlive){
      for(int i = 0; i < handler.bossObjects.size(); i++){
        Boss1 tempBoss = handler.bossObjects.get(i);
        if(tempBoss.getId() == ID.Boss1){
          if(tempBoss.getHealth() <= 0){
            handler.clearEverything();
            bossAlive = false;
            game.gameState = Game.STATE.Win;
          }
        }
      }
    }


    if(scoreKeep >= 500){
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
        Boss1 boss1 = new Boss1(Game.width/2-48, -125, ID.Boss1, handler);
        handler.addBossObject(boss1);
        bossAlive = true;
      } else if(hud.getLevel() == 7){
        handler.addObject(new Boss1Token(r.nextInt(Game.width - 50), r.nextInt(Game.height - 250)+250, ID.Boss1Token, handler));
      } else if(hud.getLevel() == 8){
        handler.addObject(new Boss1Token(r.nextInt(Game.width - 50), r.nextInt(Game.height - 250)+250, ID.Boss1Token, handler));
      } else if(hud.getLevel() == 9){
        handler.addObject(new Boss1Token(r.nextInt(Game.width - 50), r.nextInt(Game.height - 250)+250, ID.Boss1Token, handler));
      } else if(hud.getLevel() == 10){
        handler.addObject(new Boss1Token(r.nextInt(Game.width - 50), r.nextInt(Game.height - 250)+250, ID.Boss1Token, handler));
      } else if(hud.getLevel() == 11){
        handler.addObject(new Boss1Token(r.nextInt(Game.width - 50), r.nextInt(Game.height - 250)+250, ID.Boss1Token, handler));
      }
    }
  }

  public boolean getBossAlive(){
    return this.bossAlive;
  }

  public void setBossAlive(boolean bossAlive){
    this.bossAlive = bossAlive;
  }

}
