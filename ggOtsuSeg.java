import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class ggOtsuSeg {
    public static BufferedImage image_otsu(BufferedImage srcImage) {
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
	    for(int i=0; i<ih-1; i++){
	    	for(int j=0; j<iw-1; j++){
	    		int grey=(rs[i][j]*299+gs[i][j]*587+bs[i][j]*114+500)/1000; 		
	    		 greynum[grey]++;   
	    		}
	    	}

	    double[] greyp=new double[256];
	    for(int i=0;i<256;i++){
	    	greyp[i]=doubleDivision(greynum[i],wh);    
	    	}
	    double[] otsu=new double[256];
	    for(int t=0;t<256;t++){
	    	double w0=0,w1=0,u0=0,u1=0;
	    	for(int i=0;i<t+1;i++){
	    		w0=w0+greyp[i]; 
	    	}
	    	w1=1-w0;  
	    	for(int i=0;i<t+1;i++){
	    		u0=u0+i*greyp[i]/w0;
	    	}
	    	for(int i=t;i<256;i++){
	    		u1=u1+i*greyp[i]/w1;
	    	}
	    	otsu[t]=w0*w1*(u0-u1)*(u0-u1);
	    	if(Double.isNaN(otsu[t])) otsu[t]=0;	
	    }
	    
	    double temp=otsu[0];
	    int bestT=0;
	    for(int i=0;i<256;i++){
	    	//System.out.println("otsu[i]= "+i+"=   "+otsu[i]);
	    	if(temp<otsu[i]){
	    		temp=otsu[i];    		
	    		bestT=i;
	    	}	
	    }

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
		           //r1=(rs[i+1][j]+rs[i-1][j]+rs[i][j+1]+rs[i][j-1]+rs[i][j])/5;
		           //g1=(gs[i+1][j]+gs[i-1][j]+gs[i][j+1]+gs[i][j-1]+gs[i][j])/5;
		           //b1=(bs[i+1][j]+bs[i-1][j]+bs[i][j+1]+bs[i][j-1]+bs[i][j])/5;
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
  
     public static double doubleDivision(double a,double b) {
      DecimalFormat dd=new DecimalFormat("0.0000000000000000");
       return Double.valueOf(dd.format((double)a/b));   
     }
 }