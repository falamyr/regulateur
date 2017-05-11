package Intelligence.Weights;

import Intelligence.Decisions.Decision;
import Intelligence.Environment.Environment;
import Intelligence.Environment.environmentClasses;
import Intelligence.Events.EventSequence;
import Intelligence.Events.eventSequenceClasses;
import Intelligence.Experience.Experience;
import Intelligence.Mechanics.Mechanics;
import Intelligence.Mechanics.mechanicsClasses;
import Intelligence.Meteo.Meteo;
import Intelligence.Meteo.meteoClasses;
import Intelligence.Success.Success;

public class Weights {

	// DONNEES

	protected int numberMeteoClasses = meteoClasses.NUMBER_CLASSES;
	protected int numberEnvironmentClasses = environmentClasses.NUMBER_CLASSES;
	protected int numberMechanicsClasses = mechanicsClasses.NUMBER_CLASSES;
	protected int numberEventsClasses = eventSequenceClasses.NUMBER_CLASSES;

	protected int numberFlattenedWeights = 0;

	protected int [][][][][] weights = null;

	// CONSTRUCTEUR

	public Weights() {

		this.weights = new int[numberMeteoClasses][numberEnvironmentClasses][numberMechanicsClasses][numberEventsClasses][];

		for (int i = 0; i < numberMeteoClasses; i++) {
			for (int j = 0; j < numberEnvironmentClasses; j++) {
				for (int k = 0; k < numberMechanicsClasses; k++) {
						for (int m = 0; m < numberEventsClasses; m++) {
							int numberWeights = Decision
									.getNumberClasses(Mechanics
											.getClassFromIndice(k));
							numberFlattenedWeights += numberWeights;
							this.weights[i][j][k][m] = new int[numberWeights];
							for (int n = 0; n < numberWeights; n++) {
								this.weights[i][j][k][m][n] = Intelligence.constants.INITIAL_WEIGHT;
								if (weights[i][j][k][m][n] < Intelligence.constants.WEIGHTS_LIMIT_DOWN)
									weights[i][j][k][m][n] = Intelligence.constants.WEIGHTS_LIMIT_DOWN;
								if (weights[i][j][k][m][n] > Intelligence.constants.WEIGHTS_LIMIT_UP)
									weights[i][j][k][m][n] = Intelligence.constants.WEIGHTS_LIMIT_UP;

							
						}
					}
				}
			}
		}
	}

	// ACCESSEUR

	public int[] getDecisionWeights(int meteoClass, int envClass,
			int mechsClass, int eventsClass) {
		return this.weights[Meteo.getIndiceFromClass(meteoClass)][Environment
				.getIndiceFromClass(envClass)][Mechanics
				.getIndiceFromClass(mechsClass)][EventSequence
				.getIndiceFromClass(eventsClass)];
	}

	// METHODES

	public void update(Experience[] experiences, int numberExperiences) {

		for (int i = 0; i < numberExperiences; i++) {
			int meteoClass = experiences[i].getMeteoClass();
			int envClass = experiences[i].getEnvClass();
			int mechsClass = experiences[i].getMechsClass();
			int eventsClass = experiences[i].getEventsClass();

			int decisionClass = experiences[i].getDecisionClass();
			int successClass = experiences[i].getSuccessClass();

			int indiceDecision = Decision.getIndiceFromClass(decisionClass,
					mechsClass);

			int[] decisionWeights = this.weights[Meteo
					.getIndiceFromClass(meteoClass)][Environment
					.getIndiceFromClass(envClass)][Mechanics
					.getIndiceFromClass(mechsClass)][EventSequence
					.getIndiceFromClass(eventsClass)];

			int oldWeight = decisionWeights[indiceDecision];

			int updatedWeight = Success
					.updateWeight(oldWeight, successClass);
			// if (Main.constants.showRegulateur)
			// System.out.println("Success = " + successClass +
			// ", Old weight = " + oldWeight + ", New weight = " +
			// updatedWeight);

			decisionWeights[indiceDecision] = updatedWeight;
		}

	}

	// IO METHODES

	public int getNumberFlattenedWeights_io() {
		return this.numberFlattenedWeights;
	}

	public int[][][][][] getWeights_io() {
		return weights;
	}

	public int[] getFlattenedWeights_io() {

		int[] flattenedWeights = new int[numberFlattenedWeights];

		int done = 0;
		for (int i = 0; i < numberMeteoClasses; i++) {
			for (int j = 0; j < numberEnvironmentClasses; j++) {
				for (int k = 0; k < numberMechanicsClasses; k++) {
					int numberDecisionWeights = Decision
							.getNumberClasses(Mechanics.getClassFromIndice(k));
						for (int m = 0; m < numberEventsClasses; m++) {
							for (int n = 0; n < numberDecisionWeights; n++) {
								flattenedWeights[done++] = weights[i][j][k][m][n];
							}
						
					}
				}
			}
		}
		return flattenedWeights;
	}

	public void setWeights_io(int[] flattenedWeights) {

		int done = 0;
		for (int i = 0; i < numberMeteoClasses; i++) {
			for (int j = 0; j < numberEnvironmentClasses; j++) {
				for (int k = 0; k < numberMechanicsClasses; k++) {
					int numberDecisionWeights = Decision
							.getNumberClasses(Mechanics.getClassFromIndice(k));
						for (int m = 0; m < numberEventsClasses; m++) {
							for (int n = 0; n < numberDecisionWeights; n++) {
								weights[i][j][k][m][n] = flattenedWeights[done++];
							}
						}
					
				}
			}
		}
	}

}
