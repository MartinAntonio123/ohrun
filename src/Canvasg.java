import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class Canvasg extends Canvasabs implements Runnable, MouseListener {

	public static int WIDTH = 900;
	public static int HEIGHT = 600;
	private Thread thread;
	boolean running;
	private int FPS = 60;
	private long optimalTime = 1000 / FPS;
	private Background myBackground;
	private Personaje myPersonaje;
	private Image offScreenImage = null;
	private Graphics offScreenGraphics = null;
	private Image offScreenImageDrawed = null;
	private Graphics offScreenGraphicsDrawed = null;
  private EnemigoSStatic enemigosEstaticos;
  private EnemigoSMoviles enemigosMoviles;
  private Ventana myVentana;
  private int recordactual, counter, recordtotal;
  private Record myrecord;


	public Canvasg(String bg, Ventana ventana){
		super();
		this.addMouseListener(this);
    myVentana = ventana;
		myBackground = new Background(bg);
		myPersonaje = new Personaje();
    enemigosEstaticos = new EnemigoSStatic();
    enemigosMoviles = new EnemigoSMoviles();
    myrecord = new Record();
	}
	public void gameStart(){
		if(!running || (thread == null)){
			running = true;
	        thread = new Thread(this);
	        thread.start();
		}
	}
  public void gameStop(){
			running = false;
      thread.stop();
	}
	@Override
	public void run() {
        long startTime;
        long elapsedTime;
        long waitTime;
        while (running){
            startTime = System.nanoTime();
            gameUpdate();
            repaint();
            elapsedTime = System.nanoTime() - startTime;
            waitTime = optimalTime - elapsedTime / 1000000;
            try {
                if (waitTime <= 0){
                    waitTime = 2;
                }
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	public void gameUpdate(){
		myBackground.avanza(4);
		myPersonaje.avanzar();
    enemigosEstaticos.avanza(8);
    if(enemigosEstaticos.choque(this.myPersonaje)){
      //System.out.println("choque");
      endgame();
    }
    enemigosMoviles.avanza(2);
    if(enemigosMoviles.choque(this.myPersonaje)){
      //System.out.println("choque mobil");
      endgame();
    }
    counter++;
    if (counter == 60) {
      recordactual++;
      counter = 0;
    }
	}
    public void paint (Graphics g){
			if (offScreenImageDrawed == null) {
	        offScreenImageDrawed = createImage(1200, 800);
	    }
			offScreenGraphicsDrawed = offScreenImageDrawed.getGraphics();
	    offScreenGraphicsDrawed.setColor(Color.white);
			offScreenGraphicsDrawed.fillRect(0, 0, WIDTH, HEIGHT);
      myBackground.paint(offScreenGraphicsDrawed);
      myPersonaje.paint(offScreenGraphicsDrawed);
      enemigosEstaticos.paint(offScreenGraphicsDrawed);
      enemigosMoviles.paint(offScreenGraphicsDrawed);
      if (!running) {
        offScreenGraphicsDrawed.setFont(new Font("Verdana",1,20));
  			offScreenGraphicsDrawed.setColor(Color.blue);
  			offScreenGraphicsDrawed.fillRect(320, 170, 280, 50);
  			offScreenGraphicsDrawed.setColor(Color.white);
  			offScreenGraphicsDrawed.drawString("best: "+ recordtotal, 360, 200);
  			offScreenGraphicsDrawed.setColor(Color.blue);
  			offScreenGraphicsDrawed.fillRect(320, 370, 280, 50);
  			offScreenGraphicsDrawed.setColor(Color.white);
  			offScreenGraphicsDrawed.drawString("yours: " + recordactual, 360, 400);
      }
			g.drawImage(offScreenImageDrawed, 0, 0, null);
    }
	public void update(Graphics g){
		paint(g);
	}
  public void endgame(){
    System.out.println(recordactual);
		running = false;
    myrecord.setRecord(recordactual);
    recordtotal = myrecord.getRecord();
    repaint();
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		myPersonaje.atacar();
	}
  public void mouseEntered(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }
  @Override
  public void mouseExited(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }
  @Override
  public void mousePressed(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }
  @Override
  public void mouseReleased(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }
  public void keyPressedAux(int code) {
    if (code == 38) {
      myPersonaje.saltar();
    }
		else if (code == 39) {
      myPersonaje.avanzarr();
    }
    else if (code == 37) {
      myPersonaje.retroceder();
    }
	}
}
