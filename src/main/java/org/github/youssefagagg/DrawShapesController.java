package org.github.youssefagagg;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DrawShapesController {

	
	@FXML
    private ListView<MyShape> shapeList;

    @FXML
    private CheckBox fillCheckBox;

    @FXML
    private ColorPicker colorButton;

    @FXML
    private Button undoButton;

    @FXML
    private Button clearButton;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ChoiceBox<Integer> sizeChoicBox;

    @FXML
    private Canvas canvas;
    
	private MyShape [] shapes=new MyShape[100];
	private int countShapes; //Number of shape to draw 
	private MyShape currentShape ;//the shape is current drawing 

	private final ObservableList<MyShape>thelist =FXCollections.observableArrayList();
	private final ObservableList<Integer>listnumber =FXCollections.observableArrayList();
    public void initialize() 
    {
    	thelist.add(new MyLine());
    	thelist.add(new MyRectangel());
    	thelist.add(new MyOval());
    	thelist.add(new FreePaint());
    	shapeList.setItems(thelist);
    	shapeList.getSelectionModel().select(0);
    	
    	
    	
    	for(int i=1;i<17;i++) 
    	{
    		listnumber.add(i);
    	}
    	sizeChoicBox.setItems(listnumber);
    	sizeChoicBox.setValue(1);
    	colorButton.getStyleClass().add("button");
    	
    	colorButton.setValue(Color.BLACK);
    	
    	
    }

    @FXML
    void canvasMouseDragged(MouseEvent event) {
    	currentShape.setXCoordinateSecondPoint((int) event.getX());
    	currentShape.setYCoordinateSecondPoint((int) event.getY());
    	paint();

    }
    @FXML
    private void redraw() {
      
      GraphicsContext gc=canvas.getGraphicsContext2D();
      //gc.clearRect(0, 0, w, h);
      gc.beginPath();
      //gc.rect(10, 10, w-20, h-20);
      gc.stroke();
      paint();
    }

    @FXML
    void canvasMousePressed(MouseEvent event) {
    	int x=shapeList.getSelectionModel().getSelectedIndex();
    	switch(x) 
    	{
    	case 0:currentShape=new MyLine((int) event.getX(),(int) event.getY(),(int) event.getX(),(int) event.getY(),colorButton.getValue(),sizeChoicBox.getSelectionModel().getSelectedItem());
    	break;
    	case 1:currentShape=new  MyRectangel((int) event.getX(),(int) event.getY(),(int) event.getX(),(int) event.getY(),colorButton.getValue(),sizeChoicBox.getSelectionModel().getSelectedItem(),fillCheckBox.isSelected());
    	break;
    	case 2:currentShape=new MyOval((int) event.getX(),(int) event.getY(),(int) event.getX(),(int) event.getY(),colorButton.getValue(),sizeChoicBox.getSelectionModel().getSelectedItem(),fillCheckBox.isSelected());
    	break;
    	case 3:currentShape=new FreePaint((int) event.getX(),(int) event.getY(),(int) event.getX(),(int) event.getY(),colorButton.getValue(),sizeChoicBox.getSelectionModel().getSelectedItem());
    	break;
    	}
    	
    	
    	

    }

    @FXML
    void canvasMouseReleased(MouseEvent event) {
    	currentShape.setXCoordinateSecondPoint((int) event.getX());
    	currentShape.setYCoordinateSecondPoint((int) event.getY());
    	shapes[countShapes++]=currentShape;
    	
    	currentShape=null;
    	paint();

    }

   

  

   
    @FXML
    void undoButtonPressed(ActionEvent event) {
    	if(countShapes!=0)
    	countShapes--;
    	paint();

    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	countShapes=0;
    	paint();
    	

    }

    

	private void paint() {
		// TODO Auto-generated method stub
		GraphicsContext gc=canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		for(int i=0;i<countShapes;i++)
		{
			shapes[i].draw(gc);
		}
		if(currentShape!=null)
		currentShape.draw(gc);
		
	}

}

