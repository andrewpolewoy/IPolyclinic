package com.it_academy.jd2.config;

import com.it_academy.jd2.service.AuthProvider;
import com.it_academy.jd2.service.api.doctor.IDepartmentService;
import com.it_academy.jd2.service.api.doctor.IDoctorInfoService;
import com.it_academy.jd2.service.api.doctor.ISpecializationService;
import com.it_academy.jd2.service.api.patient.IDiagnosisService;
import com.it_academy.jd2.service.api.patient.IMedicalCardService;
import com.it_academy.jd2.service.api.patient.ITicketService;
import com.it_academy.jd2.service.api.user.IAddressService;
import com.it_academy.jd2.service.api.user.IPassportService;
import com.it_academy.jd2.service.api.user.IUserService;
import com.it_academy.jd2.service.doctor.DoctorInfoService;
import com.it_academy.jd2.service.doctor.SpecializationService;
import com.it_academy.jd2.service.patient.DepartmentService;
import com.it_academy.jd2.service.patient.DiagnosisService;
import com.it_academy.jd2.service.patient.MedicalCardService;
import com.it_academy.jd2.service.patient.TicketService;
import com.it_academy.jd2.service.user.AddressService;
import com.it_academy.jd2.service.user.PassportService;
import com.it_academy.jd2.service.user.UserService;
import com.it_academy.jd2.storage.api.medicalCard.*;
import com.it_academy.jd2.storage.api.people.*;
import com.it_academy.jd2.storage.api.medicalCard.IMedicalCardRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.it_academy.jd2.config")
public class RootConfig {


//    @Bean
//    public IUserService userView(IUserRepository repository, PasswordEncoder passwordEncoder) {
//        return new UserService(repository , passwordEncoder);
//    }
    @Bean
    public IUserService userView(IUserRepository userRepository,
                                    IDepartmentRepository departmentRepository,
                                    ISpecializationRepository specializationRepository,
                                    IDoctorInfoRepository doctorInfoRepository){
        return new UserService(userRepository, departmentRepository, specializationRepository, doctorInfoRepository);
    }

    @Bean
    public IPassportService passportView(IPassportRepository repository) {
        return new PassportService(repository);
    }

    @Bean
    public IAddressService addressView(IAddressRepository repository) {
        return new AddressService(repository);
    }

    @Bean
    public IMedicalCardService medicalCardView( IMedicalCardRepository repository) {
        return new MedicalCardService(repository);
    }

    @Bean
    public IDiagnosisService diagnosisView(IDiagnosisRepository repository) {
        return new DiagnosisService(repository);
    }

    @Bean
    public IDepartmentService departmentView(IDepartmentRepository repository) {
        return new DepartmentService(repository);
    }

    @Bean
    public IDoctorInfoService doctorInfoService(IDoctorInfoRepository doctorInfoRepository){
        return new DoctorInfoService(doctorInfoRepository);
    }

    @Bean
    public ISpecializationService specializationService(ISpecializationRepository specializationRepository){
        return new SpecializationService(specializationRepository);
    }
//    @Bean
//    public AuthProvider authProvider(IUserService userService){
//        return new AuthProvider(userService);
//    }
    @Bean
    public IAddressService addressService(IAddressRepository addressRepository){
        return new AddressService(addressRepository);
    }
    @Bean
    public ITicketService ticketService(ITicketRepository ticketRepository, IUserRepository userRepository){
        return new TicketService(ticketRepository, userRepository);
    }
}
