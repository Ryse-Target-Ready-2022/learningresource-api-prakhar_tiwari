package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import entity.LearningResource;
import entity.LearningResourceStatus;

public class LearningResourceService {
	private List<LearningResource> getLearningResources() throws Exception {
		List<LearningResource> l=new ArrayList<>();
		String line="";
		BufferedReader br=new BufferedReader(new FileReader("LearningResource.csv"));
		while((line=br.readLine())!=null)
		{
			String[] res=line.split(",");
			LearningResource learn=createLearningResource(res);
			l.add(learn);
		}
		return l;
	}
	private void saveLearningResources(List<LearningResource> learningResources){
        final String csvDelimiter = ",";
        try {
            File learningResourcesFile = new File("LearningResources.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(learningResourcesFile.getName(), true));
            for (LearningResource learningResource : learningResources) {
                bufferedWriter.newLine();
                StringBuffer singleLine = new StringBuffer();
                singleLine.append(learningResource.getId());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getName());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getCp());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getSp());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getLrStat());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getCreated());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getPublished());
                singleLine.append(csvDelimiter);
                singleLine.append(learningResource.getRetired());
                bufferedWriter.write(singleLine.toString());
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	private LearningResource createLearningResource(String[] attributes) throws Exception{
        Integer id=Integer.parseInt(attributes[0]);
        String name=attributes[1];
        Integer cp=Integer.parseInt(attributes[2]);
        Integer sp=Integer.parseInt(attributes[3]);
        LearningResourceStatus learningResourceStatus = LearningResourceStatus.valueOf(attributes[4]);
        Date cr= new SimpleDateFormat("dd/MM/yyyy").parse(attributes[5]);
        Date pub=new SimpleDateFormat("dd/MM/yyyy").parse(attributes[6]);
        Date ret=new SimpleDateFormat("dd/MM/yyyy").parse(attributes[7]);
        LearningResource learningResource=new LearningResource(id, name, cp, sp, learningResourceStatus, cr, pub, ret);
        return learningResource;
    }
	private List<LearningResource> sortByProfits() throws Exception
	{
		List<LearningResource> lr= getLearningResources();
		Profitsorter ps=new Profitsorter();
		Collections.sort(lr,new Profitsorter());
		return lr;
	}
}
class Profitsorter implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		LearningResource lrs1=(LearningResource)o1;
		LearningResource lrs2=(LearningResource)o2;
		int profit2=lrs2.getSp()-lrs2.getCp();
		int profit1=lrs1.getSp()-lrs1.getCp();
		return profit2-profit1;
	}
}
