package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.jwt.JwtUtils;
import com.c0821g1.sprint1.payload.request.LoginRequest;
import com.c0821g1.sprint1.payload.response.JwtResponse;
import com.c0821g1.sprint1.service.account.impl.MyUserDetailsImpl;
import com.c0821g1.sprint1.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class SecurityController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${secretPsw}")
    String secretPsw;


    // Đăng Nhập (NghiaDM)
    @PostMapping("/login")
    public ResponseEntity<Object> authenticateUser(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest.getUsername());
        System.out.println(loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        MyUserDetailsImpl myUserDetails = (MyUserDetailsImpl) authentication.getPrincipal();
        // lấy token từ phương thức generateToken bên class jwtUtils đưa qua front end
        String jwtToken = jwtUtils.generateToken(myUserDetails);
        System.out.println("token" + jwtToken);


        List<String> roles = myUserDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        JwtResponse jwtResponse = new JwtResponse();
        String urlImgDefault = "https://cdyduochopluc.edu.vn/wp-content/uploads/2019/07/anh-dai-dien-FB-200-1.jpg";

        Employee employee = employeeService.getEmployeeByUsername(myUserDetails.getUsername());
        System.out.println(employee.getEmployeeName());


        // Lấy thông tin từ nhân viên đã đăng nhập bỏ vào Lớp JwtResponse đưa qua front end
        jwtResponse.setName(employee.getEmployeeName());
        jwtResponse.setJwtToken(jwtToken);
        jwtResponse.setUsername(myUserDetails.getUsername());
        jwtResponse.setEmail(employee.getEmployeeEmail());
        jwtResponse.setGender(employee.getEmployeeGender());
        jwtResponse.setDayOfBirth(employee.getEmployeeDateOfBirth());
        jwtResponse.setAddress(employee.getEmployeeAddress());
        jwtResponse.setPhone(employee.getEmployeePhone());
        jwtResponse.setRoles(roles);
        jwtResponse.setIdEmployee(employee.getEmployeeId());
        jwtResponse.setUrlImg(employee.getEmployeeImage() == null ? urlImgDefault : employee.getEmployeeImage());

        return ResponseEntity.ok(jwtResponse);


    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}

