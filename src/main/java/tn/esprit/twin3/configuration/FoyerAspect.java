package tn.esprit.twin3.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class FoyerAspect { // for SOP
    // after throwing if there is an error
    // after returning when success
    // Around to calculate execution time --> performance

   // @Before("execution(* tn.esprit.twin3.Services.*.*(..))" )// before executing all the methods in service .. to day 0 or * parameters and first * to say type of return
   //  @After("execution(* tn.esprit.twin3.Services.*.*(..))" )
   // @AfterThrowing("execution(* tn.esprit.twin3.Services.*.*(..))" )
    @AfterReturning("execution(* tn.esprit.twin3.Services.*.retrieve*(..))" ) // just the recuperation services
    void aop(JoinPoint joinPoint){
        joinPoint.getSignature().getName();// to get sig of a function --> get name
        joinPoint.getSignature().getClass().getPackageName();
        log.info("Avant l'execution de la méthode: "+joinPoint.getSignature().getName());
    }
}
