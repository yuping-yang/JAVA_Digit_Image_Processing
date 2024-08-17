
import java.awt.image.BufferedImage;

import javax.imageio.*;
import javax.swing.JOptionPane;

import java.io.*;

public class bbRotate {
	public static BufferedImage image_rotate(BufferedImage srcImage,int o) {
		//JOptionPane.showInternalInputDialog(button,"Message");

				int width = srcImage.getWidth();
				int height = srcImage.getHeight();
				int srcRGBs[] = srcImage.getRGB(0, 0, width, height, null, 0, width);
				//BufferedImage destImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				
				int rgb[]=new int[3];
				int rs[][]=new int[width][ height]; //
				int gs[][]=new int[width][ height];
				int bs[][]=new int[width][ height];
         	    double oo = Math.toRadians(o);  
       		    double sin=Math.sin(oo);    
         	    double cos=Math.cos(oo);             
       		
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
			    //int x[]=new int[w+2];
			    //int y[]=new int[h+2];
			    int x=0;
			    int y=0;
			//	if (width > width1) {w=width1;}
			//	if (height > height1){h=height1;}
				BufferedImage destImage = new BufferedImage((int)(1.5*w), (int)(1.5*h), BufferedImage.TYPE_INT_RGB);
				for (int j = 0; j < 1.5*h; j++) {
			        	for(int i=0; i< 1.5*w; i++) {
				            rgb[0]=238;//R 
				    	    rgb[1]=238;//G
				    	    rgb[2]=238;//B
			        		destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));
						}		        	
				  }
				  
		        for (int j = 0; j < h; j++) {
		        	for(int i=0; i<w; i++) {
		        	//x[i]=(int) ((i-w/2)*cos-(j-h/2)*sin+w/2);
		        	//y[i]=(int) ((i-w/2)*sin+(j-h/2)*cos+h/2);	
		        		x=(int) ((i-w/2)*cos-(j-h/2)*sin+w/2);
			        	y=(int) ((i-w/2)*sin+(j-h/2)*cos+h/2);		        		
		        		
				    	ftemp=rs[i][j];   //R
				    	rgb[0]=(int)(ftemp+0.5f);
				    	ftemp=gs[i][j];   //G
				    	rgb[1]=(int)(ftemp+0.5f);
				    	ftemp=bs[i][j];   //B
				    	rgb[2]=(int)(ftemp+0.5f);
                        //System.out.println(i+"###"+x[i]+"###"+j+"###"+y[j]+"########");
			// System.out.println(i+"###"+x+"###"+j+"###"+y+"########");
                        //destImage.setRGB(x[i],y[i], ImageUtil.encodeColor(rgb));
                      destImage.setRGB(x+w/4,y+h/4, ImageColor.colorRGBtoINT(rgb));

					}		        	
				}
		     
				return destImage;
			}

			}
			
			
