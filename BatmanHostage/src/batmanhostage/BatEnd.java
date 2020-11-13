package batmanhostage;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

class BatEnd extends JPanel{
    
    private ImageIcon bend = new ImageIcon("Gotham end.png");
    private ImageIcon starto = new ImageIcon("Bat Bstart.png");
    private ImageIcon exito = new ImageIcon("Bat Bexit.png");
    public JButton BStarto = new JButton(starto);
    public JButton BExito  = new JButton(exito);
    
    BatEnd(){
        this.setLayout(null);
        BExito.setBounds(500, 650, 150,90);
	add(BExito);
	BStarto.setBounds(750,650,150,90);
        add(BStarto);
    }
    
    public void paintComponent(Graphics g){
	super.paintComponent(g);
        g.drawImage(bend.getImage(),0,0,1200,900,this);
    }
    
}
