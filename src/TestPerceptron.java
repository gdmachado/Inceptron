import java.io.IOException;

import gdmachado.Inceptron.*;

public class TestPerceptron {

	public static void main(String[] args) throws IOException {
		double[][] data = { {0,0,1}, {0,1,0}, {1,0,0}, {1,1,1} };
		double[] expectedOutput = {0,1,0,1};
		
		//==================================================================
		
		Neuron p = new Neuron(3, 0.5, 0.5, 0.05, -1, 1);
		
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
        
        System.out.println("\nPress any key to begin training layer...");
        System.in.read();
        
        Layer l = new Layer(3, 2, 0.5, 0.5, -1, 1);
        
        double[][] expectedOutput2 = {{1,1}, {0,1}, {0,1}, {1,0}};
        
        System.out.println("Beginning training on layer...");
        
        it = Teacher.train(data,  expectedOutput2, 0.0001d, l, true);
        
        System.out.println("Finished training in "+it+" iterations.");
	}

}
