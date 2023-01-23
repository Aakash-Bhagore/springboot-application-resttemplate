package com.springboot.resttemplate.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.resttemplate.controller.CollegeController;
import com.springboot.resttemplate.entity.College;
import com.springboot.resttemplate.service.CollegeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
/*
 JUnit with Mockito
*/
@WebMvcTest(value = CollegeController.class)
public class CollegeControllerTest {

  @MockBean
  private CollegeService collegeService;

  @Autowired
  private MockMvc mockMvc;

  //Get
  @Test
  public void collegeControllerSuccessTest() throws Exception {

    College college = new College(2l,"SDBCE", LocalDate.of(2023,01,20));
    Mockito.when(collegeService.getCollege(2l)).thenReturn(college);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/college/2");
    ResultActions perform = mockMvc.perform(requestBuilder);
    MvcResult mvcResult = perform.andReturn();
    MockHttpServletResponse response =mvcResult.getResponse();

    int statusCode = response.getStatus();
    Assertions.assertEquals(200,statusCode);
    Assertions.assertNotNull(response);
    Assertions.assertSame(college,collegeService.getCollege(2L));
    Assertions.assertTrue(response!=null);
  }

  //post
  @Test
  public void saveCollegeSuccessTest() throws Exception {
    /*
     Remember one thing if have mocked one object then you can write test cases against that only else it wouldn't work
     example:- suppose here if we mock college object, we can't test it against college1 object and if we wouldn't mock college1
     Means whatever object you have mocked only against that object you can perform assertions
    */
    College college = new College();
    college.setId(20l);
    college.setCollegeName("SDBCO");

    College college1 = new College();
    college1.setId(21l);
    college1.setCollegeName("SDBCO");

    Mockito.when(this.collegeService.saveCollege(college)).thenReturn(college);
    Mockito.when(this.collegeService.saveCollege(college1)).thenReturn(college1);

    ObjectMapper objectMapper = new ObjectMapper();
    String bookJson = objectMapper.writeValueAsString(college);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/college/save")
                                                                .contentType(MediaType.APPLICATION_JSON)
                                                                .content(bookJson);

    MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();
    final int statusCode = response.getStatus();

    Assertions.assertEquals(200,statusCode);
    Assertions.assertNotNull(response);
    Assertions.assertTrue(!response.getContentAsString().isBlank());
    Assertions.assertSame(college.getCollegeName(),this.collegeService.saveCollege(college).getCollegeName());
    Assertions.assertSame(college1, this.collegeService.saveCollege(college1));
    Assertions.assertNotEquals(college,college1);
  }
}
