package com.example.template.example.controller;

import com.example.template.example.model.Example;
import com.example.template.example.service.IExampleService;
import com.example.template.util.RestHelper;
import com.example.template.util.RestResponse;
import jakarta.validation.Valid;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/example")
public class ExampleController {

  private final IExampleService exampleService;

  public ExampleController(IExampleService exampleService) {
    this.exampleService = exampleService;
  }

  /**
   * Fetches the example by identifier.
   *
   * @param id The unique identifier of the example.
   * @return The example entity.
   */
  @GetMapping("/{id}/")
  public ResponseEntity<RestResponse> findById(@PathVariable long id) {
    HashMap<String, Object> listHashMap = new HashMap<>();
    listHashMap.put("example", exampleService.findById(id));
    return RestHelper.responseSuccess(listHashMap);
  }

  /**
   * Fetches all the example entities in the system.
   *
   * @return The list of example entities.
   */
  @GetMapping()
  public ResponseEntity<RestResponse> findAll() {
    HashMap<String, Object> listHashMap = new HashMap<>();
    listHashMap.put("exampleList", exampleService.findAll());
    return RestHelper.responseSuccess(listHashMap);
  }

  /**
   * Saves the new example entity.
   *
   * @param example The entity to be saved.
   * @return The saved entity.
   */
  @PostMapping("/")
  public ResponseEntity<RestResponse> save(@Valid Example example) {
    HashMap<String, Object> listHashMap = new HashMap<>();
    listHashMap.put("example", exampleService.save(example));
    return RestHelper.responseSuccess(listHashMap);
  }

  /**
   * Updates the existing example entity.
   *
   * @param example The updated example entity.
   * @return The message indicating the confirmation on updated example entity.
   */
  @PatchMapping("/")
  public ResponseEntity<RestResponse> update(@Valid Example example) {
    String message = exampleService.update(example);
    return RestHelper.responseMessage(message);
  }

  /**
   * Deletes the example entity by id.
   *
   * @param id The unique identifier of the entity.
   * @return The message indicating the confirmation on deleted example entity.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<RestResponse> update(@PathVariable long id) {
    String message = exampleService.deleteById(id);
    return RestHelper.responseMessage(message);
  }
}
