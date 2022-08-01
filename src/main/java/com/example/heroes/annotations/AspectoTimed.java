package com.example.heroes.annotations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectoTimed {

    @Around("execution(* *(..)) && @annotation(time)")

    public Object timed(ProceedingJoinPoint pjp, Time time) throws Throwable {

        long instanteInicial = System.currentTimeMillis();

        Object resultado = null;

        Throwable throwable = null;

        try {

            resultado = pjp.proceed();

        } catch ( Throwable t ) {

            throwable = t;

        }

        long instanteFinal = System.currentTimeMillis();

        log.info("Invocacion de metodo: " + pjp.getSignature() + ", duracion: " + (instanteFinal - instanteInicial) + "ms");

        if ( throwable == null ) return resultado;

        throw throwable;

    }

}
