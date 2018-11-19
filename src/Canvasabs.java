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
public abstract class Canvasabs extends JPanel implements Runnable, MouseListener, KeyListener
{
    public abstract void paint(Graphics g);
    public abstract void gameStart();
}
