import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import gdmachado.Inceptron.*;

public class TestPerceptron {

	public static void main(String[] args) throws IOException {
		double[][] data = { {0,0,1}, {0,1,0}, {1,0,0}, {1,1,1} };
		double[] expectedOutput = {0,1,0,1};
		/*
		//==================================================================
		// Begin neuron testing
		//==================================================================
		Neuron p = new Neuron(3, 0.5, 0.05, -1, 1);

		System.out.println("Beginning training...");

		int it = Teacher.train(data, expectedOutput, 0.01d, p, false);

		System.out.println("Finished training in "+it+" iterations.");

		System.out.println("\nStarting test");

		double[] output = Teacher.test(data, p);

		for (int i = 0; i < data.length; i++)
		{
			System.out.print("Output for {");
			for (int j = 0; j < data[i].length - 1; j++)
				System.out.print(data[i][j]+", ");
			System.out.print(data[i][data[i].length-1]+"}: " + output[i]);
			System.out.println(", Expected: "+expectedOutput[i]);
		}

		System.out.print("Weights: ");
		for (double n : p.getWeights())
			System.out.print(n+", ");

		//==================================================================
		// End neuron testing
		//==================================================================
		// Begin layer testing
		//==================================================================

		System.out.println("\nPress any key to begin training layer...");
		System.in.read();

		Layer l = new Layer(3, 2, 0.5, 0.5, -1, 1);

		double[][] expectedOutput2 = {{1,1}, {0,1}, {0,1}, {1,0}};

		System.out.println("Beginning training on layer...");

		it = Teacher.train(data,  expectedOutput2, 0.0001d, l, false);

		System.out.println("Finished training in "+it+" iterations.");
		
		//==================================================================
		// End layer testing
		//==================================================================
		// Begin multilayer perceptron testing
		//==================================================================
		
		System.out.println("\nPress any key to begin training the mlp...");
		System.in.read();

		MultilayerPerceptron m = new MultilayerPerceptron(new int[]{2,2}, 0.5, 0.5, -1, 1);
		
		double[][] data2 = { {0,0}, {1,0}, {1,1}, {1,1} };

		double[][] expectedOutput3 = {{1,0}, {0,0}, {1,1}, {0,0}};

		System.out.println("Beginning training on layer...");
		
		double[] individual = m.getIndividual();
		
		double[] newindiv = {1,2,3,4,5,6,7,8,9,10,11,12};
		
		m.setIndividual(newindiv);
		
		individual = m.getIndividual();
		
		it = Teacher.train(data2,  expectedOutput3, 0.001d, m, true);

		System.out.println("Finished training in "+it+" iterations.");
		*/
		
		//==================================================================
		// End multilayer perceptron testing
		//==================================================================
		// Begin genetic algorithm testing
		//==================================================================
		
		System.out.println("Press any key to start the genetic algorithm optimization...");		
		System.in.read();
		
		MultilayerPerceptron mlp = new MultilayerPerceptron(new int[]{4,3}, 0.5, 0.5, -1, 1);
		
		Population pop = new Population(20, true, mlp);
		
		FileWriter fw = new FileWriter("glass_fold2.result");
		BufferedWriter bw = new BufferedWriter(fw);
		
		int generations = 0;
		while(pop.getFittest(mlp).getFitness(mlp) < Fitness.getMaxFitness() && generations < 1000) {
			bw.write(generations+" "+String.valueOf(pop.getFittest(mlp).getFitness(mlp))+"\n");
			generations++;
			System.out.println("Generation "+generations+": Best fitness so far: "+ pop.getFittest(mlp).getFitness(mlp));
			
			pop = Evolution.evolvePopulation(pop, mlp);
		}
		System.out.println("Generation found.");
		System.out.println("Fittest: " + pop.getFittest(mlp).getFitness(mlp));
		System.out.println("His error is: " + 1/pop.getFittest(mlp).getFitness(mlp));
		
		bw.close();
		
	}

}
