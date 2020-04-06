import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ControlePanel extends JPanel implements ActionListener{

    private boolean ingame;
    private Personnage personnage;
    private final int B_WIDTH = 700;
    private final int B_HEIGHT = 600;
    private final int caseWidth = 70;
    private final int caseHeight = 60;
    int tab[][];

    public ControlePanel() {

        initControlePanel();
    }

    private void initControlePanel() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.gray);
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        personnage = new Personnage(10,10);

        // initialisé les mouvements

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (ingame) {

            drawObjects(g);

        } else {

            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {
        
       // 1 = mur (rouge) / 2 = case non visité (grey)) / 3 = case visité (bleu / 4 =  joueur (violet)
       // cadrillage 10 par 10

        //   personnage.setTab(tab);
        // tab =personnage.newTable();
        tab = personnage.getTab();
       for(int i=0; i<10;i++){
           for(int j=0; j<10;j++){
               switch (tab[i][j]){
                   case 1 : g.setColor(Color.red);
                   break;
                   case 2 : g.setColor(Color.gray);
                   break;
                   case 3 : g.setColor(Color.blue);
                   break;
                   case 4 : g.setColor(Color.pink);
                   break;
                //    default : Trow new exeption("ERREUR");
               }
               g.fillRect(caseWidth*i, caseHeight*j, caseWidth, caseHeight);
           }
       }
       

    }

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();
        // updateShip();
        // updateMissiles();
        // updateInvader();
        // chekChoc();
        repaint();
    }

    private void updatePersonnage() {
        if (personnage.isVisible()) {
            // personnage.move();
        }
    }
    private void inGame() {
        if (!ingame) {
            // action définissant la fin du jeu
        }
    }
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            // personnage.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            // personnage.keyPressed(e);
        }
    }
}