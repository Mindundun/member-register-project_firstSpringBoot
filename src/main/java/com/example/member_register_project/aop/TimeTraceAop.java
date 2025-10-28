package com.example.member_register_project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* com.example.member_register_project..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : "+joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : "+joinPoint.toString() + " "+ timeMs + "ms");
        }

        
    }
}

/*
START : execution(String com.example.member_register_project.controller.MemberController.list(Model))
START : execution(List com.example.member_register_project.service.MemberService.findMembers())
START : execution(List org.springframework.data.repository.ListCrudRepository.findAll())
Hibernate: select m1_0.id,m1_0.name from member m1_0
END : execution(List org.springframework.data.repository.ListCrudRepository.findAll()) 191ms
END : execution(List com.example.member_register_project.service.MemberService.findMembers()) 193ms
END : execution(String com.example.member_register_project.controller.MemberController.list(Model)) 200ms
*/