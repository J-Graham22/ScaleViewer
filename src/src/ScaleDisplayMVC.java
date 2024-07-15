package src;

public class ScaleDisplayMVC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScaleView view = new ScaleView();
		ScaleModel model = new ScaleModel();
		
		ScaleController controller = new ScaleController(view, model);
		
		view.setVisible(true);
	}

}