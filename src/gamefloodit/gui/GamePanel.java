package gamefloodit.gui;


import gamefloodit.gmae.GameFloodit;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author nabil
 */
public class GamePanel extends javax.swing.JPanel {

    private Color[] colors;
    private GameFloodit game;
    
    /**
     * Creates new form GamePanel
     */
    public GamePanel() {
        initComponents();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public Color[] getColors() {
        return colors;
    }

    public void setColors(Color[] colors) {
        this.colors = colors;
    }

    public GameFloodit getGame() {
        return game;
    }

    public void setGame(GameFloodit game) {
        this.game = game;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int[][] grille = game.getGrille();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15;j++) {
                g.setColor(colors[grille[i][j]]);
                g.fillRect(i*20, j*20, 20, 20);
            }
        }
    }
}