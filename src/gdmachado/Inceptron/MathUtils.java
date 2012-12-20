package gdmachado.Inceptron;

public class MathUtils {
	public static double getDelta(double output, double expected, double lambda)
	{
		return dsigmoid(output, lambda) * (expected - output);
	}
	
	public static Double dotProduct(final double[] a, final double[] b)
	{		
		double result = 0;
		try {			
			for (int i = 0; i < a.length; i++) result += a[i] * b[i];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.err.println("Number of inputs does not match the number of weights. Exiting...");
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
		return lambda * (Math.pow(Math.E, (-1) * lambda * x) / (Math.pow(Math.pow(Math.E, (-1) * lambda * x), 2)));
	}
	
	public static double tanh(double x, double lambda)
	{
		return Math.tanh(lambda * x);
	}
	
	public static double rootMeanSquare(double[] values)
	{
		double sum = 0;
		for(double n : values)
			sum += Math.pow(n, 2);
		sum /= values.length;
		return sum;
		
	}
	
	public static double rootMeanSquareError(double[] output, double[] expected)
	{
		double sum = 0;
		try
		{
			for(int i = 0; i < output.length; i++)
				sum += Math.pow(output[i] - expected[i], 2);
			sum = Math.sqrt(sum / output.length);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.err.println("Number of outputs does not match number of expected values. Exiting...");
			System.exit(1);
		}
		return sum;
	}
}
