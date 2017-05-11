package Intelligence.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import Intelligence.constants;
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
import Intelligence.Weights.Weights;

;

public class SaverWeights {

	// DONNEES

	protected String filePath = null;

	protected Weights weights = null;

	// CONSTRUCTEUR

	public SaverWeights(Weights weights) {
		this.weights = weights;
	}

	// ACCESSEURS

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	// METHODES

	public void saveWeights() {
		try {
			File save = new File(filePath);
			if (!save.exists())
				save.createNewFile();
			FileOutputStream stream = new FileOutputStream(save, false);

			Writer writer = new BufferedWriter(new OutputStreamWriter(stream));

			int numberFlattenedWeights = weights.getNumberFlattenedWeights_io();
			int[] flattenedWeights = weights.getFlattenedWeights_io();

			for (int i = 0; i < numberFlattenedWeights; i++)
				writer.write(Integer.toString(flattenedWeights[i]) + "\n");

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public void saveWeightsLabels() {
		try {
			File save = new File(filePath + ".labels");
			if (!save.exists())
				save.createNewFile();
			FileOutputStream stream = new FileOutputStream(save, false);

			Writer writer = new BufferedWriter(new OutputStreamWriter(stream));

			int[][][][][] weightsArr = weights.getWeights_io();

			for (int i = 0; i < meteoClasses.NUMBER_CLASSES; i++) {
				for (int j = 0; j < environmentClasses.NUMBER_CLASSES; j++) {
					for (int k = 0; k < mechanicsClasses.NUMBER_CLASSES; k++) {
							for (int m = 0; m < eventSequenceClasses.NUMBER_CLASSES; m++) {
								int numberWeights = Decision
										.getNumberClasses(Mechanics
												.getClassFromIndice(k));
								for (int n = 0; n < numberWeights; n++)

								{
									int meteoClass = Meteo
											.getClassFromIndice(i);
									int envClass = Environment
											.getClassFromIndice(j);
									int mechsClass = Mechanics
											.getClassFromIndice(k);
									int eventsClass = EventSequence
											.getClassFromIndice(m);
									int decisionClass = Decision
											.getClassFromIndice(n, mechsClass);
									String out = Meteo.toString(meteoClass)
											+ ", "
											+ Environment.toString(envClass)
											+ ", "
											+ Mechanics.toString(mechsClass)
											+ ", "
											+ EventSequence
													.toString(eventsClass)
											+ ", "
											+ Decision.toString(decisionClass,
													mechsClass)
											+ ", "
											+ Integer.toString(weightsArr[i][j][k][m][n]);
									writer.write(out + "\n");
								
							}
						}
					}
				}
			}

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public void saveExperiencesLabels(Experience[] experiences,
			int numberExperiences) {
		try {
			File save = new File(filePath + ".exp");
			if (!save.exists())
				save.createNewFile();
			FileOutputStream stream = new FileOutputStream(save, false);

			Writer writer = new BufferedWriter(new OutputStreamWriter(stream));

			for (int i = 0; i < numberExperiences; i++)
				writer.write(experiences[i].toString() + "\n");

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
