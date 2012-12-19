import gdmachado.Inceptron.*;

public class TestPerceptron {

	public static void main(String[] args) {
		double[][] data = { {1,0,0}, {1,0,1}, {1,1,0}, {1,1,1} };
		double[] expectedOutput = {1,1,1,0};
		
		Perceptron p = new Perceptron(3, 0, 0.1, 0.5, 0, 1, true);
		
		p.train(data, expectedOutput);
		
		System.out.println("\nStarting test");
		
		double[] output = p.test(data);
		
		for (int i = 0; i < data.length; i++)
			System.out.println("Output for {"+data[i][0]+", "+data[i][1]+", "+data[i][2]+"}: "
												+output[i]+"; Expected: "+expectedOutput[i]);

        for (double n : p.getWeights())
        	System.out.print(n+", ");
	}

}
