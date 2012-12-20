package gdmachado.Inceptron;

public class Teacher {
	public static int train(double[][] data, double[] expectedOutput, double maxError, Neuron neuron, boolean verbose)
	{
		double errorRMS;
		double delta;
		int iterations = 0;
		do
		{
			if (verbose) System.out.println("\n==============\nIteration " + iterations+"\n==============");
			errorRMS = 0;
			for (int i = 0; i < data.length; i++)
			{
				double result = neuron.think(data[i]);
				if (verbose) 
				{
					System.out.print("Working with data {");
					for(double n : data[i]) System.out.print(n+", ");
					System.out.print(neuron.Bias + "}, output: "+result+", ");
				}
				
				delta = MathUtils.getDelta(result, expectedOutput[i], neuron.LAMBDA);
				
				errorRMS += Math.pow(expectedOutput[i] - result, 2);
				
				if (verbose) System.out.println("Error = "+ (expectedOutput[i] - result));
				if (expectedOutput[i] - result != 0)
				{
					if (verbose) System.out.println("Updating weights...");
					neuron.updateWeights(delta, data[i]);
				}
			}
			errorRMS = Math.sqrt(errorRMS / data.length);
			if (verbose) System.out.println("Root mean squared error (across entire dataset): "+ errorRMS);
			iterations++;
		}
		while(errorRMS > maxError); // while error is big enough
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
	
	//
	// public double[] test(double[][] input)
	// tests the Perceptron network against a set of data
	// returns an array containing outputs for all sets of data
	public static double[] test(double[][] input, Neuron neuron)
	{
		double[] output = new double[input.length];
		for(int i = 0; i < input.length; i++)
			output[i] = neuron.think(input[i]);
		return output;
	}
	
	//public static double getDelta()
}

