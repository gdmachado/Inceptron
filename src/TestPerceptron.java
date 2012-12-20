import gdmachado.Inceptron.*;

public class TestPerceptron {

	public static void main(String[] args) {
		double[][] data = { {0,0}, {0,1}, {1,0}, {1,1} };
		double[] expectedOutput = {1,0,0,0};
		
		Neuron p = new Neuron(2, 0.5, 0.3, 0.05, -1, 1);
		
		System.out.println("Beginning training...");
		
		int it = Teacher.train(data, expectedOutput, 0.001d, p, true);
		
		System.out.println("Finished training in "+it+" iterations.");
		
		System.out.println("\nStarting test");
		
		double[] output = p.test(data);
		
		for (int i = 0; i < data.length; i++)
		{
			System.out.print("Output for {");
			for (int j = 0; j < data[i].length - 1; j++)
				System.out.print(data[i][j]+", ");
			System.out.print(data[i][data[i].length-1]+"}: " + output[i]);
			System.out.println(", Expected: "+expectedOutput[i]);
		}
		
        for (double n : p.getWeights())
        	System.out.print(n+", ");
	}

}
