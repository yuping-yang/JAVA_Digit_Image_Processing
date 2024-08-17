import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class ddHistogram extends Frame{
	Image tmp;
	int iw, ih;
	int[] pixels = new int[iw*ih]; 
	boolean flag_load = false;
	boolean flag_gray = false;
	public boolean flag_equal = false;
	BufferedImage image;	
	
	public ddHistogram(BufferedImage Image){
		image=Image;
		this.setTitle("Histogram harmonization");
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				//System.exit(0); 
				//setVisible(false);  
				ddHistogram.this.dispose();   
				//tmp=image;
			}
		}
		);		
		Panel panelHis = new Panel();
		panelHis.setBackground(Color.LIGHT_GRAY);
	    this.add(panelHis, BorderLayout.SOUTH);
	    Button load, gray, hist, equal;
	    Button save, quit;

	    load = new Button("Display original image");
	    gray = new Button("Get grayscale image");
	    hist = new Button("Grayscale histogram");
	    equal = new Button("Histogram harmonization");

	    panelHis.add(load);
	    panelHis.add(gray);
	    panelHis.add(hist);
	    panelHis.add(equal);

    	load.addActionListener(new ActionListener(){    
    		public void actionPerformed(ActionEvent e){
    			try {
					jLoad_ActionPerformed(e);
				} catch (IOException e1) {	
					e1.printStackTrace();
				}
    		}
    	});

    	gray.addActionListener(new ActionListener(){    
    		public void actionPerformed(ActionEvent e){
    			try {
					jGray_ActionPerformed(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
    		}
    	});

    	hist.addActionListener(new ActionListener(){    
    		public void actionPerformed(ActionEvent e){
    			jHist_ActionPerformed(e);
    		}
    	});

    	equal.addActionListener(new ActionListener(){    
    		public void actionPerformed(ActionEvent e){
    			jEqual_ActionPerformed(e);
    		}
    	});
	}

    public void jLoad_ActionPerformed(ActionEvent e) throws IOException{       	
		tmp = image;
        flag_load = true;
        repaint();
	}
   
	public static int[] hisNum= new int[256];
    public void jGray_ActionPerformed(ActionEvent e) throws IOException{
		if(flag_load){
  			iw = image.getWidth(this);
  		    ih = image.getHeight(this);
  		    pixels = new int[iw*ih]; 
			int srcRGBs[] = image.getRGB(0, 0, iw, ih, null, 0, iw); 
			int rgb[]=new int[3];
			BufferedImage grayImage = new BufferedImage(iw, ih, BufferedImage.TYPE_INT_RGB);
			for(int j=0; j<ih; j++) {
			    for (int i = 0; i < iw; i++) {
			    	ImageColor.colorINTtoRGB(srcRGBs[j*iw+i],rgb);	    	
					 // Gray = (R*299 + G*587 + B*114 + 500) / 1000 
					int gray=((rgb[0]*299+rgb[1]*587+rgb[2]*114+500)/1000);
					rgb[0]=gray;
					rgb[1]=gray;
					rgb[2]=gray;
					grayImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));					
			    }	
			}			
  			tmp = grayImage;
  			
  			try{
    			PixelGrabber pg = new PixelGrabber(tmp,0,0,iw,ih,pixels,0,iw);
    			pg.grabPixels();
    		} catch(InterruptedException e3){
    			e3.printStackTrace();
    	      }
  			
  			flag_gray = true;
  			repaint();
			} 
		 
		else{
				JOptionPane.showMessageDialog(null, "Please make sure you have completed the "Display original image" operation!","notice",JOptionPane.WARNING_MESSAGE);
			}
	}
    

    public void jHist_ActionPerformed(ActionEvent e){
    	int a=0;
    	if (flag_equal)a=1;
    	if(flag_gray){ 	
    			
    	hispic h = new hispic();    	
    	h.getData(pixels, iw, ih);
    	//h.setSize(2*480,2*350);
        h.setLocationRelativeTo(null);
        //java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        //h.setBounds((screenSize.width-481)/2, (screenSize.height-338)/2, 481, 338);
        if(a==0)h.setBounds(0,0,685,700);
        else h.setBounds(685,0,685,700);
    	h.setVisible(true);
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Please make sure you have completed the "Display original image" and "Get grayscale image" operations!","notice",JOptionPane.WARNING_MESSAGE);
    	}
    }
    
   public void jEqual_ActionPerformed(ActionEvent e){
      if(flag_load&&flag_gray){

    	   BufferedImage hisImage = new BufferedImage(iw, ih, BufferedImage.TYPE_BYTE_GRAY);

    	   for(int i=0; i<ih-1; i++){
    		  for(int j=0; j<iw-1; j++){

    			  int gray = pixels[i*iw+j]&0xff;
    			   hisNum[gray]++;  
    		  }
    	   }

    	  double a = (double)255/(iw*ih);

          double[] newHis = new double [256];
    	  newHis[0] =a* hisNum[0];

    	  for(int i=1; i<256; i++){
    		newHis[i] = newHis[i-1]+a*(hisNum[i]);
               	for(int i=0; i<ih; i++){
    		for(int j=0; j<iw; j++){
    			int gray = pixels[i*iw+j]&0xff;
    			int hist = (int)(newHis[gray]);
    			if(hist<0)hist=0;
    			if(hist>255)hist=255;
    			
    			pixels[i*iw+j] = 255<<24|hist<<16|hist<<8|hist;
    			hisImage.setRGB(j, i, pixels[i*iw+j]);
    		}
    	}
  		
    	tmp = hisImage;
  		flag_equal = true;
  		repaint();
      }
    	
      else{
			JOptionPane.showMessageDialog(null, "Please make sure you have completed the "Display original image" and "Get grayscale image" operations!","notice",JOptionPane.WARNING_MESSAGE);
		  }
   }
  	
  	public void paint(Graphics g){
  		//if(flag_Load){
  			g.drawImage(tmp,50,50,this);
  		//}else{}
  	}
}

class hispic extends Frame{
	  int data[];
	  int hisNum[] = new int[256];	
	  public hispic(){
		  this.setTitle("Grayscale histogram");
		  Panel pdown = new Panel();
		  Button quit = new Button("close");
		  this.add(pdown, BorderLayout.SOUTH); 
		  pdown.add(quit);
		  quit.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				jQuit_ActionPerformed(e);
			 }
		  });

		  addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent e){
				hispic.this.dispose();
			  }
		  });
	  }
	  public void jQuit_ActionPerformed(ActionEvent e){
		  this.setVisible(false);
	  }
	  public void getData(int[] data, int iw, int ih){
		  this.data = data;
		  for (int i = 0; i < iw * ih; i++){
			  int gray = data[i] & 0xff;
			  hisNum[gray]++;
		  }
		
		  int temp = hisNum[0];
		  for (int i = 0; i < 256; i++){
			  if (temp <= hisNum[i]){
			  temp = hisNum[i];
			  //System.out.println(temp);
			  }
		  }
		  for (int i = 0; i < 256; i++){
			  hisNum[i] = hisNum[i] * 200 / temp;
		  }
	  }

	  public void paint(Graphics g){
		g.drawLine(100, 500, 612, 500);
		g.drawLine(100, 100, 100, 500);

		g.drawString("0", 96, 526);
		g.drawString("50", 190, 526);
		g.drawString("100",286, 526);
		g.drawString("150", 386, 526);
		g.drawString("200", 486, 526);
		g.drawString("250", 586, 526);

		g.drawString("0.5", 66, 290);
		g.drawString("1", 80, 120);

		for (int i = 0; i < 256; i++){
		 	g.drawLine(100 + 2*i, 500, 100 +2* i, 500 - 2*hisNum[i]);
		}
		g.drawString("Grayscale histogram",300, 580);
	 }
}
  

