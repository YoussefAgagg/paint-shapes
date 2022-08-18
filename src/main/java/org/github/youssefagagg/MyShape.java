package org.github.youssefagagg;




import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.io.Serializable;


public abstract class MyShape implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x1;       // x-coordinate of first 
	private int x2;      // x-coordinate of second 
	private int y1;      // y-coordinate of first 
	private int y2;       // x-coordinate of first 
	private Color myColor; //color of the rectangle
	private int strokeWidth;
	private boolean fill;

	
	public MyShape() 
	{
		
		this(0,0,0,0,Color.BLACK,1,false);
				
	}
	public MyShape(int X1,int Y1,int X2,int Y2,Color color,int sw)
	{
		this(X1,Y1,X2,Y2,color,sw,false);
	}
	public MyShape(int X1,int Y1,int X2,int Y2,Color color,int sw,boolean f)
	{
		x1=X1;
		x2=X2;
		y1=Y1;
		y2=Y2;
		myColor=color;
		strokeWidth=sw;
		fill=f;
	}
	 
	public int getStrokeWidth() {
		
		return strokeWidth;
	}
	
	public void setStrokeWidth(int sw) 
	{
		strokeWidth=sw;
		
	}
	
	public void setXCoordinateFirstPoint(int x) 
	{
		if(x>=0)
			x1=x;
		else
			x1=0;
	}
	public void setYCoordinateFirstPoint(int y) 
	{
		if(y>=0)
			y1=y;
		else
			y1=0;
	}
	
	public void setXCoordinateSecondPoint(int x) 
	{
		if(x>=0)
			x2=x;
		else
			x2=0;
	}
	
	public void setYCoordinateSecondPoint(int y) 
	{
		if(y>=0)
			y2=y;
		else
			y2=0;
	}
	public void setColor(Color c)
	{
		myColor=c;
	}
	public void setIsFilled(boolean f) 
	{
		fill=f;
	}
	public boolean getIsFilled() 
	{
		return fill;
	}
	public int getXCoordinateFirstPoint() 
	{
		return x1;
	}
	public int getYCoordinateFirstPoint() 
	{
		return y1;
	}
	public int getXCoordinateSecondPoint() 
	{
		return x2;
	}
	public int getYCoordinateSecondPoint() 
	{
		return y2;
	}
	public Color getColor() 
	{
		return myColor;
	}
	public abstract void draw(GraphicsContext gc);
	

	
	

}
