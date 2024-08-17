import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;
public class ffRoberts {
    public static BufferedImage image_roberts(BufferedImage srcImage,int x) {
    	int width = srcImage.getWidth();
		int height = srcImage.getHeight();
		int srcRGBs[] = srcImage.getRGB(0, 0, width, height, null, 0, width);
		//BufferedImage destImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		int rgb[]=new int[3];
		int rs[][]=new int[width*2][ height*2];
		int gs[][]=new int[width*2][ height*2];
		int bs[][]=new int[width*2][ height*2];
		
		for(int j=0; j<height; j++) {
		    for (int i = 0; i < width; i++) {
		    	ImageColor.colorINTtoRGB(srcRGBs[j*width+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
		    	rs[i][j]=rgb[0];   //R
		    	gs[i][j]=rgb[1];   //G
		    	bs[i][j]=rgb[2];   //B
		}	
		}
		
	    int w=width;
	    int h=height;
        BufferedImage destImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    	int a=x;
    	
    	double c=1;
    	int d=20;
    	if(a==1)
    	{
		String[] ss = {"low threshold","middle threshold","high threshold"}; 
		int response=JOptionPane.showOptionDialog(null, "Please select the edge detection threshold", "edge detection",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, ss,ss[0]);		
		if(response==0) 
			   d=50;
		if(response==1)
		       d=100;   
		if(response==2)
			   d=150; 
        }    	
    	    	
    	if(a==2)
    	{
		String[] ss = {"low sharpen","middle sharpen","high sharpen"}; 

		int response=JOptionPane.showOptionDialog(null, "Please select the sharpening level", "sharpening ",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, ss,ss[0]);		
		if(response==0) 
			   c=0.2;
		if(response==1)
		       c=0.5;   
		if(response==2)
			   c=1; 
        }
    	
		int r1,g1,b1; 
		for (int j = 0; j < h; j++) {
			for(int i=0; i<w; i++) {	
				if(i==0||j==0||i==w-1||j==h-1)
				{   
				    rgb[0]=0;
				    rgb[1]=0;
				    rgb[2]=0;
				}
				else{
					r1=Math.abs((rs[i+1][j+1]-rs[i][j])+Math.abs(rs[i+1][j]-rs[i][j+1]));
					g1=Math.abs((rs[i+1][j+1]-rs[i][j])+Math.abs(rs[i+1][j]-rs[i][j+1]));
					b1=Math.abs((rs[i+1][j+1]-rs[i][j])+Math.abs(rs[i+1][j]-rs[i][j+1]));
					
					if(a==1){
					  if(r1>=d&&g1>=d&&b1>=d){	
					    rgb[0]=255;
					    rgb[1]=255;
					    rgb[2]=255;
					  }
					  else{
						rgb[0]=0;
					    rgb[1]=0;
					    rgb[2]=0;						  
					  }
					}
					if(a==2){
					   //rgb[0]=r1;  
					   //rgb[1]=g1;  
					   //rgb[2]=b1;	
					rgb[0]=(int)(rs[i][j]+c*r1);  
					rgb[1]=(int)(gs[i][j]+c*g1);  
					rgb[2]=(int)(bs[i][j]+c*b1);
					}
					for (int aa=0;aa<=2;aa++){
					if (rgb[aa]<0)          
					   rgb[aa]=0;
					else if (rgb[aa]>255)   
					   rgb[aa]=255;
					}										
				}				
		    	destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));
			}	
		}	
		return destImage;	
	}
}