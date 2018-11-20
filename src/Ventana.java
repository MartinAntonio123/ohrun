import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Ventana extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	private Canvasabs micanvas;
	private Music myMusic;
	private String background;
	private int lastplay;

	Ventana(){
		super();
		this.addKeyListener(this);
		setLayout(new BorderLayout());
		background = "../bg/background.png";
		micanvas = new Canvasm(background,this);
		this.getContentPane().add(micanvas);
	  micanvas.gameStart();
		myMusic = new Music();
		myMusic.start();
		lastplay = 0;
	}
	public void setPlay(){
		this.getContentPane().removeAll();
		this.micanvas = new Canvasg(background, this);
		this.getContentPane().add(micanvas);
		micanvas.gameStart();
		setVisible(true);
		System.out.println("play");
	}
	public void setMenu(){
		this.getContentPane().removeAll();
		this.micanvas = new Canvasm(background, this);
		this.getContentPane().add(micanvas);
		micanvas.gameStart();
		setVisible(true);
		System.out.println("menu");
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		int code = arg0.getKeyCode();//32 space, 39 rigth, 37 left
		//System.out.println(code);
		micanvas.keyPressedAux(code);
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	public void setBg(String string){
		this.background = string;
	}
}
