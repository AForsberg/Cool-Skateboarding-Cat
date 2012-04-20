public class Vector {

	private double length;
	private double angle;

	public Vector(double length, double angle) {
		this.length = Math.abs(length);
		this.angle = angle;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getComposX() {
		return Math.cos(angle) * length;
	}

	public double getComposY() {
		return Math.sin(angle) * length;
	}

	public String toString() {
		return length + " - " + getDegrees();
	}

	public double getDegrees() {
		return (180 * angle) / Math.PI;
	}

	public Vector addVector(Vector v) {
		double xtot = getComposX() + v.getComposX();
		double ytot = getComposY() + v.getComposY();
		double length = Math.sqrt(xtot * xtot + ytot * ytot);

		return new Vector(length, Math.atan(ytot / xtot));

	}

}
