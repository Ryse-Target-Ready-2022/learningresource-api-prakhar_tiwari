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
import static java.util.stream.Collectors.toList;
import org.springframework.stereotype.Service;

import entity.LearningResource;
import entity.LearningResourceStatus;
import repository.LearningResourceRepository;

@Service
public class LearningResourceService {
	private final LearningResourceRepository learningResourceRepository;

    public LearningResourceService(LearningResourceRepository learningResourceRepository) {
        this.learningResourceRepository = learningResourceRepository;
    }

    public void saveLearningResources(List<LearningResource> learningResources){
        for (LearningResource learningResource : learningResources)
            learningResourceRepository.save(learningResource);
    }

    public List<LearningResource> getLearningResources(){
        return learningResourceRepository.findAll();
    }

    public List<Integer> getProfitMargin(){
        List<LearningResource> learningResources = getLearningResources();

        List<Integer> profitMargins = learningResources.stream().map(lr -> ((lr.getSp() - lr.getCp())/lr.getSp())).collect(toList());

        return profitMargins;
    }

    public List<LearningResource> sortLearningResourcesByProfitMargin(){
        List<LearningResource> learningResources = getLearningResources();

        learningResources.sort((lr1, lr2) -> {
            Integer profitMargin1 = (lr1.getSp() - lr1.getCp())/lr1.getSp();
            Integer profitMargin2 = (lr2.getSp() - lr2.getCp())/lr2.getSp();

            return profitMargin2.compareTo(profitMargin1) ;
        });

        return learningResources;
    }
}
