import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	private Canvasabs micanvasm, micanvasg;
	private Music myMusic;
	private String background;

	Ventana(){
		setLayout(new BorderLayout());
		background = "../bg/background.png";
		micanvasm = new Canvasg(background,this);
		add(micanvasm, BorderLayout.CENTER);
		micanvasm.addKeyListener(micanvasm);
		micanvasm.setFocusable(true);
	  micanvasm.gameStart();
		myMusic = new Music();
		myMusic.start();
	}
	public void setPlay(){
		this.micanvasm = new Canvasm(background, this);
	}
	public void setMenu(){
		this.micanvasm = new Canvasm(background, this);
	}
}
