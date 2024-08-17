import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
public class ggBestSeg {
	  public static BufferedImage image_bestseg(BufferedImage srcImage) {
			int iw = srcImage.getWidth();
			int ih = srcImage.getHeight();
			int wh=iw*ih;
			int srcRGBs[] = srcImage.getRGB(0, 0, iw, ih, null, 0, iw);
			int []pixels = new int[iw*ih];
	        BufferedImage destImage = new BufferedImage(iw, ih, BufferedImage.TYPE_INT_RGB);
	        BufferedImage tmp;
			
			int rgb[]=new int[3];
			int rs[][]=new int[iw*2][ ih*2];
			int gs[][]=new int[iw*2][ ih*2];
			int bs[][]=new int[iw*2][ ih*2];
			
			for(int j=0; j<ih; j++) {
			    for (int i = 0; i < iw; i++) {
			    	ImageColor.colorINTtoRGB(srcRGBs[j*iw+i],rgb); 
			    	rs[i][j]=rgb[0];   //R
			    	gs[i][j]=rgb[1];   //G
			    	bs[i][j]=rgb[2];   //B
			    }	
			}
			
		    int[] greynum= new int[256];	   
		    int gmax=0,gmin=255;
		    for(int i=0; i<ih-1; i++){
		    	for(int j=0; j<iw-1; j++){
		    		int grey=(rs[i][j]*299+gs[i][j]*587+bs[i][j]*114+500)/1000;	
		    		 greynum[grey]++;      
		    		 if(grey>gmax) gmax=grey;
		    		 if(grey<gmin) gmin=grey;
		    		}
		    	}

		    int t=0,s1=0,n1=0,s2=0,n2=0,t1=0,t2=0,bestT;
		    int newT=(gmax+gmin)/2;

		    for(int i=0;(t!=newT)&&i<100;i++){
		    		t=newT;
		    		for(int a=gmin;a<t;a++){
		    			s1=s1+greynum[a]*a;
		    			n1=n1+greynum[a];
		    		}
		    		t1=s1/n1;
		    		for(int a=t+1;a<gmax;a++){
		    			s2=s2+greynum[a]*a;
		    			n2=n2+greynum[a];
		    		}
		    		t2=s2/n2;
		    		newT=(t1+t2)/2;
		    }
		    bestT=newT;

		    int r1=0,g1=0,b1=0,grey=0;
		    for (int j = 0; j <ih; j++) {
				for(int i=0; i<iw; i++) {	
					if(i==0||j==0||i==iw-1||j==ih-1)
					{   
					    rgb[0]=0;
					    rgb[1]=0;
					    rgb[2]=0;
					}
					else{
		               r1=rs[i][j];
			           g1=gs[i][j];
			           b1=bs[i][j];
			           grey=(rs[i][j]*299+gs[i][j]*587+bs[i][j]*114+500)/1000;
			          // r1=(rs[i+1][j]+rs[i-1][j]+rs[i][j+1]+rs[i][j-1]+rs[i][j])/5;
			           //g1=(gs[i+1][j]+gs[i-1][j]+gs[i][j+1]+gs[i][j-1]+gs[i][j])/5;
			          // b1=(bs[i+1][j]+bs[i-1][j]+bs[i][j+1]+bs[i][j-1]+bs[i][j])/5;
					}
		            if(grey>=bestT){	
			           rgb[0]=255;
			           rgb[1]=255;
			           rgb[2]=255;
			           }
			        else{
				       rgb[0]=0;
			           rgb[1]=0;
			           rgb[2]=0;						  
			       }	
		           destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));	    
	            }
	        }
	         return destImage;
	     }
	 }