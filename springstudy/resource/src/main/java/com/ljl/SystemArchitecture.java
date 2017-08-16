package com.ljl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {
    @Before("execution(* com.ljl.dao.*.*(..))")
    public void doAccessCheck() {
        System.out.println("doAccessCheck");
    }
    /**
     * A join point is in the web layer if the method is defined
     * in a type in the com.ljl.web package or any sub-package
     * under that.
     */
    @Pointcut("within(com.ljl.web..*)")
    public void inWebLayer() {
        System.out.println("inWebLayer");
    }

    /**
     * A join point is in the service layer if the method is defined
     * in a type in the com.ljl.service package or any sub-package
     * under that.
     */
    @Pointcut("within(com.ljl.service..*)")
    public void inServiceLayer() {
        System.out.println("inServiceLayer");
    }

    /**
     * A join point is in the data access layer if the method is defined
     * in a type in the com.ljl.dao package or any sub-package
     * under that.
     */
    @Pointcut("within(com.ljl.dao..*)")
    public void inDataAccessLayer() {
        System.out.println("inDataAccessLayer");
    }

    /**
     * A business service is the execution of any method defined on a service
     * interface. This definition assumes that interfaces are placed in the
     * "service" package, and that implementation types are in sub-packages.
     *
     * If you group service interfaces by functional area (for example,
     * in packages com.ljl.abc.service and com.ljl.def.service) then
     * the pointcut expression "execution(* com.ljl..service.*.*(..))"
     * could be used instead.
     *
     * Alternatively, you can write the expression using the 'bean'
     * PCD, like so "bean(*Service)". (This assumes that you have
     * named your Spring service beans in a consistent fashion.)
     */
    @Pointcut("execution(* com.ljl..service.*.*(..))")
    public void businessService() {
        System.out.println("businessService");
    }

    /**
     * A data access operation is the execution of any method defined on a
     * dao interface. This definition assumes that interfaces are placed in the
     * "dao" package, and that implementation types are in sub-packages.
     */
    @Pointcut("execution(* com.ljl.dao.*.*(..))")
    public void dataAccessOperation() {
        System.out.println("dataAccessOperation");
    }

}