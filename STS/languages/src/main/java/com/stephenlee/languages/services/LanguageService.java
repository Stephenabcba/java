package com.stephenlee.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.languages.models.Language;
import com.stephenlee.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	// Option 2, can skip private final + constructor
	@Autowired
	private LanguageRepository langRepo;

	// returns all the books
	public List<Language> allLanguages() {
		return langRepo.findAll();
	}

	// creates a book
	public Language createLanguage(Language b) {
		return langRepo.save(b);
	}

	// retrieves a book
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = langRepo.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}

	public Language updateLanguage(Long id, Language language) {
		Optional<Language> optionalLanguage = langRepo.findById(id);
		if (optionalLanguage.isPresent()) {
			language.setId(id);
			return langRepo.save(language);
		} else {
			return null;
		}
	}

	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}
}
