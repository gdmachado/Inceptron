import gdmachado.Inceptron.*;

public class TestPerceptron {

	public static void main(String[] args) {
		double[][] data = { {1,0,0}, {1,0,1}, {1,1,0}, {1,1,1} };
		double[] expectedOutput = {1,1,1,0};
		
		Perceptron p = new Perceptron(3, 0, 0.1, 0.5, 0, 1, true);
		
		p.train(data, expectedOutput);
		
		double test = p.think(new double[]{1,1,0});		
		System.out.println("Testing with 1,1,0... output: " + test);
		
		test = p.think(new double[]{1,1,1});		
		System.out.println("Testing with 1,1,1... output: " + test);
		
		test = p.think(new double[]{1,0,0});		
		System.out.println("Testing with 1,0,0... output: " + test);
		
		test = p.think(new double[]{1,0,1});		
		System.out.println("Testing with 1,0,1... output: " + test);
	}

}
