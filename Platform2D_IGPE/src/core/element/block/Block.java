package core.element.block;

public interface Block  {
	public abstract double getX();
	public abstract double getY();
	public abstract boolean collision(double x, double y,int height, int width);
}