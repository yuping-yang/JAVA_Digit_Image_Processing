import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class ccEnforce {
	public static BufferedImage image_enforce(BufferedImage srcImage) {
		
				int width = srcImage.getWidth();
				int height = srcImage.getHeight();
				int srcRGBs[] = srcImage.getRGB(0, 0, width, height, null, 0, width);
				int max=0;
				int min=0;
				int rgb[]=new int[3];
				int rs[][]=new int[width][ height]; //
				int gs[][]=new int[width][ height];
				int bs[][]=new int[width][ height];

				for(int j=0; j<height; j++) {
				    for (int i = 0; i < width; i++) {
				    	ImageColor.colorINTtoRGB(srcRGBs[j*width+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
				    	rs[i][j]=rgb[0];   //R?
				    	gs[i][j]=rgb[1];   //G?
				    	bs[i][j]=rgb[2];   //b?
				    	if (max<rs[i][j])max=rs[i][j];
				    	if (min>rs[i][j])min=rs[i][j];
				}	
				}

				System.out.println("max"+max+"min"+min);
				double ftemp;
			    float a=0.5f;
			    int w=width;
			    int h=height;
			    double aa=255*100/(max-min)*0.01;			   
			    double bb=-min*255*100/(max-min)*0.01;

			    System.out.println("aa"+aa+"bb"+bb);
				BufferedImage destImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		        for (int j = 0; j <h; j++) {

		        	for(int i=0; i < w; i++) {
				    	/*try {
							ImageUtil.decodeColor(srcRGBs[j*width1+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]=B
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println(i);
						}
						*/
				    	ftemp=aa*rs[i][j]+bb;   //R?
				    	rgb[0]=(int)(ftemp+0.5f);
				    	ftemp=aa*gs[i][j]+bb;   //G?
				    	rgb[1]=(int)(ftemp+0.5f);
				    	ftemp=aa*bs[i][j]+bb;   //B?
				    	rgb[2]=(int)(ftemp+0.5f);
				    	destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));

					}
 	
				}
		     
				return destImage;
			}

			}
			
			
