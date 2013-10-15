package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

import model.backbone.building.helpers.Point;

public class CanvasPanel extends JPanel {

	private static final long serialVersionUID = 7376278600133280828L;

	private Transform normToScreen;

    private Transform screenToNorm;

    /**
     * Creates new canvas panel.
     */
    public CanvasPanel() {
        setBackground(Color.white);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        addComponentListener(new ComponentAdapter() {
            
            @Override
            public void componentShown(ComponentEvent e) {
                requestFocusInWindow();
                recomputeTransform();
            }
            
            @Override
            public void componentResized(ComponentEvent e) {
                recomputeTransform();
            }

        });
    }


    /**
     * Causes canvas repaint.
     */
    public void refresh() {
        repaint();
    }

    private void recomputeTransform() {
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        
        Transform.Builder builder = new Transform.Builder()
                .flipY()
                .t(1, 1)
                .s(panelWidth / 2.0, panelHeight / 2.0);

        normToScreen = builder.create();
        screenToNorm = builder.invert().create();
    }

    public Transform normToScreen() {
        return normToScreen;
    }

    public Transform screenToNorm() {
        return screenToNorm;
    }

    /**
     * Transforms the coordinates in the normalized space to the screen
     * coordinates.
     * 
     * @param p
     *            ScreenPoint in virtual coordinates
     * @return Point in screen coordinates
     */
    public Point toScreen(Point p) {
        return normToScreen.apply(p);
    }

    /**
     * Transforms screen coordinates to the coordinates in the normalized space.
     * 
     * @param p
     *            ScreenPoint in screen coordinates
     * @return ScreenPoint in virtual coordinates
     */
    public Point toNorm(Point p) {
        return screenToNorm.apply(p);
    }

    @Override
    protected final void paintComponent(Graphics g) {
        super.paintComponent(g);
        recomputeTransform();
//        if (painter != null) {
//            Graphics2D graphics = (Graphics2D) g;
//          //  painter.paint(normToScreen, graphics);
//        }
    }

}