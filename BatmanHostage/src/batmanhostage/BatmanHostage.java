package batmanhostage;
import javax.swing.JFrame;
import javax.sound.sampled.Clip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BatmanHostage extends JFrame implements ActionListener {
    //Class Connect
    BatHome home = new BatHome();
    BatStage stage = new BatStage();
    //Button Connect
    public BatmanHostage(){
        this.setSize(1200,900);
        this.add(home);
        home.BStart.addActionListener(this);
        home.BExit.addActionListener(this);
        stage.BPause.addActionListener(this);
        stage.BResum.addActionListener(this);
    }
    //Button run
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == home.BStart){
            this.setLocationRelativeTo(null);
            this.setSize(1200,900);
            this.remove(home);
            this.add(stage);
            stage.requestFocusInWindow();
            stage.score = 0;
            stage.HP = 3;
            stage.times = 60;
            stage.starttime = false;
            stage.startenemy = false;
        }
        else if(e.getSource() == home.BExit){
            System.exit(0);
        }
        else if(e.getSource() == stage.BPause){
            this.setLocationRelativeTo(null);
            this.setSize(1200,900);
            this.add(stage);
            stage.requestFocusInWindow();
            stage.t.suspend();
            stage.time.suspend();
            stage.actor.suspend();                               
            stage.tcriminal.suspend();
            stage.thostage.suspend();
        }
        else if(e.getSource() == stage.BResum){
            this.setLocationRelativeTo(null);
            this.setSize(1200,900);
            this.add(stage);
            stage.requestFocusInWindow();
            stage.t.resume();
            stage.time.resume();
            stage.actor.resume();
            stage.tcriminal.resume();
            stage.thostage.resume();
        }
        this.validate();
        this.repaint();
    }
    //Window
    public static void main(String[] args) {
        BatmanHostage frame = new BatmanHostage();
        frame.setTitle("Batman and Hostage");
        frame.setSize(1200,900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}