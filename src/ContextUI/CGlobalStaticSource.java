package ContextUI;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;


public class CGlobalStaticSource {
	public static final String endl_str = System.getProperty("line.separator");
	
	public static void set_ui_font (FontUIResource f){
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get (key);
			if (value != null && value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put (key, f);
		}
	}
	
	public static void init_font(){
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("yahei_consolas.ttf")).deriveFont(16f);
			set_ui_font(new FontUIResource(font));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void cout(String in_str){
		System.out.print(in_str);
	}
	
	public static void cout_endl(String in_str){
		System.out.println(in_str);
	}
	
	public static void cerr(String in_str){
		System.err.print(in_str);
	}
	
	public static void cerr_endl(String in_str){
		System.err.println(in_str);
	}
	
	public static String int_to_str(int in_value){
		Integer temp = new Integer(in_value);
		return temp.toString();
	}
}
