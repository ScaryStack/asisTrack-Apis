package com.duocdevs.asistrack.service;

import com.duocdevs.asistrack.model.Request;
import com.duocdevs.asistrack.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Request saveRequest(Request request) {
        return requestRepository.save(request);
    }

    public Request getRequestById(Integer id) {
        return requestRepository.findById(id).orElse(null);
    }

    public void deleteRequest(Integer id) {
        requestRepository.deleteById(id);
    }
}