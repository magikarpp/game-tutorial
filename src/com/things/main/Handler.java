package com.things.main;

import java.util.LinkedList;
import java.awt.Graphics;

public class Handler {

  LinkedList<GameObject> object = new LinkedList<GameObject>();
  LinkedList<Boss1> bossObjects = new LinkedList<Boss1>();

  public enum DIFF {
    Baby,
    Child,
    Adult
  };

  public DIFF difficulty = DIFF.Baby;

  public void tick(){
    for(int i = 0; i < object.size(); i++){
      GameObject tempObject = object.get(i);

      tempObject.tick();
    }
  }

  public void render(Graphics g){
    for(int i = 0; i < object.size(); i++){
      GameObject tempObject = object.get(i);

      tempObject.render(g);
    }
  }

  public void addObject(GameObject object){
    this.object.add(object);
  }

  public void addBossObject(Boss1 boss){
    this.bossObjects.add(boss);
    this.object.add(boss);
  }

  public void removeObject(GameObject object){
    this.object.remove(object);
  }

  public void removeBossObject(Boss1 boss){
    this.bossObjects.remove(boss);
    this.object.remove(boss);
  }

  public void clearEnemies(){
    for(int i = 0; i < object.size(); i++){
      GameObject tempObject = object.get(i);
      if(tempObject.getId() != ID.Player){
        object.clear();
        addObject(new Player(Game.width/2-32, Game.height-64, ID.Player, this));
      }
    }
  }

  public void clearEverything(){
    object.clear();
    bossObjects.clear();
  }

}
