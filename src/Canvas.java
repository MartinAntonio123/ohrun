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

public class Canvas extends JPanel implements Runnable, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public static int WIDTH = 900;
    public static int HEIGHT = 600;
    private Thread thread;
    boolean running;
    private int FPS = 60;
    private long optimalTime = 1000 / FPS;
    private Background myBackground;
    private Personaje myPersonaje;


	public Canvas(){
		super();
		this.addMouseListener(this);
		this.addKeyListener(this);
		myBackground = new Background();
		myPersonaje = new Personaje();
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
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
	}
	public void gameUpdate(){
		myBackground.avanza();
		myPersonaje.avanzar();
	}
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, WIDTH, HEIGHT);
        g2.setColor(Color.BLACK);
        myBackground.paint(g);
        myPersonaje.paint(g);
    }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		myPersonaje.atacar();
		System.out.println("mouse pressed");
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
		myPersonaje.saltar();
		System.out.println("key pressed");
		
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