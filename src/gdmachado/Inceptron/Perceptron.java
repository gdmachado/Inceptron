package gdmachado.Inceptron;

/**
 * @author Gustavo Danilo Machado
 * @version 0.1
 */

import java.util.Arrays;

public class Perceptron
{
	//
	// Default constructor
	// Creates a new perceptron without inputs and all weights equal to zero and verbose = false
	//
	public Perceptron()
	{
		this.Inputs = 0;
		this.Bias = 0;
		this.LearningRate = 0;
		this.Threshold = 0;
		this.Weights = new double[1];
		this.Verbose = false;
		
		this.init(0);
	}
	//
	// Constructor
	// Creates a new Perceptron object and initializes all weights as specified value
	//
	public Perceptron(int input, double bias, double learningRate, double threshold, double value, boolean verbose)
	{
		this.Inputs = input;
		this.Bias = bias;
		this.LearningRate = learningRate;
		this.Threshold = threshold;
		this.Weights = new double[this.Inputs];
		this.Verbose = verbose;
				
		this.init(value); // initialize weights as specified value
	}
	
	//
	// Constructor
	// Creates a new Perceptron object and initializes all weights as random values between lower and upper
	//
	public Perceptron(int input, double bias, double learningRate, double threshold, double lower, double upper, boolean verbose)
	{
		this.Inputs = input;
		this.Bias = bias;
		this.LearningRate = learningRate;
		this.Threshold = threshold;
		this.Weights = new double[this.Inputs];
		this.Verbose = verbose;
		
		this.init(lower, upper); // initialize weights as random numbers between lower and upper
	}
	
	//
	// init(double) class
	// Initialize all weights according to the value passed	
	//
	private void init(double value)
	{
		Arrays.fill(this.Weights, value);
	}
	
	//
	// init(double, double) class
	// Initialize all weights being a random number between two values passed
	//
	private void init(double lower, double upper)
	{
		for (int i = 0; i < this.Weights.length; i++)
				Weights[i] = lower + Math.random() * ((upper - lower) + 1);
	}
	
	public void train(double[][] data, double[] expectedOutput)
	{
		double error;
		int errorCount;
		int iterations = 0;
		do
		{
			errorCount = 0;
			if (Verbose) System.out.println("\n==============\nIteration " + iterations+"\n==============");
			error = 0;
			for (int i = 0; i < data.length; i++)
			{
				if (Verbose) 
				{
					System.out.print("Working with data {");
					for(double n : data[i]) System.out.print(n+", ");
					System.out.print(this.Bias + "}\n");
				}
				error = expectedOutput[i] - think(data[i]);
				if (Verbose) System.out.println("Error = "+error);
				if (error != 0)
				{
					updateWeights(error, data[i]);
					errorCount++;
				}
			}
			iterations++;
		}
		while(errorCount != 0); // while error is big enough
		if (Verbose) System.out.println("Finished training!");
	}
	
	//
	// simply calculates output given data
	//	
	public double think(double[] data)
	{
		double output = 0;
		try {
			output = compare(DotProduct.product(data, this.Weights) - Bias);
			return output;			
		} catch (Exception e) {
			System.err.println("Number of inputs does not match the number of weights");
			System.exit(1);
		}
		return output;
	}
	
	//
	// private double[] compare
	// activation function!!!!!!
	// threshold for now
	// compares with Threshold
	// FIXME
	//
	private double compare(double output)
	{
		if (output > Threshold) return 1;
		else return 0;
	}
	
	//
	// update weights
	// updates weights according to error and input data
	//
	private void updateWeights(double error, double[] data)
	{
		for(int i = 0; i < data.length; i++)
			Weights[i] += LearningRate * error * data[i];
		if (Bias != 0) Bias -= LearningRate * error;
		if (Verbose) System.out.println("Updating weights...");
	}
	
	//
	// print network
	// method simply prints the whole network in a nice format
	//
	public void printNetwork()
	{
		
	}
	
	
	//
	// Attributes
	//
	int Inputs;
	double Bias;
	double LearningRate;
	double[] Weights;
	double Threshold;
	boolean Verbose;
}
