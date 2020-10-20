package hardestgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ElSnako
 */
public class HardestGame extends JPanel implements KeyListener, MouseListener {

    private Timer timer;
    private int frameCount = 0;
    private Player player;
    private Border border;
    private Enemy enemy1, enemy2;
    private Endzone start;
    private Endzone finish;
    private final static Color Gray = new Color (169,169,169);
    public HardestGame() {
        this.border = new Border(50, 50, 700, 500);
        this.player = new Player(65, 290);
        this.enemy1 = new Enemy (285, 285, 5, 5);
        this.enemy2 = new Enemy (485, 285, 5, 5);
        this.start = new Endzone (50, 50, 50, 500, true);
        this.finish = new Endzone (700, 50, 50, 500, false);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/12);
    }
    
     @Override
     //"g" is the graphics component (deals with all of the graphics)
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        frameCount++;
        
        this.setBackground(this.Gray);		
        
        border.draw(g);
        start.draw(g);
        finish.draw(g);
        enemy1.draw(g);
        enemy2.draw(g);
        player.draw(g);
        
        //Moves the enemies
        enemy1.move();
        enemy2.move();
        enemy1.collideWorldBounds(border);
        enemy2.collideWorldBounds(border);
        
        //Collisions with the enemy
        player.playerVsEnemy(enemy1, start);
        player.playerVsEnemy(enemy2, start);
        
        //Keeping the player within the boundaries of the border
        player.isInBounds(border);
        
        //Finishing the game
        player.playerVsEndzone(finish);
    }
     
    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            repaint();
        }
    }
    
    public static void main(String[] args) {
        //Makes the window that pops up
        JFrame j = new JFrame("Currently In Development, Almost Done!");
        //Constructor
        Container c = new HardestGame();
        j.add(c);
        j.pack();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(800, 600);
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.addKeyListener((KeyListener) c);
        j.addMouseListener((MouseListener) c);
        //Calls the method that makes the enemies move

    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.printf("\nKeyCode: %d was pressed",e.getKeyCode());
        if (e.getKeyCode() == 87) {
            player.move(0, -1);
        }
        if (e.getKeyCode() == 65) {
            player.move(-1, 0);
        }
        if (e.getKeyCode() == 83) {
            player.move(0, 1);
        }
        if (e.getKeyCode() == 68) {
            player.move(1, 0);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.printf("\nMouse Clicked at (%d,%d)",e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
