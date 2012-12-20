package gdmachado.Inceptron;

public class MathUtils {
	public static Double dotProduct(final double[] a, final double[] b)
	{		
		double result = 0;
		try {			
			for (int i = 0; i < a.length; i++) result += a[i] * b[i];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.err.println("Number of inputs does not match the number of weights");
			System.exit(1);
		}
		return result;
	}
	
	public static double step(double x, double threshold)
	{
		return x > threshold ? 1 : 0;
	}
	
	public static double sigmoid(double x, double lambda)
	{
		return 1 / (1 + Math.pow(Math.E, (-1) * lambda * x));
	}
	
	public static double dsigmoid(double x, double lambda)
	{
		return lambda * x * (1 - x);
	}
	
	public static double tanh(double x, double lambda)
	{
		return Math.tanh(lambda * x);
	}
	
	public static double rootMeanSquare(double[] values)
	{
		return values[0];
	}
}
