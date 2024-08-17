import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class bbTranslate {
	public static BufferedImage image_translate(BufferedImage srcImage,int x,int y) {
		int width = srcImage.getWidth();
		int height = srcImage.getHeight();
		int srcRGBs[] = srcImage.getRGB(0, 0, width, height, null, 0, width);
		//BufferedImage destImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int rgb[]=new int[3];
		int rs[][]=new int[width][ height];
		int gs[][]=new int[width][ height];
		int bs[][]=new int[width][ height];
		
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
		BufferedImage destImage = new BufferedImage(w+x, h+y, BufferedImage.TYPE_INT_RGB);
	
		
		
		rgb[0]=rgb[1]=rgb[2]=238;
		for (int j1 = 0; j1 < h+y; j1++) {
			for(int i=0; i<x; i++) {							
		    destImage.setRGB(i,j1, ImageColor.colorRGBtoINT(rgb));
			}
		}
		for (int j2 = 0; j2 < y; j2++) {
		    for(int i=0; i<w+x; i++) {
			destImage.setRGB(i,j2, ImageColor.colorRGBtoINT(rgb));
				}
		}
		    
        for (int j = 0; j < h; j++) {
			for(int i=0; i<w; i++) {
		    	/*try {
					ImageUtil.decodeColor(srcRGBs[j*width1+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(i);
				}
				*/
		    	
		    	ftemp=rs[i][j];   //R?
		    	rgb[0]=(int)(ftemp+0.5f);
		    	ftemp=gs[i][j];   //G?
		    	rgb[1]=(int)(ftemp+0.5f);
		    	ftemp=bs[i][j];   //B?
		    	rgb[2]=(int)(ftemp+0.5f);
		    	//if(rgb[0]==0&&rgb[1]==0&&rgb[2]==0){rgb[0]=rgb[1]=rgb[2]=100;}
		    	/*
		    	for(int d=0;d<y;d++){
		    		for(int c=0;c<w;c++){
		    			
		    		
		    		destImage.setRGB(c,d, ImageUtil.encodeColor(rgb));
		    	}
		    	}
		    	*/
		    	destImage.setRGB(i+x,j+y, ImageColor.colorRGBtoINT(rgb));
			}	
		}
     
		return destImage;
	}


	}
	
	
