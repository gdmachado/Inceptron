package gdmachado.Inceptron;

/**
 * @author Gustavo Danilo Machado
 * @version 0.1
 */

import java.util.Arrays;

public class Perceptron
{
	
	//
	// Constructor
	// Creates a new Perceptron object and initializes all weights as specified value
	//
	public Perceptron(int input, int output, double bias, double learningRate, double threshold, double value)
	{
		this.InputNeurons = input;
		this.OutputNeurons = output;
		this.Bias = bias;
		this.LearningRate = learningRate;
		this.ErrorThreshold = threshold;
		this.WeightArray = new double[this.InputNeurons][this.OutputNeurons];
		this.BiasWeights = new double[this.OutputNeurons];
		Arrays.fill(BiasWeights,  this.Bias);
				
		this.init(value); // initialize weights as specified value
	}
	
	//
	// Constructor
	// Creates a new Perceptron object and initializes all weights as random values between lower and upper
	//
	public Perceptron(int input, int output, double bias, double learningRate, double threshold, double lower, double upper)
	{
		this.InputNeurons = input;
		this.OutputNeurons = output;
		this.Bias = bias;
		this.LearningRate = learningRate;
		this.ErrorThreshold = threshold;		
		this.WeightArray = new double[this.InputNeurons][this.OutputNeurons];
		this.BiasWeights = new double[this.OutputNeurons];
		Arrays.fill(BiasWeights,  this.Bias);
		
		this.init(lower, upper); // initialize weights as random numbers between lower and upper
	}
	
	//
	// init(int) class
	// Initialize all weights according to the value passed	
	//
	private void init(double value)
	{
		for (double[] line : this.WeightArray)
			Arrays.fill(line, value);
	}
	
	//
	// init(double, double) class
	// Initialize all weights being a random number between two values passed
	//
	private void init(double lower, double upper)
	{
		for (double[] line : this.WeightArray)
			for (int i = 0; i < line.length; i++)
				line[i] = lower + Math.random() * ((upper - lower) + 1);
	}
	
	private void train(double[][] data, double[][] expectedOutput)
	{
		double error = 10000;
		do
		{
			for (int i = 0; i < data.length; i++)
			{
				double[] output = think(data[i]);
				
				// COMPARE OUTPUT WITH EXPECTEDOUTPUT & UPDATE WEIGHTS
				// TODO
			}				
		}
		while(error > ErrorThreshold); // while error is big enough
	}
	
	//
	// simply calculates output given data
	//	
	private double[] think(double[] data)
	{
		double[] output = new double[OutputNeurons];
		Arrays.fill(output, 0);
		
		for(int i = 0; i < OutputNeurons; i++)
		{
			for(int j = 0; j < InputNeurons; j++)
			{
				output[i] += data[i] * WeightArray[i][j];
			}
			output[i] -= BiasWeights[i];
		}		
		return output;
	}
	
	//
	// private double[] compare
	// calculate differences between output & expected output
	// TODO
	//
	
	//
	// Attributes
	//
	int InputNeurons;
	int OutputNeurons;
	double Bias;
	double LearningRate;
	double ErrorThreshold;
	double[] BiasWeights;
	double[][] WeightArray;
}
