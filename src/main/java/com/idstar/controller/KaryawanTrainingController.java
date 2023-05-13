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
import com.idstar.model.KaryawanTraining;
import com.idstar.service.KaryawanTrainingService;

@RestController
@RequestMapping("/v1/idstar/karyawan-training")
public class KaryawanTrainingController {
	@Autowired
    public KaryawanTrainingService karyawanTrainingService;
	
	@PostMapping("/save")
    public ApiResponse<KaryawanTraining> save(@RequestBody KaryawanTraining param) {
        KaryawanTraining karyawanTraining = karyawanTrainingService.save(param);
        return new ApiResponse<>(HttpStatus.OK.value(), karyawanTraining, "sukses");
    }
	
	@PutMapping("/update")
    public ApiResponse<KaryawanTraining> update(@RequestBody KaryawanTraining param) {
        KaryawanTraining karyawanTraining = karyawanTrainingService.update(param);
        return new ApiResponse<>(HttpStatus.OK.value(), karyawanTraining, "sukses");
    }
	
	@GetMapping("/list")
    public ApiResponse<List<KaryawanTraining>> list(HttpServletRequest request) {
		
		int page = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("size"));

		int offset = 0;
		
		if (page <= 1) {
			offset = 0;
		} else {
			offset = ((page - 1) * limit);
		}
		
        List<KaryawanTraining> listKaryawanTraining = karyawanTrainingService.findAllCustom(offset, limit);
        return new ApiResponse<>(HttpStatus.OK.value(), listKaryawanTraining, "sukses");
    }
	
	@GetMapping("/{id}")
    public ApiResponse<KaryawanTraining> delete(@PathVariable int id) {
        KaryawanTraining karyawanTraining = karyawanTrainingService.findById(id);
        return new ApiResponse<>(HttpStatus.OK.value(), karyawanTraining, "sukses");
    }
	
	@DeleteMapping("/delete")
    public ApiResponse<String> findById(@RequestBody KaryawanTraining param) {
        karyawanTrainingService.delete(param.getId());
        return new ApiResponse<>(HttpStatus.OK.value(), "sukses", "sukses");
    }


}
