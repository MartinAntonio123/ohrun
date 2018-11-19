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

public class Canvasm extends Canvasabs implements Runnable, MouseListener, KeyListener {

	public static int WIDTH = 900;
	public static int HEIGHT = 600;
	private Thread thread;
	boolean running;
	private int FPS = 60;
	private long optimalTime = 1000 / FPS;
	private Background myBackground;
	private Image offScreenImage = null;
	private Graphics offScreenGraphics = null;
	private Image offScreenImageDrawed = null;
	private Graphics offScreenGraphicsDrawed = null;
  private Ventana myVentana;


	public Canvasm(String bg, Ventana ventana){
		super();
		this.addMouseListener(this);
		this.addKeyListener(this);
    myVentana = ventana;
		myBackground = new Background(bg);
	}
	public void gameStart(){
		if(!running || (thread == null)){
			running = true;
	        thread = new Thread(this);
	        thread.start();
		}
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
		myBackground.avanza(1);
	}
    public void paint (Graphics g){
			if (offScreenImageDrawed == null) {
	        offScreenImageDrawed = createImage(1200, 800);
	    }
			offScreenGraphicsDrawed = offScreenImageDrawed.getGraphics();
	    offScreenGraphicsDrawed.setColor(Color.white);
			offScreenGraphicsDrawed.fillRect(0, 0, WIDTH, HEIGHT);
      myBackground.paint(offScreenGraphicsDrawed);
			g.drawImage(offScreenImageDrawed, 0, 0, null);
    }
	public void update(Graphics g){
		paint(g);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		myVentana.setPlay();
	}
	@Override
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
	@Override
	public void keyPressed(KeyEvent arg0) {

	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
