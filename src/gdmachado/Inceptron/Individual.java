package gdmachado.Inceptron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Individual {
	// Helper attributes
	
	
	//
	// Constructor
	//
	public Individual(MultilayerPerceptron m)
	{
		genes = new double[m.getIndividual().length];
		Arrays.fill(this.genes, 0);
	}
	//
	// Constructor
	//
	public Individual(int size)
	{
		this.genes = new double[size];
		
		this.generateRandomIndividual();
	}
	//
	// Constructor
	//
	public Individual(double[] individual)
	{
		this.genes = individual;
	}

    int GeneLength;
    double[] genes;
    private double fitness = 0;

    // Create a random individual
    public void generateRandomIndividual() {
    	Random rand = new Random();
        for (int i = 0; i < size(); i++) {
            genes[i] = rand.nextFloat();
        }
    }

    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths
    public void setDefaultGeneLength(int length) {
        GeneLength = length;
    }
    
    public double getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, double value) {
        genes[index] =  value;
        fitness = 0;
    }
    
    public double[] getGenes()
    {
    	return this.genes;
    }

    /* Public methods */
    public int size() {
        return genes.length;
    }

    public double getFitness(MultilayerPerceptron m) {
        if (fitness == 0) {
            fitness = Fitness.getFitness(this, m);
        }
        return fitness;
    }
    
    public double getLargestGene() {
    	double m = 0;
    	for(double n : genes)
    		if (n > m) m = n;
    	return m;
    }
    
    public double getSmallestGene() {
    	double m = Float.POSITIVE_INFINITY;
    	for(double n : genes)
    		if (n < m) m = n;
    	return m;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }
}