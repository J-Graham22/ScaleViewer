package src;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class ScaleView extends JFrame {
	private JLabel root = new JLabel("Root Note:");
	private JLabel scalePattern = new JLabel("Scale:");
	private JButton showScale = new JButton("Get my scale");
	private Color black = new Color(0,0,0);
	private Color white = new Color(255,255,255);
	private Color lightGrey = new Color(200, 200, 200);
	private Color darkGrey = new Color(100, 100, 100);
	private JCheckBox dark = new JCheckBox("Dark Theme");
	
	String[] notes = {"A", "A#/Bb", "B", "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab" };
	private JComboBox noteList = new JComboBox(notes);
	
	String[] scales = {
		"Major/Ionian (I)",
		"Natural Minor",
		"Melodic Minor",
		"Harmonic Minor",
		"Dorian (II)",
		"Phrygian (III)",
		"Lydian (IV)",
		"Mixolydian (V)",
		"Aeolian (VI)",
		"Locrian (VII)",
		"Major Pentatonic",
		"Minor Pentatonic"
	};
	private JComboBox scaleList = new JComboBox(scales);
	
	private JLabel resultLabel = new JLabel();
	
	ScaleView() {
		JPanel scalePanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 300);
		this.setResizable(false);
		scalePanel.setLayout(null);
		scalePanel.setBackground(white);
		
		
		root.setSize(70, 25);
		root.setLocation(100, 25);
		root.setForeground(black);
		scalePanel.add(root);
		
		noteList.setSelectedIndex(0);
		noteList.setSize(70, 25);
		noteList.setLocation(200, 25);
		noteList.setBackground(lightGrey);
		noteList.setForeground(black);
		scalePanel.add(noteList);
		
		scalePattern.setSize(70, 25);
		scalePattern.setLocation(315, 25);
		scalePattern.setForeground(black);
		scalePanel.add(scalePattern);
		
		scaleList.setSelectedIndex(0);
		scaleList.setSize(120, 25);
		scaleList.setLocation(375, 25);
		scaleList.setBackground(lightGrey);
		scaleList.setForeground(black);
		scalePanel.add(scaleList);
		
		showScale.setSize(120, 25);
		showScale.setLocation(725, 25);
		showScale.setBackground(lightGrey);
		showScale.setForeground(black);
		scalePanel.add(showScale);
		
		resultLabel.setFont(resultLabel.getFont().deriveFont(24.0f));
		resultLabel.setSize(800, 25);
		resultLabel.setLocation(100, 100);
		resultLabel.setForeground(black);
		scalePanel.add(resultLabel);
		
		dark.setForeground(black);
		dark.setBackground(lightGrey);
		dark.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					scalePanel.setBackground(black);
					
					root.setForeground(white);
					
					noteList.setBackground(darkGrey);
					noteList.setForeground(white);
					
					scalePattern.setForeground(white);
					
					scaleList.setBackground(darkGrey);
					scaleList.setForeground(white);
					
					showScale.setBackground(darkGrey);
					showScale.setForeground(white);
					
					resultLabel.setLocation(100, 100);
					resultLabel.setForeground(white);
					
					dark.setForeground(white);
					dark.setBackground(darkGrey);
				} else {
					scalePanel.setBackground(white);
					
					root.setForeground(black);
					
					noteList.setBackground(lightGrey);
					noteList.setForeground(black);
					
					scalePattern.setForeground(black);
					
					scaleList.setBackground(lightGrey);
					scaleList.setForeground(black);
					
					showScale.setBackground(lightGrey);
					showScale.setForeground(black);
					
					resultLabel.setLocation(100, 100);
					resultLabel.setForeground(black);
					
					dark.setForeground(black);
					dark.setBackground(lightGrey);
				}
			}
		});
		
		dark.setSize(120, 25);
		dark.setLocation(725, 200);
		scalePanel.add(dark);
		
		this.add(scalePanel);
	}
	
	public String getRootNote() {
		return noteList.getSelectedItem().toString();
	}
	
	public String getScale() {
		return scaleList.getSelectedItem().toString();
	}
	
	public void displayScale(ArrayList<String> pattern) {
		//implement later
		StringBuilder result = new StringBuilder(50);
		
		for(int i=0; i < pattern.size()-1; i++) {
			result.append(pattern.get(i));
			
			if(i != pattern.size()-2) {
				result.append("   -   ");
			}
		}
		
		resultLabel.setText(result.toString());
	}
	
	void addScaleListener(ActionListener listenForShowScale) {
		showScale.addActionListener(listenForShowScale);
	}
	
}
