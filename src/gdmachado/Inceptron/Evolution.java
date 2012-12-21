package gdmachado.Inceptron;

import java.util.Random;

public class Evolution {

    /* GA parameters */
    private static final double uniformRate = 0.5;
    private static final double mutationRate = 0.1;
    private static final int tournamentSize = 3;
    private static final boolean elitism = true;
    

    // returns a new random population
    public static Population newPopulation(int size, MultilayerPerceptron m) {
    	Population newPopulation = new Population(size, true, m);
    	return newPopulation;
    }
    // Evolve a population
    public static Population evolvePopulation(Population pop, MultilayerPerceptron m) {
        Population newPopulation = new Population(pop.size(), false, m);
        //System.out.println("Evolving population... Current fittest: "+ pop.getFittest(m).getFitness(m));
        // Keep our best individual
        if (elitism) {
            newPopulation.saveIndividual(0, pop.getFittest(m));
        }

        // Crossover population
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
        // Loop over the population size and create new individuals with
        // crossover
        for (int i = elitismOffset; i < pop.size(); i++) {
            Individual indiv1 = tournamentSelection(pop, m);
            Individual indiv2 = tournamentSelection(pop, m);
            Individual newIndiv = crossover(indiv1, indiv2, m);
            newPopulation.saveIndividual(i, newIndiv);
        }

        // Mutate population
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
    }

    // Crossover individuals
    private static Individual crossover(Individual indiv1, Individual indiv2, MultilayerPerceptron m) {
        Individual newSol = new Individual(m);
        // Loop through genes
        for (int i = 0; i < indiv1.size(); i++) {
            // Direct Crossover
            if (Math.random() <= uniformRate) {
                newSol.setGene(i, indiv1.getGene(i));
            } else {
                newSol.setGene(i, indiv2.getGene(i));
            }
        }
        return newSol;
    }

    // Mutação real
    private static void mutate(Individual indiv) {
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
            	double top = indiv.getLargestGene();
            	double bot = indiv.getSmallestGene();
            	
                double gene = bot + (double)(Math.random() * ((top - bot) + 1));
                indiv.setGene(i, gene);
            }
        }
    }

    // Select individuals for crossover
    private static Individual tournamentSelection(Population pop, MultilayerPerceptron m) {
        // Create a tournament population
        Population tournament = new Population(tournamentSize, false, m);
        // For each place in the tournament get a random individual
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournament.saveIndividual(i, pop.getIndividual(randomId));
        }
        // Get the fittest
        Individual fittest = tournament.getFittest(m);
        return fittest;
    }
}