package fr.edu.aix.yuccaspringboot.log;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author omignot
 * Classe AspectJ utilisee pour les logs
 * les pointcuts sont de la forme
 * "execution(
 * 			Return type
 * 			Package
 * 			Class
 * 			Method
 * 			(Arguments))"
 * 
 */
@Slf4j
@Aspect
@Component
public class LoggingAspect {

	/**
	 * Le pointcut intercepte toutes les méthodes de 
	 * toutes les classes dans le package fr.edu.aix.yuccaspringboot
	 * @param joinPoint
	 */
	@Before(value = "execution(* fr.edu.aix.yuccaspringboot.*.*.*(..))")
	public void beforeCorrectionController(JoinPoint joinPoint) {
		writeToLog("Before", joinPoint);
	}
	
	/**
	 * Le pointcut intercepte toutes les méthodes de 
	 * toutes les classes dans le package fr.edu.aix.yuccaspringboot
	 * @param joinPoint
	 */
	@After(value = "execution(* fr.edu.aix.yuccaspringboot.*.*.*(..))")
	public void afterCorrectionController(JoinPoint joinPoint) {
		writeToLog("After", joinPoint);
	}
	
	/**
	 * Le pointcut intercepte toutes les méthodes de 
	 * toutes les classes dans le package fr.edu.aix.yuccaspringboot
	 * @param joinPoint
	 */
	@AfterReturning(pointcut = "execution(* fr.edu.aix.yuccaspringboot.*.*.*(..))",
			returning = "result")
	public void afterReturningCorrectionController(JoinPoint joinPoint, Object result) {
		writeToLog("AfterReturning", joinPoint);
		log.info("[Resultat] " + result);
	}
	
	/**
	 * Le Around sert à pouvoir autoriser la methode interceptée
	 * à s'executer pour ainsi catcher les exceptions
	 * C'est une annotation avant même l'annotation Before
	 * Difference entre ProceedingJoinPoint et JoinPoint : proceed()
	 * Peut causer des erreurs avec Thymeleaf
	 * @throws Throwable 
	 * @param pjp
	 */
	/*
	@Around("execution(* fr.edu.aix.yuccaspringboot.controller.ProgrammeController.listProgrammes(..))")
	public void aroundCorrection(ProceedingJoinPoint pjp) throws Throwable{
		writeToLog("BeforeExecution", pjp);
	    Object[] arguments = pjp.getArgs();
	    for (Object object : arguments) {
	        log.info("Arguments : " + object);
	    }
	    try {
	        pjp.proceed();
	        writeToLog("AfterExecution", pjp);
	        log.info("Pas d'erreur(s)");
	    } catch (Exception e) {
	        log.error(e.getMessage());
	    }
	} */
	
	public void writeToLog(String when, JoinPoint joinPoint) {
		StringBuilder builder = new StringBuilder().append(" ["+when+"] ");
        builder.append("[Class] ").append(joinPoint.getTarget().getClass().getSimpleName()).append(" [method] ").append(joinPoint.getSignature());
        builder.append(" [args] ").append(Arrays.toString(joinPoint.getArgs()));
        log.info(builder.toString());
	}

}
