import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Ventana extends JFrame implements KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Canvas Micanvas;
	
	Ventana(){
		this.addKeyListener(this);
		setLayout(new BorderLayout());
		Micanvas = new Canvas();
		add(Micanvas, BorderLayout.CENTER);	
		Micanvas.addKeyListener(Micanvas);
		Micanvas.setFocusable(true);
	    Micanvas.gameStart();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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