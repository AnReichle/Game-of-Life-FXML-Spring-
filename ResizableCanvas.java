/**

 * 
 * https://dlsc.com/2014/04/10/javafx-tip-1-resizable-canvas/
 */
 
class ResizableCanvas extends Canvas {
 
    public ResizableCanvas() {
      // Redraw canvas when size changes.
      widthProperty().addListener(evt -> draw());
      heightProperty().addListener(evt -> draw());
    }
 
    private void draw() {
      double width = getWidth();
      double height = getHeight();
 
      GraphicsContext gc = getGraphicsContext2D();
      gc.clearRect(0, 0, width, height);
 
      gc.setStroke(Color.RED);
      gc.strokeLine(0, 0, width, height);
      gc.strokeLine(0, height, width, 0);
    }
 
    @Override
    public boolean isResizable() {
      return true;
    }
 
    @Override
    public double prefWidth(double height) {
      return getWidth();
    }
 
    @Override
    public double prefHeight(double width) {
      return getHeight();
    }
  }
