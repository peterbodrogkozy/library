package com.epam.training.imagine.controller.librarian;

import com.epam.training.imagine.service.GenericBusinessService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class AbstractRestController<T, ID extends Serializable> {

    private final GenericBusinessService<T, ID> businessService;

    public AbstractRestController(GenericBusinessService<T, ID> businessService) {
        this.businessService = businessService;
    }

    @GetMapping
    public @ResponseBody List<T> findAll() {
        Iterable<T> allObject = businessService.findAll();
        return StreamSupport.stream(allObject.spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public @ResponseBody T get(@PathVariable ID id) {
        return businessService.findById(id);
    }

    @PostMapping(consumes={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody T save(@RequestBody T body) {
        return businessService.save(body);
    }

    @PostMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody T update(@PathVariable ID id, @RequestBody T body){
        T object = businessService.findById(id);

        try {
            BeanUtils.copyProperties(object, body);
        }
        catch (Exception e) {
            //TODO: fix exception
            throw new RuntimeException();
        }

        return businessService.save(object);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody T delete(@PathVariable ID id){
        T object = businessService.findById(id);
        businessService.remove(object);
        //TODO: fix it
        return object;
    }
}
