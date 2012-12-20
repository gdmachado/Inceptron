package gdmachado.Inceptron;

public class Teacher {
	public static int train(double[][] data, double[] expectedOutput, double maxError, Neuron neuron, boolean verbose)
	{
		double error;
		int iterations = 0;
		do
		{
			if (verbose) System.out.println("\n==============\nIteration " + iterations+"\n==============");
			error = 0;
			for (int i = 0; i < data.length; i++)
			{
				double result = neuron.think(data[i]);
				if (verbose) 
				{
					System.out.print("Working with data {");
					for(double n : data[i]) System.out.print(n+", ");
					System.out.print(neuron.Bias + "}, output: "+result+", ");
				}
				
				error += Math.pow(expectedOutput[i] - result, 2);
				if (verbose) System.out.println("Error = "+error);
				if (error != 0)
				{
					if (verbose) System.out.println("Updating weights...");
					neuron.updateWeights(expectedOutput[i] - result, data[i]);
				}
			}
			error = Math.sqrt(error / data.length);
			if (verbose) System.out.println("Root mean squared error: "+ error);
			iterations++;
		}
		while(error > maxError); // while error is big enough
		if (verbose) System.out.println("\nFinished training!");
		return iterations;
	}
	/*
	public static train(double[][] data, double[] expectedOutput, double maxError, Layer n)
	{
		
	}
	
	public static train(double[][] data, double[] expectedOutput, double maxError, MultiLayerPerceptron n)
	{
		
	}
	*/
}
