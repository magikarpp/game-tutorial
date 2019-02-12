package com.things.main;

import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;

import java.util.Random;

public class Game extends Canvas implements Runnable{

  private static final long serialVersionUID = 00002L;

  public static final int width = 640, height = width / 12 * 9;

  private Thread thread;
  private boolean running = false;

  private Random r;
  private Handler handler;

  public Game(){
    handler = new Handler();
    this.addKeyListener(new KeyInput(handler));

    new Window(width, height, "A New Game!", this);

    r = new Random();

    handler.addObject(new Player(width/2-32, height/2-32, ID.Player));
    handler.addObject(new Player(width/2+64, height/2+64, ID.Player2));

  }

  public synchronized void start(){
    thread = new Thread(this);
    thread.start();
    running = true;
  }

  public synchronized void stop(){
    try{
      thread.join(); // killing off the thread
      running = false;
    } catch(Exception e){
      e.printStackTrace();
    }

  }

  public void run(){
    // frame ticks gotten online
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int frames = 0;
    while(running){
      long now = System.nanoTime();
      delta += (now - lastTime) / ns;
      lastTime = now;
      while(delta >= 1){
        tick();
        delta--;
      }
      if(running){
        render();
      }
      frames++;

      if(System.currentTimeMillis() - timer > 1000){
        timer += 1000;
        // System.out.println("FPS: " + frames);
        frames = 0;
      }
    }
    stop();
  }

  private void tick(){
    handler.tick();
  }

  private void render(){
    BufferStrategy bs = this.getBufferStrategy();
    if(bs == null){
      this.createBufferStrategy(3);
      return;
    }

    Graphics g = bs.getDrawGraphics();

    g.setColor(Color.black);
    g.fillRect(0, 0, width, height);

    handler.render(g);

    g.dispose();
    bs.show();
  }

  public static void main(String[] args){
    new Game();
  }
}
