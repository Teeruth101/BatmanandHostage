package batmanhostage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Batman {
    public ImageIcon[] bm = new ImageIcon[4];
    public int x;
    public int y;
    public int count=0;
    Batman(){
        for(int i=0;i<bm.length;i++){
            bm[i] = new ImageIcon(this.getClass().getResource("batman"+(i+1)+".png"));
	}
    }
}
