package gdmachado.Inceptron;

/**
 * @author Gustavo Danilo Machado
 * @version 0.1
 */

import java.util.Arrays;

public class Neuron
{
	//
	// Default constructor
	// Creates a new perceptron without inputs and all weights equal to zero and verbose = false
	//
	public Neuron()
	{
		this.Inputs = 0;
		this.Bias = 0;
		this.LearningRate = 0;
		this.Threshold = 0;
		this.Weights = new double[1];
		
		this.init(0);
	}
	//
	// Constructor
	// Creates a new Perceptron object and initializes all weights as specified value
	//
	public Neuron(int input, double bias, double learningRate, double threshold, double value)
	{
		this.Inputs = input;
		this.Bias = bias;
		this.LearningRate = learningRate;
		this.Threshold = threshold;
		this.Weights = new double[this.Inputs];
				
		this.init(value); // initialize weights as specified value
	}
	
	//
	// Constructor
	// Creates a new Perceptron object and initializes all weights as random values between lower and upper
	//
	public Neuron(int input, double bias, double learningRate, double threshold, double lower, double upper)
	{
		this.Inputs = input;
		this.Bias = bias;
		this.LearningRate = learningRate;
		this.Threshold = threshold;
		this.Weights = new double[this.Inputs];
		
		this.init(lower, upper); // initialize weights as random numbers between lower and upper
	}
	
	//
	// Method init(double) class
	// Initialize all weights according to the value passed	
	//
	private void init(double value)
	{
		Arrays.fill(this.Weights, value);
	}
	
	//
	// Method init(double, double) class
	// Initialize all weights being a random number between two values passed
	//
	private void init(double lower, double upper)
	{
		for (int i = 0; i < this.Weights.length; i++)
				Weights[i] = lower + Math.random() * ((upper - lower) + 1);
	}
	
	//
	// simply calculates output given data
	//	
	public double think(double[] data)
	{
		return activate(MathUtils.dotProduct(data, this.Weights) - Bias);
	}
	
	//
	// private double[] compare
	// activation function!!!!!!
	// threshold for now
	// compares with Threshold
	// FIXME
	//
	private double activate(double output)
	{
		return MathUtils.sigmoid(output, 5);
	}
	
	//
	// update weights
	// updates weights according to error and input data
	//
	protected void updateWeights(double error, double[] data)
	{
		for(int i = 0; i < data.length; i++)
			Weights[i] += LearningRate * error * data[i];
		if (Bias != 0) Bias -= LearningRate * error;
	}
	
	//
	// public double[] test(double[][] input)
	// tests the Perceptron network against a set of data
	// returns an array containing outputs for all sets of data
	public double[] test(double[][] input)
	{
		double[] output = new double[input.length];
		for(int i = 0; i < input.length; i++)
			output[i] = think(input[i]);
		return output;
	}
	
	
	//
	// print network
	// method simply prints the whole network in a nice format
	//
	public void printNetwork()
	{
		
	}
	
	public double[] getWeights()
	{
		return Weights;
	}
	
	
	//
	// Attributes
	//
	protected double[] Weights;
	int Inputs;
	double Bias;
	double LearningRate;
	double Threshold;
}
