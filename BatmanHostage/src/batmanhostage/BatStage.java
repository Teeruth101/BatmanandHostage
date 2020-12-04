package batmanhostage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class BatStage extends JPanel implements ActionListener{
    //setting
    private final ImageIcon stage1 = new ImageIcon(this.getClass().getResource("Batstage1.png"));
    private final ImageIcon pause = new ImageIcon(this.getClass().getResource("Bat pause.png"));
    private final ImageIcon resum = new ImageIcon(this.getClass().getResource("Bat resume.png"));
    Batman bat = new Batman();
    
    BatHome bhome = new BatHome();
    ImageIcon bend = new ImageIcon(this.getClass().getResource("Gotham end.png"));
    ImageIcon atk = new ImageIcon(this.getClass().getResource("batman4.png"));
    ImageIcon starto = new ImageIcon(this.getClass().getResource("Bat Bstart.png"));
    ImageIcon exito = new ImageIcon(this.getClass().getResource("Bat Bexit.png"));
    JButton BStarto = new JButton(starto);
    JButton BExito  = new JButton(exito);
    
    private JLabel lb = new JLabel();
    public JButton BPause = new JButton(pause);
    public JButton BResum = new JButton(resum);
    public ArrayList<Boomarang> boomarang = new ArrayList<Boomarang>();
    public ArrayList<Criminal> criminal = new ArrayList<Criminal>();
    public ArrayList<Hostage> hostage = new ArrayList<Hostage>();
    
    public int times;
    public int HP = 3;
    public int rs1 = 1;
    boolean starttime = true;
    boolean startenemy = false;
    
    private BatEnd gover = new BatEnd();
    public int score = 0;
    boolean paralyze1 = false;
    int time_paralyze=5;
	
    Thread time = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{
                    Thread.sleep(10);
                }catch(Exception e){ }
                    
                if(starttime == false){
                    repaint();
                }
            }
        }
    });
	
    Thread actor = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{
                    Thread.sleep(1);
                }catch(Exception e){}
                    repaint();
            }
        }
    });
    
    Thread tcriminal = new Thread(new Runnable(){
        public void run() {
            while(true){
                try{
                    if(startenemy == false){
                        Thread.sleep((long)(Math.random()*10000)+2000);
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                if(startenemy == false){
                    criminal.add(new Criminal());
                }
            }
        }
    });
    
    Thread thostage = new Thread(new Runnable(){
        public void run() {
            while(true){
		try{
                    if(startenemy == false){
                        Thread.sleep((long)(Math.random()*10000)+2000);
                    }
		}catch(InterruptedException e){
                    e.printStackTrace();
		}
		if(startenemy == false){
                    hostage.add(new Hostage());
                }
            }
        }
    });
    
    Thread paralyze = new Thread(new Runnable(){
        public void run(){
            while (true){
                if(time_paralyze < 1){
                    paralyze1 = false;
                    time_paralyze = 5;
                }
		try{
                    Thread.sleep(5000);
		}catch(InterruptedException e){e.printStackTrace();}
            }
        }
    });
    
    Thread t = new Thread(new Runnable(){
        public void run() {
            while(true){
                if(starttime == false){
                    times = (times-1) ;
                    if(paralyze1){
                        time_paralyze--;
                    }
                }
		try{
                    Thread.sleep(1000);
		}catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    });
    
    //=====Control=====
    BatStage(){
        this.setFocusable(true);
        this.setLayout(null);
        BPause.setBounds(950,70,50,50);
        BResum.setBounds(1050,70,50,50);
        BPause.addActionListener(this);
        BResum.addActionListener(this);
        this.add(BPause);
        this.add(BResum);
        this.add(lb);
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
                if(!paralyze1){
                    if(a == KeyEvent.VK_W){
			bat.y-=10;
                        bat.count++;
                    }
                    else if(a == KeyEvent.VK_S){
                        bat.y+=10;
                        bat.count++;
                    }
                    else if(a == KeyEvent.VK_A){
                        bat.x-=10;
                        bat.count++;
                    }
                    else if(a == KeyEvent.VK_D){
                        bat.x+=10;
                        bat.count++;
                    }
                    if(bat.count>2){
                        bat.count=0;
                    }
                    else if(a == KeyEvent.VK_SPACE){
                        bat.count=3;
			boomarang.add(new Boomarang(bat.x+100,bat.y+75));
                    }
                }
            }
            public void keyReleased(KeyEvent e){
                bat.count=0;
            }
	});
        bat.x = 200;
	bat.y = 400;
	time.start();
	actor.start();
	t.start();
	tcriminal.start();
	thostage.start();
	paralyze.start();
    }
    
    //=====Play=====
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //=====Gameover=====
        if(times <= 0 || HP <= 0){
            this.remove(BPause);
            this.remove(BResum);
            this.setLayout(null);
            g.drawImage(bend.getImage(),0,0,1200,900,this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,80));
            g.drawString("Game Over",400,200);
            g.drawString("Score : "+score,440,350);
        }
        //=====Stage1=====
        else{
            g.drawImage(stage1.getImage(),0,0,1200,900,this);
            if(paralyze1){
            }
            else{
                g.drawImage(bat.bm[bat.count].getImage(),bat.x,bat.y,150,200,this);
            }
            //===Boomarang
            for(int i=0;i<boomarang.size();i++){
		Boomarang bo = boomarang.get(i);
                g.drawImage(bo.bmr[bo.count%3].getImage(),bo.x,bo.y,50,50,null);
		bo.move();
                bo.count++;
		if(bo.x>1200){
		    boomarang.remove(i);
		}
            }
            //===Criminal
            for(int i=0 ; i<criminal.size();i++){
                g.drawImage(criminal.get(i).img,criminal.get(i).getX(),criminal.get(i).getY(),200,200,this);
            }
            for(int i=0 ; i<boomarang.size();i++){
		for(int j=0 ; j<criminal.size();j++){
		    if(Intersect(boomarang.get(i).getbound(),criminal.get(j).getbound())){
			criminal.remove(j);
			boomarang.remove(i);
			score += 10;
                    }
		}
            }
            //===Hostage
            for(int i=0 ; i<hostage.size();i++){
		g.drawImage(hostage.get(i).getImage(),hostage.get(i).getX(),hostage.get(i).getY(),200,200,this);
            }
            for(int i=0 ; i<boomarang.size();i++){
		for(int j=0 ; j<hostage.size();j++){
		    if(Intersect(boomarang.get(i).getbound(),hostage.get(j).getbound())){
			hostage.remove(j);
			boomarang.remove(i);
			score -= 10;
			HP -= 1;
                    } 
		}
            }
            g.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,28));
            g.setColor(Color.WHITE);
            g.drawString("STAGE "+rs1+"  Time : "+times,18,45);
            g.drawString("HP : "+HP+"   Score : "+score,18,90);
	}
    }
    
    public boolean Intersect(Rectangle2D a, Rectangle2D b){
        return (a.intersects(b));
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== BStarto){		
            this.setSize(1200,900);
            this.add(bhome);
            this.setLocation(null);
                starttime = true;
                startenemy = true;
        }
        else if(e.getSource() == BExito){
            System.exit(0);
	}
    }
    
}
