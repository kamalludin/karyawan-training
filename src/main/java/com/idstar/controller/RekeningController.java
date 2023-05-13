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
import com.idstar.model.Rekening;
import com.idstar.service.RekeningService;

@RestController
@RequestMapping("/v1/idstar/rekening")
public class RekeningController {
	@Autowired
    public RekeningService rekeningService;
	
	@PostMapping("/save")
    public ApiResponse<Rekening> save(@RequestBody Rekening param) {
        Rekening rekening = rekeningService.save(param);
        return new ApiResponse<>(HttpStatus.OK.value(), rekening, "sukses");
    }
	
	@PutMapping("/update")
    public ApiResponse<Rekening> update(@RequestBody Rekening param) {
        Rekening rekening = rekeningService.update(param);
        return new ApiResponse<>(HttpStatus.OK.value(), rekening, "sukses");
    }
	
	@GetMapping("/list")
    public ApiResponse<List<Rekening>> list(HttpServletRequest request) {
		
		int page = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("size"));

		int offset = 0;
		
		if (page <= 1) {
			offset = 0;
		} else {
			offset = ((page - 1) * limit);
		}
		
        List<Rekening> listRekening = rekeningService.findAllCustom(offset, limit);
        return new ApiResponse<>(HttpStatus.OK.value(), listRekening, "sukses");
    }
	
	@GetMapping("/{id}")
    public ApiResponse<Rekening> delete(@PathVariable int id) {
        Rekening rekening = rekeningService.findById(id);
        return new ApiResponse<>(HttpStatus.OK.value(), rekening, "sukses");
    }
	
	@DeleteMapping("/delete")
    public ApiResponse<String> findById(@RequestBody Rekening param) {
        rekeningService.delete(param.getId());
        return new ApiResponse<>(HttpStatus.OK.value(), "sukses", "sukses");
    }


}
