package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScaleController {
	
	private ScaleView view;
	private ScaleModel model;
	
	public ScaleController(ScaleView view, ScaleModel model) {
		this.view=view;
		this.model=model;
		
		this.view.addScaleListener(new ScaleListener());
	}
	
	class ScaleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String rootNote;
			String scale;
			
			rootNote = view.getRootNote();
			scale = view.getScale();
			
			String scalePattern = "WWHWWWH";
			
			switch(scale) {
				case "Major/Ionian (I)":
					scalePattern = "WWHWWWH";
					break;
				case "Natural Minor":
					scalePattern = "WHWWHWW";
					break;
				case "Melodic Minor":
					scalePattern = "WHWWWWH";
					break;
				case "Harmonic Minor":
					scalePattern = "WHWWHTH";
					break;
				case "Dorian (II)":
					scalePattern = "WHWWWHW";
					break;
				case "Phrygian (III)":
					scalePattern = "HWWWHWW";
					break;
				case "Lydian (IV)":
					scalePattern = "WWWHWWH";
					break;
				case "Mixolydian (V)":
					scalePattern = "WWHWWHW";
					break;
				case "Aeolian (VI)":
					scalePattern = "WHWWHWW";
					break;
				case "Locrian (VII)":
					scalePattern = "HWWHWWW";
					break;
				case "Major Pentatonic":
					scalePattern = "WWTWT";
					break;
				case "Minor Pentatonic":
					scalePattern = "TWWTW";
					break;
			}
			
			view.displayScale(model.parsePattern(rootNote, scalePattern));
			
		}
		
	}
}
