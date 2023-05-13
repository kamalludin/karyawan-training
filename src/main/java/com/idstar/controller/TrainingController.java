package com.idstar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idstar.dto.ApiResponse;
import com.idstar.model.Training;
import com.idstar.service.TrainingService;

@RestController
@RequestMapping("/v1/idstar/training")
public class TrainingController {
	@Autowired
    public TrainingService trainingService;
	
	@PostMapping("/save")
    public ApiResponse<Training> save(@RequestBody Training param) {
        Training training = trainingService.save(param);
        return new ApiResponse<>(HttpStatus.OK.value(), training, "sukses");
    }
	
	@PutMapping("/update")
    public ApiResponse<Training> update(@RequestBody Training param) {
        Training training = trainingService.update(param);
        return new ApiResponse<>(HttpStatus.OK.value(), training, "sukses");
    }
	
	@GetMapping("/list")
    public ApiResponse<List<Training>> list(HttpServletRequest request) {
		
		int page = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("size"));

		int offset = 0;
		
		if (page <= 1) {
			offset = 0;
		} else {
			offset = ((page - 1) * limit);
		}
		
        List<Training> listTraining = trainingService.findAllCustom(offset, limit);
        return new ApiResponse<>(HttpStatus.OK.value(), listTraining, "sukses");
    }
	
	@GetMapping("/{id}")
    public ApiResponse<Training> delete(@PathVariable int id) {
        Training training = trainingService.findById(id);
        return new ApiResponse<>(HttpStatus.OK.value(), training, "sukses");
    }
	
	@DeleteMapping("/delete")
    public ApiResponse<String> findById(@RequestBody Training param) {
        trainingService.delete(param.getId());
        return new ApiResponse<>(HttpStatus.OK.value(), "sukses", "sukses");
    }


}
