package batmanhostage;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class Hostage extends Criminal{
    Image img;
    public int count = 0;
    Hostage(){
        String imageLocation = "Hostages.png";
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
                    runner.sleep(80);
		}catch(InterruptedException e){}
            }
	}
    });
    public Image getImage(){
	return img;
    }
}
