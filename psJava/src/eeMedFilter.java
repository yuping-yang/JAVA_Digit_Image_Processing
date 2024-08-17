import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
public class eeMedFilter {
	   public static BufferedImage image_medfilter(BufferedImage srcImage,int a1) {
		    int a=a1;
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
	  		    	bs[i][j]=rgb[2];   //B  		    	  		
	  		    }	
	  		}
	  	    int w=width;
	  	    int h=height; 
	  	    int ftemp=0;
	  	    int r1[]=new int[n*n];
	  	    int g1[]=new int[n*n];
	  	    int b1[]=new int[n*n];
	  	    int nn=0;
	  	    int tt=0;
	        BufferedImage destImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	        for (int j = 0; j < h; j++) {
				for(int i=0; i<w; i++) {
                    nn=0;
                    if(i==0||j==0||i==1||j==1||i==w-2||j==h-2||i==w-1||j==h-1){
                    	rgb[0]=rs[i][j];    			   
    			    	rgb[1]=gs[i][j];
    			    	rgb[2]=bs[i][j];
                    }
                    else{
                    	
                    	for(int aa=i-(n-1)/2;aa<=i+(n-1)/2;aa++){
                    		for(int bb=j-(n-1)/2;bb<=j+(n-1)/2;bb++){
                    		r1[nn]=rs[aa][bb];
                    		g1[nn]=gs[aa][bb];
                    		b1[nn]=bs[aa][bb];
                    		nn++;
                    		//System.out.println(nn);
                    		}
                    	}
                    	for(int ii=0;ii<n*n-1;ii++){
                    		if(r1[ii+1]<r1[ii]){
                    			tt=r1[ii];
                    			r1[ii]=r1[ii+1];
                    			r1[ii+1]=tt;
                    		}
                    		if(g1[ii+1]<g1[ii]){
                    			tt=g1[ii];
                    			g1[ii]=g1[ii+1];
                    			g1[ii+1]=tt;
                    		}
                    		if(b1[ii+1]<b1[ii]){
                    			tt=b1[ii];
                    			b1[ii]=b1[ii+1];
                    			b1[ii+1]=tt;
                    		}                    		
                    	}

                    	if(a==1)
                    	{                   	
                    	ftemp=r1[(n*n+1)/2-1];
                    	rgb[0]=(int)(ftemp+0.5f);
                    	ftemp=g1[(n*n+1)/2-1];
                    	rgb[1]=(int)(ftemp+0.5f);
                    	ftemp=b1[(n*n+1)/2-1];
                    	rgb[2]=(int)(ftemp+0.5f);
                    	}
                    	
                    	if(a==2)
                    	{
                    	ftemp=r1[n*n-1];
                    	rgb[0]=(int)(ftemp+0.5f);
                    	ftemp=g1[n*n-1];
                    	rgb[1]=(int)(ftemp+0.5f);
                    	ftemp=b1[n*n-1];
                    	rgb[2]=(int)(ftemp+0.5f);
                    	}

                    	if(a==3)
                    	{
                    	ftemp=r1[0];
                    	rgb[0]=(int)(ftemp+0.5f);
                    	ftemp=g1[0];
                    	rgb[1]=(int)(ftemp+0.5f);
                    	ftemp=b1[0];
                    	rgb[2]=(int)(ftemp+0.5f);
                    	}

                    	if(a==4)
                    	{
                    	ftemp=(int)(0.5*(r1[0]+r1[n*n-1]));
                    	rgb[0]=(int)(ftemp+0.5f);
                    	ftemp=(int)(0.5*(g1[0]+g1[n*n-1]));
                    	rgb[1]=(int)(ftemp+0.5f);
                    	ftemp=(int)(0.5*(b1[0]+b1[n*n-1]));
                    	rgb[2]=(int)(ftemp+0.5f);
                    	}
                                 	
                    }
                				
                    destImage.setRGB(i,j, ImageColor.colorRGBtoINT(rgb));
				}	
			}
	     
			return destImage;
		}


		}
		