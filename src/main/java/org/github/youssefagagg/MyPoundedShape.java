package org.github.youssefagagg;




import javafx.scene.paint.Color;

public abstract class MyPoundedShape extends MyShape
{
	//private boolean fill;//determine whether the shape is filled
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyPoundedShape() 
	{
		super();
		
		
	}
	public MyPoundedShape(int X1,int Y1,int X2,int Y2,Color color,int sw,boolean f ) 
	{
		   super(X1, Y1, X2, Y2, color, sw,f);
		}

	
	
	public int getUpperLeftX() 
	{
		int x1=getXCoordinateFirstPoint();
		int x2=getXCoordinateSecondPoint();
		if(x1<x2)
			return x1;
		else
			return x2;
	}
	
	public int getUpperLeftY() 
	{
		int y1=getYCoordinateFirstPoint();
		int y2=getYCoordinateSecondPoint();
		if(y1<y2)
			return y1;
		else
			return y2;
	}
	
	public int getWidth() 
	{
		return Math.abs((getXCoordinateFirstPoint()-getXCoordinateSecondPoint()));
	}
	
	public int getHight() 
	{
		return Math.abs((getYCoordinateFirstPoint()-getYCoordinateSecondPoint()));
	}

}

