package batmanhostage;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class Criminal {
    Image img;
    public int x = 1200;
    public int y = (int)((Math.random()*300)+300);
    public int count = 0;
    Criminal(){
        String imageLocation = "Criminals.png";
        URL imageURL = this.getClass().getResource(imageLocation);
	img = Toolkit.getDefaultToolkit().getImage(imageURL);
	runner.start();
    }
    Thread runner = new Thread(new Runnable() {
        public void run() {
            while(true){
                x -= 2;
                if(x <= 0){
                    img = null;
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try{
                    runner.sleep(10);
                }catch(InterruptedException e){}
            }
        }
    });
	
	public Image getImage(){
            return img;
	}
	public int getX(){
            return x;
	}
	public int getY(){
            return y;
	}
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,180,180));
	}
}
