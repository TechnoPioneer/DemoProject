package com.example.FirstProject.aspect;


import com.example.FirstProject.model.Player;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.FirstProject.controller.PlayerController.*(..))")
    public void BeforeLogger() {
        System.out.println("Before method Loggers");
    }

    @After("execution(* com.example.FirstProject.controller.PlayerController.*(..))")
    public void AfterLogger() {
        System.out.println("after method Loggers");
    }

    @Before("execution(* com.example.FirstProject.controller.PlayerController.player(..))")
    public void BeforePlayerMethodLogger(JoinPoint joinPoint) {
        String ids = joinPoint.getArgs()[0].toString();
        Integer id = Integer.valueOf(ids);
        System.out.println("Before method Loggers id " + id);
    }


    @Pointcut("within(com.example.FirstProject.controller.*)")
    public void withinController() {

    }

    @Before("withinController()")
    public void authenticate() {
        System.out.println("For every method");
    }

    @AfterReturning(pointcut = "afterPlayers()", returning = "retVal")
    public void afterReturningPlayers(List<Player> retVal) {

        retVal.stream().forEach(player -> System.out.println("Player: "+player.getId()));
        System.out.println("return value of players " + retVal);
    }

    @Pointcut("execution(* com.example.FirstProject.controller.PlayerController.getAllPlayers()))")
    public void afterPlayers() {

    }

}
