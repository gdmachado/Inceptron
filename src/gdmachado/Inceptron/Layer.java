package gdmachado.Inceptron;

import java.util.ArrayList;

public class Layer
{
	double LAMBDA;
	//
	// Default constructor
	// Creates a new perceptron layer with 0 perceptrons
	//
	public Layer()
	{
		this.neurons = new ArrayList<Neuron>();
	}
	
	//
	// Constructor
	// Creates a new perceptron layer and initializes all weights as specified value
	//
	public Layer(int input, 
						   int outputs, 
						   double bias, 
						   double learningRate, 
						   double threshold, 
						   double value)
	{
		this.neurons = new ArrayList<Neuron>();
		
		for (int i = 0; i < outputs; i++)
			neurons.add(new Neuron(input, bias, learningRate, threshold, value));
		LAMBDA = neurons.get(0).LAMBDA;
	}
	
	//
	// Constructor
	// Creates a new perceptron layer and initializes all weights as specified value
	//
	public Layer(int input, 
						   int outputs, 
						   double bias, 
						   double learningRate, 
						   double threshold, 
						   double lower,
						   double upper)
	{
		this.neurons = new ArrayList<Neuron>();
		
		for (int i = 0; i < outputs; i++)
			neurons.add(new Neuron(input, bias, learningRate, threshold, lower, upper));
		LAMBDA = neurons.get(0).LAMBDA;
	}
	
	//
	// Think
	// Gets output from each one of the neurons within the layer, return an array of results
	//
	public double[] think(double[] data)
	{
		double[] result = new double[this.neurons.size()];
		
		for (int i = 0; i < this.neurons.size(); i++)
			result[i] = this.neurons.get(i).think(data);
		
		return result;
	}
	
	//
	// updateWeights
	// Updates all weights across the layer according to the provided delta and input data
	//
	protected void updateWeights(double[] delta, double[] data)
	{
		for(int i = 0; i < neurons.size(); i++)
		{
			neurons.get(i).updateWeights(delta[i], data);
		}
	}
	
	//
	// double[][] getWeights
	// returns a new two-dimensional array containing the weights from all perceptrons within the layer
	// 
	public double[][] getWeights()
	{
		double[][] weights = new double[neurons.size()][];
		for(int i = 0; i < neurons.size(); i++)
			weights[i] = neurons.get(i).getWeights();
		return weights;
	}
	
	public double[] getBias()
	{
		double[] bias = new double[neurons.size()];
		for(int i = 0; i < neurons.size(); i++)
			bias[i] = neurons.get(i).Bias;
		return bias;
	}
	
	//
	// Attributes
	//
	protected ArrayList<Neuron> neurons;
}
