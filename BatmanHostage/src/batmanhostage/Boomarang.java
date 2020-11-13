package batmanhostage;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Boomarang extends JPanel{
    public ImageIcon[] bmr = new ImageIcon[4];
    public int x;
    public int y;
    public int count=0;
    Boomarang(int x,int y){
        for(int i=0;i<bmr.length;i++){
            String imageLocation = "Batmarang"+(i+1)+".png";
            bmr[i] = new ImageIcon(this.getClass().getResource(imageLocation));
	}
        this.x=x;
        this.y=y;
    }
    
    public void move(){
	this.x+=1;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,40,40));
    }
    
}
