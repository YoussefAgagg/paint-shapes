package org.github.youssefagagg.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyRectangel extends MyPoundedShape 
{
	private static final long serialVersionUID = 1L;

	
	public MyRectangel() 
	{
		super();

	}
	public MyRectangel(int X1,int Y1,int X2,int Y2,Color color,int sw,boolean f ) 
	{
	   super(X1, Y1, X2, Y2, color, sw,f);
	}
	
	
	public void draw(GraphicsContext g) 
	{
		
		if(getIsFilled()) {
			g.setFill(getColor());
		g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHight());
		}
		else {
			g.setStroke(getColor());
			g.setLineWidth(getStrokeWidth());
			g.strokeRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHight());
		}
	}
	@Override
	public String toString() 
	{
		return "draw rectangel";
	}

}

