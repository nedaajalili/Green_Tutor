package it.polito.neda.service;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test {

	public static void main(String[] args) {
		RestClient rc = new RestClient();
		System.out.println(rc.getLuminicityNumber());
	}

}
