import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;

public class hhScreenShot extends JFrame{
	
	int startx,starty,endx,endy;
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	BufferedImage image;
	BufferedImage tempImage;
	BufferedImage saveImage;
	Graphics g;

	public hhScreenShot(){
		screenCapture();
		setVisible(true);
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				startx=e.getX();
				starty=e.getY();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				endx=e.getX();
				endy=e.getY();
				g=getGraphics();
				g.drawImage(tempImage, 0, 0, hhScreenShot.this);
				int x=Math.min(startx, endx);
				int y=Math.min(starty,endy);

				int width=Math.abs(endx-startx)+1;
				int height=Math.abs(endy-starty)+1;
				g.setColor(Color.BLUE);
				g.drawRect(x-1, y-1, width+1, height+1);
				saveImage=image.getSubimage(x, y, width, height);
				g.drawImage(saveImage, x, y,hhScreenShot.this);
			}
		});

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==32){
					savePic();
				}
				if(e.getKeyCode()==27){
					//System.exit(0);
					setVisible(false);
				}
			}
		});
	}
	
	public void paint(Graphics g) {
		RescaleOp ro=new RescaleOp(1.0f, -40, null);
		tempImage=ro.filter(image, null);
		g.drawImage(tempImage, 0, 0,this);
	}
	public void savePic(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String name="screenshot"+sdf.format(new Date());
		File path=FileSystemView.getFileSystemView().getHomeDirectory();
		String format="jpg";
		File f=new File(path+File.separator+name+"."+format);
		try {
			ImageIO.write(saveImage, format, f);
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}
	
	public void screenCapture(){
		try {
			Robot robot= new Robot();
			Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
			image=robot.createScreenCapture(new Rectangle(0,0,screenSize.width,screenSize.height));
 		     } catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		 hhScreenShot screenshot = new hhScreenShot();
	     GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	     gd.setFullScreenWindow(screenshot);
	}
}
