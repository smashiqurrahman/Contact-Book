package com.ashiq.contactbook.util;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Endpoint(id = "release-note")
public class CustomEndpoint {
	Map<String, List<String>> releaseNotesMap = new LinkedHashMap<>();

	@PostConstruct
	public void initNotes() {
		releaseNotesMap.put("version-1.0", Arrays.asList("Home page created", "Adding a new item for added"));
		releaseNotesMap.put("version-1.1", Arrays.asList("Footer page created", "Adding a new item for added"));
	}

	@ReadOperation
	public Map<String, List<String>> getReleaseNotes() {
		return releaseNotesMap;
	}

	@ReadOperation
	public List<String> getNotesByVersion(@Selector String version) {
		return releaseNotesMap.get(version);
	}

	@WriteOperation
	public void addReleaseNotes(@Selector String version, String releaseNotes) {
		releaseNotesMap.put(version, Arrays.stream(releaseNotes.split(",")).collect(Collectors.toList()));
	}

	@DeleteOperation
	public void deleteNotes(String version) {
		releaseNotesMap.remove(version);
	}
}
