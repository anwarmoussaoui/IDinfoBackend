package com.example.auth.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController


public class FlaskController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/api")
    public ResponseEntity<IDcard> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        String flaskUrl = "http://localhost:5000/upload";

        // Prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Prepare the file as part of the request body
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));

        // Create the request entity
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        // Send the POST request
        ResponseEntity<IDcard> flaskResponse = restTemplate.exchange(flaskUrl, HttpMethod.POST, requestEntity, IDcard.class);

        // Return the Flask response as an IDCard object
        return ResponseEntity.ok(flaskResponse.getBody());
    }



}
