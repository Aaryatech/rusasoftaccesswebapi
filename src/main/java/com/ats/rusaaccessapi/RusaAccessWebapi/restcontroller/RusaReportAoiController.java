package com.ats.rusaaccessapi.RusaAccessWebapi.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.Program;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.ProgramType;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.ProgramRepository;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.ProgramTypeRepo;

@RestController
public class RusaReportAoiController {

	@Autowired
	ProgramTypeRepo programTypeRepo;

	@RequestMapping(value = { "/getAllProgramType" }, method = RequestMethod.GET)
	public @ResponseBody List<ProgramType> getAllProgramType() {

		List<ProgramType> progTypeList = new ArrayList<>();

		try {
		progTypeList = programTypeRepo.findByDelStatusAndIsActiveAndSequenceNotIn(1	, 1, "0");	

		} catch (Exception e) {
			System.err.println("Exce in getAllProgramType  " + e.getMessage());
			e.printStackTrace();
		}

		return progTypeList;

	}
	
	@Autowired
	ProgramRepository programRepository;
	@RequestMapping(value = { "/getProgramByProgramTypeId" }, method = RequestMethod.POST)
	public @ResponseBody List<Program> getProgramByProgramTypeId(@RequestParam("programTypeId") int programTypeId,@RequestParam("instituteId") int instituteId ) {

		List<Program> list = new ArrayList<Program>();

		try {

			list = programRepository.findByProgramTypeAndDelStatusAndInstituteId(programTypeId, 1, instituteId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}
	
}
