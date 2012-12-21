package gdmachado.Inceptron;
import java.util.ArrayList;
import java.util.Random;

public class Population {

    Individual[] Individuals;
    static final int FIXED_POP_SIZE = 20;

    /*
     * Constructors
     */
    
    // Create a population
    public Population(int populationSize, boolean initialise, MultilayerPerceptron m) {
        Individuals = new Individual[populationSize];
        // Initialize population
        if (initialise) {
            // Loop and create individuals
            for (int i = 0; i < FIXED_POP_SIZE; i++) {
            	if (i < FIXED_POP_SIZE / 2)
            	{
            		Individuals[i] = new Individual(m.getIndividual());
            	}
            	else
            	{
            		Individuals[i] = new Individual(m.getIndividual().length);
            	}
            }
        }
    }

    /* Getters */
    public Individual getIndividual(int index) {
        return Individuals[index];
    }

    public Individual getFittest(MultilayerPerceptron m) {
        Individual fittest = Individuals[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < size() - 1; i++) {
            if (fittest.getFitness(m) <= getIndividual(i).getFitness(m)) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    /* Public methods */
    // Get population size
    public int size() {
        return Individuals.length;
    }

    // Save individual
    public void saveIndividual(int index, Individual indiv) {
        this.Individuals[index] =  indiv;
    }
}
