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
					System.out.print("}, output: "+result+", ");
				}

				delta = MathUtils.getDelta(result, expectedOutput[i], neuron.LAMBDA);

				errorRMS += Math.pow(expectedOutput[i] - result, 2);

				if (verbose) System.out.println("Error = "+ (expectedOutput[i] - result));

				if (verbose) System.out.println("Updating weights...");
				neuron.updateWeights(delta, data[i]);
			}
			errorRMS = Math.sqrt(errorRMS / data.length);
			if (verbose) System.out.println("Root mean squared error (across entire dataset): "+ errorRMS);
			iterations++;
		}
		while(errorRMS > maxError); // while error is big enough
		if (verbose) System.out.println("\nFinished training!");
		return iterations;
	}


	public static int train(double[][] data, double[][] expectedOutput, double maxError, Layer layer, boolean verbose)
	{
		double errorRMS;
		double delta[] = null;
		int iterations = 0;
		do
		{
			if (verbose) System.out.println("\n==============\nIteration " + iterations+"\n==============");
			errorRMS = 0;
			for (int i = 0; i < data.length; i++)
			{
				double[] result = layer.think(data[i]);
				delta = new double[result.length];
				if (verbose) 
				{
					System.out.print("Working with data {");
					for(double n : data[i]) System.out.print(n+", ");
					System.out.print("}, output: {");
					for(double n : result) System.out.print(n+", ");
					System.out.print("}, ");
				}
				for(int j = 0; j < result.length; j++)
				{
					delta[j] = MathUtils.getDelta(result[j], expectedOutput[i][j], layer.LAMBDA);
				}

				errorRMS = MathUtils.rootMeanSquareError(result, expectedOutput[i]);

				if (verbose) System.out.println("Error = "+ errorRMS);

				if (verbose) System.out.println("Updating weights...");
				layer.updateWeights(delta, data[i]);
			}
			if (verbose) System.out.println("Root mean squared error: "+ errorRMS);
			iterations++;
		}
		while(errorRMS > maxError); // while error is big enough
		if (verbose) System.out.println("\nFinished training!");
		return iterations;
	}
	
	public static int train(double[][] data, double[][] expectedOutput, double maxError, MultilayerPerceptron mlp, boolean verbose)
	{
		double errorRMS;
		double delta[] = null;
		int iterations = 0;
		do
		{
			if (verbose) System.out.println("\n==============\nIteration " + iterations+"\n==============");
			errorRMS = 0;
			for (int i = 0; i < data.length; i++)
			{
				// feed-forward phase
				double[] result = mlp.think(data[i]);
				delta = new double[result.length];
				if (verbose) 
				{
					System.out.print("Working with data {");
					for(double n : data[i]) System.out.print(n+", ");
					System.out.print("}, output: {");
					for(double n : result) System.out.print(n+", ");
					System.out.print("}, ");
				}
				for(int j = 0; j < result.length; j++)
				{
					delta[j] = MathUtils.getDelta(result[j], expectedOutput[i][j], mlp.LAMBDA);
				}

				errorRMS = MathUtils.rootMeanSquareError(result, expectedOutput[i]);

				if (verbose) System.out.println("Error = "+ errorRMS);

				if (verbose) System.out.println("Updating weights...");
				mlp.updateWeights(delta, data[i]);
			}
			if (verbose) System.out.println("Root mean squared error: "+ errorRMS);
			iterations++;
		}
		while(iterations < 50);
		//while(errorRMS > maxError); // while error is big enough
		if (verbose) System.out.println("\nFinished training!");
		return iterations;
	}

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

