package org.github.youssefagagg.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine extends MyShape 
{
	private static final long serialVersionUID = 1L;
	public MyLine() 
	{
		super();
	}

	
	public MyLine(int X1,int Y1,int X2,int Y2,Color color,int sw) 
	{
		   super(X1, Y1, X2, Y2, color, sw);
		}
	public void draw (GraphicsContext g) 
	{
		g.setStroke(getColor());
		g.setLineWidth(getStrokeWidth());
		g.strokeLine(getXCoordinateFirstPoint(), getYCoordinateFirstPoint(), getXCoordinateSecondPoint(), getYCoordinateSecondPoint());
		
	}
	@Override
	public String toString() 
	{
		return "draw line";
	}

}

