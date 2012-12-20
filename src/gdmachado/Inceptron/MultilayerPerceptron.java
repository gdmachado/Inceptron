package gdmachado.Inceptron;

import java.util.ArrayList;

public class MultilayerPerceptron
{
	//
	// Constructor
	//
	MultilayerPerceptron(int[] topology, // {input, hidden, ..., hidden, output}
						 int hiddenLayers,						 
						 double learningRate,
						 double errorThreshold,
						 double bias,
						 double value,
						 boolean verbose)
	{
		// Initialize input layer
		layers.add(new Layer(topology[0], 
									   topology[1], 
									   bias, 
									   learningRate, 
									   errorThreshold, 
									   value));
		
		// Initialize hidden layers
		if (topology.length > 2)
		{
			for(int i = 1; i < topology.length - 1; i++)
				layers.add(new Layer(topology[i], 
											   topology[i+1], 
											   bias, 
											   learningRate, 
											   errorThreshold, 
											   value));
			
		}
		
		// Initialize output layer
		layers.add(new Layer(topology[topology.length - 2], 
											    topology[topology.length - 1], 
											    bias, 
											    learningRate, 
											    errorThreshold, 
											    value));
	}
	
	//
	// Constructor
	//
	MultilayerPerceptron(int[] topology, // {input, hidden, ..., hidden, output}
						 int hiddenLayers,						 
						 double learningRate,
						 double errorThreshold,
						 double bias,
						 double lower,
						 double upper,
						 boolean verbose)
	{
		// Initialize input layer
		layers.add(new Layer(topology[0], 
									   topology[1], 
									   bias, 
									   learningRate, 
									   errorThreshold,
									   lower,
									   upper));
		
		// Initialize hidden layers
		if (topology.length > 2)
		{
			for(int i = 1; i < topology.length - 1; i++)
				layers.add(new Layer(topology[i], 
											   topology[i+1], 
											   bias, 
											   learningRate, 
											   errorThreshold,
											   lower,
											   upper));
			
		}
		
		// Initialize output layer
		layers.add(new Layer(topology[topology.length - 2], 
											    topology[topology.length - 1], 
											    bias, 
											    learningRate, 
											    errorThreshold,
											    lower,
											    upper));
	}
	
	public void think(double[] data)
	{
		
	}
	
	
	//
	// Attributes
	//
	ArrayList<Layer> layers;
}
