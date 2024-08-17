import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;
import java.lang.Math.*;

public class ccEnforceLog {
	public static BufferedImage image_enforcelog(BufferedImage srcImage) {
		
				int width = srcImage.getWidth();
				int height = srcImage.getHeight();
				int srcRGBs[] = srcImage.getRGB(0, 0, width, height, null, 0, width);
				int rgb[]=new int[3];
				int rs[][]=new int[width][ height]; //
				int gs[][]=new int[width][ height];
				int bs[][]=new int[width][ height];
				double t=0;
				double c=50;
				for(int j=0; j<height; j++) {
				    for (int i = 0; i < width; i++) {
				    	ImageColor.colorINTtoRGB(srcRGBs[j*width+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
				    	rs[i][j]=rgb[0];   //R?
				    	gs[i][j]=rgb[1];   //G?
				    	bs[i][j]=rgb[2];   //b?
				}	
				}
				double ftemp;
			    float a=0.5f;
			    int w=width;
			    int h=height;
				BufferedImage destImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		        for (int j = 0; j < h; j++) {

		        	for(int i=0; i<w; i++) {			    	
				    	ftemp=rs[i][j];   //R
				    	t=c*Math.log(1+Math.abs(ftemp));

				    	rgb[0]=(int)(t);
				    	
				    	ftemp=gs[i][j];   //G
				    	t=c*Math.log(1+Math.abs(ftemp));
				    	//System.out.println(t+"xxxxx"+ftemp);
				    	rgb[1]=(int)(t);
				    	
				    	ftemp=bs[i][j];   //B
				    	t=c*Math.log(1+Math.abs(ftemp));
				    	//System.out.println(t+"xxxxx"+ftemp);
				    	rgb[2]=(int)(t);
				    	
				    	destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));				
					}		        	
				}		     
				return destImage;
			}
			}
			
			
