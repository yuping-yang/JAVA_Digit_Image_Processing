import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class aaEditImage {
	
	public static BufferedImage image_add(BufferedImage srcImage,BufferedImage image1,double q) {
		int width = srcImage.getWidth();
		int height = srcImage.getHeight();
		int srcRGBs[] = srcImage.getRGB(0, 0, width, height, null, 0, width);
		//BufferedImage destImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		int rgb[]=new int[3];
		int rs[][]=new int[width][ height]; //
		int gs[][]=new int[width][ height];
		int bs[][]=new int[width][ height];
		
		for(int j=0; j<height; j++) {
		    for (int i = 0; i < width; i++) {
		    	ImageColor.colorINTtoRGB(srcRGBs[j*width+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
		    	rs[i][j]=rgb[0];   //R
		    	gs[i][j]=rgb[1];   //G
		    	bs[i][j]=rgb[2];   //B
		}	
		}
		
	    int width1 = image1.getWidth();
		int height1 = image1.getHeight();
		srcRGBs = image1.getRGB(0, 0, width1, height1, null, 0, width1);
		
		float ftemp;
	    float a=(float)q;
	    int w=width;
	    int h=height;
	    	  
		if (width > width1) {w=width1;}
		if (height > height1){h=height1;}
		BufferedImage destImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		
        for (int j = 0; j < h; j++) {
			for(int i=0; i<w; i++) {
		    	try {
					ImageColor.colorINTtoRGB(srcRGBs[j*width1+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(i);
				}
		    	ftemp=rs[i][j]*a+ rgb[0]*(1-a);   //R
		    	rgb[0]=(int)(ftemp+0.5f);
		    	ftemp=gs[i][j]*a+ rgb[1]*(1-a);   //G
		    	rgb[1]=(int)(ftemp+0.5f);
		    	ftemp=bs[i][j]*a+ rgb[2]*(1-a);   //Bֵ
		    	rgb[2]=(int)(ftemp+0.5f);
		    	destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));
			}	
		}
     
		return destImage;
	}
	
	
}
