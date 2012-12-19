package gdmachado.Inceptron;

public class DotProduct {
	public static Double product(final double[] a, final double[] b) throws Exception
	{
		if (a.length != b.length) return null;
		
		double result = 0;
		for (int i = 0; i < a.length; i++) result += a[i] * b[i];
		
		return result;
	}
}
