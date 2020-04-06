import java.awt.event.KeyEvent;
public class Personnage extends Init {

    private int positionX;
    private int positionY;
    private int[][] tab;

    public Personnage(int positionX, int positionY) {
        super(positionX, positionY);
        initPerso();
    }

    public static int[][] newTable() {
        int tab[][] = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                       {1,4,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,2,1,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1},
                       {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

        return tab;
    }

    public void initPerso() {
        tab = newTable();

        for(int y=0;y <= tab.length - 1;y++){
            for(int x=0;x <= tab[y].length - 1;x++){
                if(tab[y][x] == 4){
                    positionX = x;
                    positionY = y;
                    break;
                }
            }
        }
        
    }
    
    public void setTab(int[][] tab){
        this.tab = tab;
    }

    public int[][] getTab(){
        return tab;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            while(tab[positionY][positionX-1] != 1){
                tab[positionY][positionX] = 3;
                tab[positionY][positionX-1] = 4;
                positionX = positionX-1;
            }
        }

        if (key == KeyEvent.VK_RIGHT) {
            while(tab[positionY][positionX+1] != 1){
                tab[positionY][positionX] = 3;
                tab[positionY][positionX+1] = 4;
                positionX = positionX+1;

            }
        }

        if (key == KeyEvent.VK_UP) {
            while(tab[positionY-1][positionX] != 1){
                tab[positionY][positionX] = 3;
                tab[positionY-1][positionX] = 4;
                positionY = positionY-1;
            }
        }

        if (key == KeyEvent.VK_DOWN) {
            while(tab[positionY+1][positionX] != 1){
                tab[positionY][positionX] = 3;
                tab[positionY+1][positionX] = 4;
                positionY = positionY+1;
            }
        }
    }
}