package com.turbulence6th.portfolio.manager;

import com.turbulence6th.portfolio.entity.Request;
import com.turbulence6th.portfolio.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class RequestManager {

    private RequestRepository requestRepository;

    @Autowired
    public RequestManager(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Transactional
    public void save(String ip) {
        LocalDate now = now();
        Request request = requestRepository.findByIpAndDate(ip, now).orElseGet(() -> newRequest(ip, now));
        request.setCount(request.getCount() + 1);
        requestRepository.save(request);
    }

    private Request newRequest(String ip, LocalDate now) {
        Request request = new Request();
        request.setIp(ip);
        request.setDate(now);
        return request;
    }

    LocalDate now() {
        return LocalDate.now();
    }
}
