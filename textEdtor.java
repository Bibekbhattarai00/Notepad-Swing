package advJava;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class textEdtor implements ActionListener {
	JFrame f1;
	JMenuBar mbar;
	JMenu menu1;
	JMenuItem mi1, mi2, mi3;
	JTextArea t1;

	textEdtor() {
		f1 = new JFrame();
		f1.setSize(400, 400);
		f1.setLayout(new BorderLayout());
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t1 = new JTextArea();
		t1.setLineWrap(true);
		JScrollPane jp = new JScrollPane(t1);
		f1.add(jp);
		mbar = new JMenuBar();
		menu1 = new JMenu("file");
		mi1 = new JMenuItem("open");
		mi2 = new JMenuItem("save");
		mi3 = new JMenuItem("exit");
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		menu1.add(mi1);
		menu1.add(mi2);
		menu1.add(mi3);
		mbar.add(menu1);
		f1.setJMenuBar(mbar);
		f1.setVisible(true);

	}

	public static void main(String args[]) {
		textEdtor t1 = new textEdtor();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mi3) {
			System.exit(0);
		} else if (e.getSource() == mi1) {
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(f1);
		} else if (e.getSource() == mi2) {
			JFileChooser jfc = new JFileChooser();
			jfc.showSaveDialog(f1);
			String filename = jfc.getSelectedFile() + "";
			String content = t1.getText();
			try {
				FileWriter fw = new FileWriter(filename);
				fw.write(content);
				fw.close();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else if (e.getSource() == mi1) {
			JFileChooser jfc = new JFileChooser();
			jfc.showSaveDialog(f1);
			String filename = jfc.getSelectedFile() + "";
			String content = t1.getText();
			try {
				FileReader fr = new FileReader(filename);
				String Content="";
				int ch;
				while((ch=fr.read())!=-1){
					Content+=ch;
				}
				t1.setText(Content);
				fr.close();
				
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}
}