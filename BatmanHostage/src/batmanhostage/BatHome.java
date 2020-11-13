package batmanhostage;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BatHome extends JPanel {
    //Image
    private ImageIcon gotham = new ImageIcon(this.getClass().getResource("Gotham bgd.png"));
    private ImageIcon start = new ImageIcon(this.getClass().getResource("Bat Bstart.png"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("Bat Bexit.png"));
    public JButton BStart = new JButton(start);
    public JButton BExit = new JButton(exit);
    //Button
    BatHome(){
        setLayout(null);
        BStart.setBounds(318,460,180,80);
        add(BStart);
        BExit.setBounds(318,600,180,80);
        add(BExit);
    }
    //Background
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(gotham.getImage(),0,0,1200,900,this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,60));
        g.drawString("Batman and Hostage",120,307);
    }
    
}