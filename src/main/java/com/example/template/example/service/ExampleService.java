package com.example.template.example.service;

import static com.example.template.util.constant.ExampleConstant.DELETED_SUCCESSFULLY_MESSAGE;
import static com.example.template.util.constant.ExampleConstant.EXAMPLE;
import static com.example.template.util.constant.ExampleConstant.NOT_FOUND_MESSAGE;
import static com.example.template.util.constant.ExampleConstant.UPDATED_SUCCESSFULLY_MESSAGE;

import com.example.template.example.model.Example;
import com.example.template.example.repository.ExampleRepository;
import com.example.template.util.exception.GlobalExceptionWrapper.NotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ExampleService implements IExampleService {

  private final ExampleRepository exampleRepository;

  public ExampleService(ExampleRepository exampleRepository) {
    this.exampleRepository = exampleRepository;
  }

  @Override
  public List<Example> findAll() {
    return this.exampleRepository.findAll();
  }

  @Override
  public Example save(@NonNull Example entity) {
    return this.exampleRepository.save(entity);
  }

  @Override
  public Example findById(long id) {
    return this.exampleRepository.findById(id).orElseThrow(
        () -> new NotFoundException(String.format(NOT_FOUND_MESSAGE, EXAMPLE.toLowerCase())));
  }

  @Override
  public String update(@NonNull Example entity) {
    this.exampleRepository.save(entity);
    return String.format(UPDATED_SUCCESSFULLY_MESSAGE, EXAMPLE);
  }

  @Override
  @Transactional
  public String deleteById(long id) {
    findById(id);
    this.exampleRepository.deleteById(id);
    return String.format(DELETED_SUCCESSFULLY_MESSAGE, EXAMPLE);
  }
}
