package Intelligence.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Intelligence.Weights.Weights;

public class LoaderWeights {
	
	// DONNEES
	
	protected String filePath = null;
		
	protected Weights weights = null;
		
		
		// CONSTRUCTEUR
		
	public LoaderWeights(Weights weights)
	{
		this.weights = weights;
	}
		
	// ACCESSEURS
		
	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}
		
	// METHODES
		
	public void loadWeights()
	{	
		int []flattenedWeights = null;
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			 
		    int numberFlattenedWeights = weights.getNumberFlattenedWeights_io();		    
		    flattenedWeights = new int[numberFlattenedWeights];
		    
		    for (int i = 0 ; i < numberFlattenedWeights ; i++)
		    	flattenedWeights[i] = Integer.parseInt(reader.readLine());     
				         
			 reader.close();   	
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
		weights.setWeights_io(flattenedWeights);
	}

}
