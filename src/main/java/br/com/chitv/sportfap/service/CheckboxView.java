package br.com.chitv.sportfap.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class CheckboxView {
         
    private String[] selectedTimes;   
    private List<String> times;
     
    @PostConstruct
    public void init() {
    	times = new ArrayList<String>();
    	times.add("Miami");
    	times.add("London");
    	times.add("Paris");
    	times.add("Istanbul");
    	times.add("Berlin");
    	times.add("Barcelona");
        times.add("Rome");
        times.add("Brasilia");
        times.add("Amsterdam");
    }
 
    public String[] getSelectedTimes() {
        return selectedTimes;
    }
 
    public void setSelectedTimes(String[] selectedTimes) {
        this.selectedTimes = selectedTimes;
    }
 
    public List<String> getTimes() {
        return times;
    }
}