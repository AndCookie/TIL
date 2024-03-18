package net.kdigital.hackathon.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.hackathon.mapper.PortMapper;
@Service
@Slf4j
public class PortService {
	
	@Autowired
	PortMapper mapper;
	
	
	
}
