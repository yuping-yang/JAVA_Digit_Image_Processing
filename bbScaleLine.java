import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class bbScaleLine {
	public static BufferedImage image_scaleline(BufferedImage srcImage,double p) {
		
				int width = srcImage.getWidth();
				int height = srcImage.getHeight();
				int srcRGBs[] = srcImage.getRGB(0, 0, width, height, null, 0, width);
				//BufferedImage destImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				
				int rgb[]=new int[3];
				int rs[][]=new int[width][ height];
				int gs[][]=new int[width][ height];
				int bs[][]=new int[width][ height];
				double x=p;
				int xx=(int)p;
				for(int j=0; j<height; j++) {
				    for (int i = 0; i < width; i++) {
				    	ImageColor.colorINTtoRGB(srcRGBs[j*width+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
				    	rs[i][j]=rgb[0];   //R?
				    	gs[i][j]=rgb[1];   //G?
				    	bs[i][j]=rgb[2];   //b?
				}	
				}
				
			  //  int width1 = image1.getWidth();
			//	int height1 = image1.getHeight();
			//	srcRGBs = image1.getRGB(0, 0, width1, height1, null, 0, width1);
				
				float ftemp;
			    float a=0.5f;
			    int w=width;
			    int h=height;
			//	if (width > width1) {w=width1;}
			//	if (height > height1){h=height1;}
			    int w1=(int)(x*w-1);
			    int h1=(int)(x*h-1);
			    if (x>=1){w1-=1;h1-=1;}
				BufferedImage destImage = new BufferedImage(w1, h1, BufferedImage.TYPE_INT_RGB);
   	        
for(int j=0; j<h1; j++) {
    for (int i = 0; i < w1; i++) {
    	int m=(int)(i/x);
    	int n=(int)(j/x);
    	double ux=i/x -m;
    	double uy=j/x -n;
    	if(m==width-1||n==height-1){
    		ImageColor.colorINTtoRGB(srcRGBs[n*width+m],rgb);
        destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));
    	}else{
    	ImageColor.colorINTtoRGB(srcRGBs[n*width+m],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
    	rs[m][n]=rgb[0];   //R
    	gs[m][n]=rgb[1];   //G
    	bs[m][n]=rgb[2];   //b
    	ImageColor.colorINTtoRGB(srcRGBs[n*width+(m+1)],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
    	rs[m+1][n]=rgb[0];   //R
    	gs[m+1][n]=rgb[1];   //G
    	bs[m+1][n]=rgb[2];   //b
    	ImageColor.colorINTtoRGB(srcRGBs[(n+1)*width+m],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
    	rs[m][n+1]=rgb[0];   //R
    	gs[m][n+1]=rgb[1];   //G
    	bs[m][n+1]=rgb[2];   //b
    	ImageColor.colorINTtoRGB(srcRGBs[(n+1)*width+m+1],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
    	rs[m+1][n+1]=rgb[0];   //R
    	gs[m+1][n+1]=rgb[1];   //G
    	bs[m+1][n+1]=rgb[2];   //b	
    	
    	double rs1=(1-ux)*rs[m][n]+ux*rs[m+1][n];
        double rs2=(1-ux)*rs[m][n+1]+ux*rs[m+1][n+1];
        double rs3=(1-uy)*rs1+uy*rs2;
        double gs1=(1-ux)*gs[m][n]+ux*gs[m+1][n];
        double gs2=(1-ux)*gs[m][n+1]+ux*gs[m+1][n+1];
        double gs3=(1-uy)*gs1+uy*gs2;
        double bs1=(1-ux)*bs[m][n]+ux*bs[m+1][n];
        double bs2=(1-ux)*bs[m][n+1]+ux*bs[m+1][n+1];
        double bs3=(1-uy)*bs1+uy*bs2;

    	rgb[0]=(int) rs3;
    	rgb[1]=(int) gs3;
    	rgb[2]=(int) bs3;

    	destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));	
    	}
    }
}     
				return destImage;
			}

}
			
			
