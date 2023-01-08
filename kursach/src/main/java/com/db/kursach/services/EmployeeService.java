package com.db.kursach.services;

import com.db.kursach.models.Employee;
import com.db.kursach.models.Image;
import com.db.kursach.repositories.EmployeeRepository;
import com.db.kursach.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ImageRepository imageRepository;

    public List<Employee> listEmployees(String fullName){
        if(fullName!=null) return employeeRepository.findByFullNameContaining(fullName);
        return employeeRepository.findAll();
    }
    public void saveEmployee(Employee employee, MultipartFile file) throws IOException {
        Image image;
        if(file.getSize()!=0){
            image=toImageEntity(file);
            //тут если что превьюшку тру делать
            employee.addImageToEmployee(image);
        }
        log.info("Saving new Employee.{}",employee);
        //Employee employeeFromDB=employeeRepository.save(employee);
        //employeeFromDB.setPreviewImageId(employeeFromDB.getImages().get(0).getId());
        employeeRepository.save(employee);
    }
    public void saveImage( MultipartFile file,Long id) throws IOException {
        Image image;
        image = toImageEntity(file);
        List<Image> images=new ArrayList<>();
        images.add(image);
        Employee employee=employeeRepository.findById(id).orElseThrow();
        employee.setImages(images);
        //employee.setPreviewImageId(image.getId()); // что за ебанина
        employee.addImageToEmployee(image);
        employeeRepository.save(employee);

        /*System.out.println(employee.getImages().get(0).getOriginalFileName());
        System.out.println(employee.getFullName());*/
        /*if(file.getSize()!=0) {
            image = toImageEntity(file);
            List<Image> images=new ArrayList<>();
            images.add(image);
            Employee employee=employeeRepository.findById(id).orElseThrow();
            employee.addImageToEmployee(image);
            employee.setImages(images);
            //employee.setPreviewImageId(image.getId());
            //employeeRepository.save(employee);
            //employeeRepository.findById(employee.getId()).orElse(null).addImageToEmployee(image);
            //employeeRepository.findById(employee.getId()).orElse(null).setPreviewImageId(image.getId());
        }*/
    }


    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image=new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

}
