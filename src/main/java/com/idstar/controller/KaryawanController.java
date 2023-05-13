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
import com.idstar.model.Karyawan;
import com.idstar.service.KaryawanService;

@RestController
@RequestMapping("/v1/idstar/karyawan")
public class KaryawanController {
	@Autowired
    public KaryawanService karyawanService;
	
	@PostMapping("/save")
    public ApiResponse<Karyawan> save(@RequestBody Karyawan param) {
        Karyawan karyawan = karyawanService.save(param);
        return new ApiResponse<>(HttpStatus.OK.value(), karyawan, "sukses");
    }
	
	@PutMapping("/update")
    public ApiResponse<Karyawan> update(@RequestBody Karyawan param) {
        Karyawan karyawan = karyawanService.update(param);
        return new ApiResponse<>(HttpStatus.OK.value(), karyawan, "sukses");
    }
	
	@GetMapping("/list")
    public ApiResponse<List<Karyawan>> list(HttpServletRequest request) {
		
		int page = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("size"));

		int offset = 0;
		
		if (page <= 1) {
			offset = 0;
		} else {
			offset = ((page - 1) * limit);
		}
		
        List<Karyawan> listKaryawan = karyawanService.findAllCustom(offset, limit);
        return new ApiResponse<>(HttpStatus.OK.value(), listKaryawan, "sukses");
    }
	
	@GetMapping("/{id}")
    public ApiResponse<Karyawan> delete(@PathVariable int id) {
        Karyawan karyawan = karyawanService.findById(id);
        return new ApiResponse<>(HttpStatus.OK.value(), karyawan, "sukses");
    }
	
	@DeleteMapping("/delete")
    public ApiResponse<String> findById(@RequestBody Karyawan param) {
        karyawanService.delete(param.getId());
        return new ApiResponse<>(HttpStatus.OK.value(), "sukses", "sukses");
    }


}
