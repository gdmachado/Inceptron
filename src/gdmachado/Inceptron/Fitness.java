package gdmachado.Inceptron;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Fitness {

    static ArrayList<Float> solution;
	
    /* Public methods */
    // Set a candidate solution as a byte array
    public static void setSolution(ArrayList<Float> newSolution) {
        solution = newSolution;
    }

    // Calculate inidividuals fittness by comparing it to our candidate solution
    static double getFitness(Individual individual, MultilayerPerceptron MLP) {
        double fitness = 0;
        ArrayList<double[]> in = new ArrayList<double[]>();
		ArrayList<double[]> out = new ArrayList<double[]>();
        
        MLP.setIndividual(individual.genes);
        
        //String file = "datasets/xor.txt";
        //String file = "datasets/glass_fold1.txt";
        String file = "datasets/iris_fold1.txt";
        
        double[] rmsError = null;
		
		try 
		{
			FileReader fin = new FileReader(file);
			BufferedReader br = new BufferedReader(fin);
			String s;
			while ((s = br.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(s, " ");
				double[] input = new double[MLP.layers.get(0).neurons.size() -1];
				double[] output = new double[MLP.layers.get(MLP.layers.size() - 1).neurons.size()];
				
				for(int i = 0; i < MLP.layers.get(0).neurons.size() - 1; i++)
					input[i] = Float.parseFloat(st.nextToken());
				in.add(input);
				
				for(int i = 0; i < MLP.layers.get(MLP.layers.size() - 1).neurons.size() - 1; i++)
					output[i] = Float.parseFloat(st.nextToken());
				out.add(output);
			}
			fin.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
        
        
        rmsError = new double[in.size()];
        for(int i = 0; i < in.size(); i++)
        {
        	rmsError[i] = MathUtils.rootMeanSquareError(MLP.think(in.get(i)), out.get(i));
        }
        
        double meanSquaredError = MathUtils.mean(rmsError);       
        
        fitness = 1 / meanSquaredError;
        System.out.println("Current error: "+ meanSquaredError+", fitness: "+ fitness);
        
        return fitness;
    }
    
    // Get optimum fitness
    public static int getMaxFitness() {
        int maxFitness = 20;
        return maxFitness;
    }
}