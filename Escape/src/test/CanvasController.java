package test;


public class CanvasController {
	
	/*
	public void mouseDragged(MouseEvent e) {
        Point screenPos = getScreenPos(e);
        update(screenPos);
        
        Transform planeToScreen = view.planeToScreen();
        if (drag.hasObject()) {
            drag.update(screenPos, planeToScreen);
        } else {
            Point prevPlanePos = planeToScreen.invert(prevPos);
            Point planePos = getPlanePos(e);
            Point d = diff(planePos, prevPlanePos);
            view.prepend(Transforms.t(d));
        }
        prevPos = screenPos;
    }
	
	
	 private Point getScreenPos(MouseEvent e) {
         java.awt.Point p = e.getPoint();
         return new Point(p.x, p.y);
     }
	 
	 private Point getPlanePos(MouseEvent e) {
         Point screenPos = getScreenPos(e);
         return view.planeToScreen().invert(screenPos);
     }
	 
	 private void update(Point pos) {
         properties.put("cursor", pos);
     }
	 */
}
