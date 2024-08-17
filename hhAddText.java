import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class hhAddText {
	public static BufferedImage addText(BufferedImage srcImage,int textfont,int textBorI,int textsize,int  textcolor,String str,int x,int y) throws IOException {
        BufferedImage image;
        image=srcImage;
        String words=str;
              
        int tBorI=Font.BOLD;
        int tsize=16;
        String tfont="Arial";
        Color color=new Color(0,0,0);
        Font font = new Font(tfont, tBorI, 30);
     
        switch(textfont){
        case 0:tfont="Arial";break;
        case 1:tfont="Calibri";break;
        case 2:tfont="Consolas";break;
        case 3:tfont="Cambria";break;
        }
        switch(textBorI){
        case 0:tBorI=Font.PLAIN;break;
        case 1:tBorI=Font.BOLD;break;
        case 2:tBorI=Font.ITALIC;break;
        case 4:tBorI=Font.BOLD+Font.ITALIC;break;
        }
        switch(textsize){
        case 0:tsize=12;break;
        case 1:tsize=16;break;
        case 2:tsize=20;break;
        case 3:tsize=30;break;
        }
        switch(textcolor){
        case 0:color=Color.RED;break;
        case 1:color=Color.ORANGE;break;
        case 2:color=Color.YELLOW;break;
        case 3:color=Color.GREEN;break;
        case 4:color=Color.BLUE;break;
        case 5:color=Color.WHITE;break;
        case 6:color=Color.GRAY;break;
        case 7:color=Color.BLACK;break;
        }
       // font=new Font(tfont,Font.PLAIN,tsize);//Font.BOLD+Font.ITALIC
        font=new Font(tfont,tBorI,tsize);//Font.BOLD+Font.ITALIC
       // System.out.println("tfont,tBorI,tsize   "+tfont+"     tBorI: "+tBorI+"    tsize: "+tsize+"    color: "+color);
        return markImgMark(image,words,font,color,x,y);
	}
	
	/**
	 * @param watermarkUrl 
	 * @param source 
	 * @param output
	 * @return
	 * @throws IOException
	 * 
	 * 
	 * 
     */
	public static BufferedImage markImgMark(BufferedImage srcImage,String str, Font f,Color c,int xx,int yy) throws IOException {
		String words=str;
		Font font=f;
		Color color = c;
		int x=20,y=40;
		x=xx;
		y=yy;
		int width = srcImage.getWidth(null);
		int height = srcImage.getHeight(null);
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
		//ImageIcon imgIcon = new ImageIcon(watermarkPic);
		//Image con = imgIcon.getImage();
		float clarity = 0.6f;
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, clarity));
		//g.drawImage(con, 10, 10, null);
	    	g.setFont(font);
	    	g.setColor(color);
		g.drawString(words, x, y);
		//g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
		g.dispose();
		//File sf = new File(output);
		//ImageIO.write(bi, "jpg", sf); 
		//System.out.println("watermask has been added");
		//return result;
		return image;
	} 
}
