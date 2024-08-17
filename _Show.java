
import java.awt.*;
import javax.swing.*;
 
public class _Show
{
	public static void main(String args[]) {
		Font font = new Font("Arial", Font.PLAIN, 16);
		UIManager.put("Button.font", font);
		UIManager.put("CheckBox.font", font);
		UIManager.put("RadioButton.font",font);
		UIManager.put("ToolTip.font", font);
		UIManager.put("ComboBox.font", font);
		UIManager.put("Label.font", font);
		UIManager.put("List.font", font);
		UIManager.put("Table.font", font);
		UIManager.put("TableHeader.font", font);
		UIManager.put("MenuBar.font", font);
		UIManager.put("Menu.font", font);
		UIManager.put("MenuItem.font", font);		
		UIManager.put("PopupMenu.font", font);
		UIManager.put("Tree.font", font);
		UIManager.put("ToolBar.font", font);	
		
	    _MainFrame mainFrame = new _MainFrame();
	    mainFrame.setTitle("Image processing system based on java");
        mainFrame.setSize(1000, 600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
	}
}
