package com.service;

import com.dao.TaskRepo;
import com.modal.Persons;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PersonService {

    private final TaskRepo taskRepo;


    public PersonService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }


    public List<Persons> findAll(){
        List<Persons> personsList = new ArrayList<Persons>();
        for (Persons person:taskRepo.findAll()) {
            personsList.add(person);
        }

        return personsList;
    }


    public void save(Persons persons){
        taskRepo.save(persons);
    }

    public void delete(int id){
        taskRepo.delete(id);
    }


}
