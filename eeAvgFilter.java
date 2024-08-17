import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;
public class eeAvgFilter {
	   public static BufferedImage image_avgfilter(BufferedImage srcImage) {
	  		int width = srcImage.getWidth();
	  		int height = srcImage.getHeight();
	  		int srcRGBs[] = srcImage.getRGB(0, 0, width, height, null, 0, width);

	  		int rgb[]=new int[3];
	  		int rs[][]=new int[width][ height]; 
	  		int gs[][]=new int[width][ height];
	  		int bs[][]=new int[width][ height];

	  		String s=JOptionPane.showInputDialog("Please enter the filter parameters (3 or 5)");
	  		int n=Integer.parseInt(s);
	  		if(n!=3&&n!=5){ 
	  			JOptionPane.showMessageDialog( null,"The value entered is incorrect");
	  		}
	  		
	  		for(int j=0; j<height; j++) {
	  		    for (int i =0; i < width; i++) {
	  		    	ImageColor.colorINTtoRGB(srcRGBs[j* width+i],rgb); //rgb[0]=R,rgb[1]=G,rgb[2]
	 		    	rs[i][j]=rgb[0];   //R
	 		    	gs[i][j]=rgb[1];   //G
	  		    	bs[i][j]=rgb[2];   //b 		    	  		
	  		    }	
	  		}
	  	    int w=width;
	  	    int h=height; 
	  	    int ftemp=0;
	  	    
	        BufferedImage destImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	        for (int j = 0; j < h; j++) {
				for(int i=0; i<w; i++) {
				if(n==3){
                    if(i==0||j==0||i==w-1||j==h-1){
                    	rgb[0]=rs[i][j];    			   
    			    	rgb[1]=gs[i][j];
    			    	rgb[2]=bs[i][j];
                    }
                   
                    else{			    	
			    	ftemp=(rs[i-1][j-1]+rs[i][j-1]+rs[i+1][j-1]+rs[i-1][j]+rs[i+1][j]+rs[i-1][j+1]+rs[i][j+1]+rs[i+1][j+1])/8;   //R
			    	rgb[0]=(int)(ftemp+0.5f);
			    	//System.out.println("    "+rgb[0]);
			    	ftemp=(gs[i-1][j-1]+gs[i][j-1]+gs[i+1][j-1]+gs[i-1][j]+gs[i+1][j]+gs[i-1][j+1]+gs[i][j+1]+gs[i+1][j+1])/8;   //G
			    	rgb[1]=(int)(ftemp+0.5f);
			    	ftemp=(bs[i-1][j-1]+bs[i][j-1]+bs[i+1][j-1]+bs[i-1][j]+bs[i+1][j]+bs[i-1][j+1]+bs[i][j+1]+bs[i+1][j+1])/8;   //B
			    	rgb[2]=(int)(ftemp+0.5f);
                    }
                    
                }
				else {
					if(i==0||j==0||i==1||j==1||i==w-2||j==h-2||i==w-1||j==h-1){
                    		rgb[0]=rs[i][j];    			   
    			    	rgb[1]=gs[i][j];
    			    	rgb[2]=bs[i][j];
                    }
                    else{
			    	ftemp=( rs[i-2][j-2]+rs[i-1][j-2]+rs[i][j-2]+rs[i+1][j-2]+rs[i+2][j-2]
			    			+rs[i-2][j-1]+rs[i+2][j-1]+rs[i-2][j]+rs[i+2][j]+rs[i-2][j+1]+rs[i+2][j+1]							    			
			    			+rs[i-2][j+2]+rs[i-1][j+2]+rs[i][j+2]+rs[i+1][j+2]+rs[i+2][j+2]
			    			+rs[i-1][j-1]+rs[i][j-1]+rs[i+1][j-1]+rs[i-1][j]+rs[i+1][j]+rs[i-1][j+1]+rs[i][j+1]+rs[i+1][j+1] )/24;   //R
			    	rgb[0]=(int)(ftemp+0.5f);
			    	ftemp=( gs[i-2][j-2]+gs[i-1][j-2]+gs[i][j-2]+gs[i+1][j-2]+gs[i+2][j-2]
			    			+gs[i-2][j-1]+gs[i+2][j-1]+gs[i-2][j]+gs[i+2][j]+gs[i-2][j+1]+gs[i+2][j+1]							    			
			    			+gs[i-2][j+2]+gs[i-1][j+2]+gs[i][j+2]+gs[i+1][j+2]+gs[i+2][j+2]
			    			+gs[i-1][j-1]+gs[i][j-1]+gs[i+1][j-1]+gs[i-1][j]+gs[i+1][j]+gs[i-1][j+1]+gs[i][j+1]+gs[i+1][j+1] )/24;   //G
			    	rgb[1]=(int)(ftemp+0.5f);
			    	ftemp=( bs[i-2][j-2]+bs[i-1][j-2]+bs[i][j-2]+bs[i+1][j-2]+bs[i+2][j-2]
			    			+bs[i-2][j-1]+bs[i+2][j-1]+bs[i-2][j]+bs[i+2][j]+bs[i-2][j+1]+bs[i+2][j+1]							    			
			    			+bs[i-2][j+2]+bs[i-1][j+2]+bs[i][j+2]+bs[i+1][j+2]+bs[i+2][j+2]
			    			+bs[i-1][j-1]+bs[i][j-1]+bs[i+1][j-1]+bs[i-1][j]+bs[i+1][j]+bs[i-1][j+1]+bs[i][j+1]+bs[i+1][j+1] )/24;   //B
			    	rgb[2]=(int)(ftemp+0.5f);		    	
                    }
				}					
                    destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));
				}	
			}
	     
			return destImage;
		}


		}
		