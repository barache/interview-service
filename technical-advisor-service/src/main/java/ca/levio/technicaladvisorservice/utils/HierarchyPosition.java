package ca.levio.technicaladvisorservice.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class HierarchyPosition {

    Map<Integer, String> java = new HashMap<>();

    @Bean
    public Map<Integer, String> javaHierarchyPosition(){
        java.put(1,"Java Architect");
        java.put(2,"Java developer Lead");
        java.put(3,"Java developer");
        return java;
    }

    public boolean eligibility(String jobPosition){

        for (Map.Entry<Integer, String> entry : java.entrySet()) {
            if (entry.getValue().equals(jobPosition)) {
                System.out.println(entry.getKey());
            }
        }

        if (java.containsValue(jobPosition)){
            return true;
        }

        return false;
    }

}
