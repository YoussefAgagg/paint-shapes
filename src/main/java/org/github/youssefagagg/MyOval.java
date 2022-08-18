package org.github.youssefagagg;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class MyOval extends MyPoundedShape 
{
	private static final long serialVersionUID = 1L;

	
	public MyOval() 
	{
		super();
	}
	public MyOval(int X1,int Y1,int X2,int Y2,Color color,int sw,boolean f ) 
	{
		   super(X1, Y1, X2, Y2, color, sw,f);
		}
	
	@Override
	public void draw(GraphicsContext g) 
	{
		
		if(getIsFilled()) {
			g.setFill(getColor());
		g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHight());
		}
		else {
			g.setStroke(getColor());
			g.setLineWidth(getStrokeWidth());
			g.strokeOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHight());
		}
		

}
	@Override
	public String toString() 
	{
		return "draw oval";
	}
}